import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Klassen Blackjack representerar själva spelet.
public class Blackjack {
    private List<Card> deck;
    private Player player;
    private Dealer dealer;
    private Scanner scanner;
    // privata instans variabler
    public Blackjack() {
        deck = createDeck();
        shuffleDeck();
        player = new Player();
        dealer = new Dealer();
        scanner = new Scanner(System.in);
    }
    // konstruktorn
    public void playGame() {
        dealInitialCards();
        //delar ut kort
        System.out.println("Din hand:");
        player.displayHand();
        //skriver ut spelarens hand
        System.out.println("Dealerns hand:");
        dealer.displayPartialHand();
        //skriver ut dealerns patiella hand genom att anropa "Displaypartialhand" från dealer objektet
        // Spelaren spelar
        while (true) {
            System.out.println("Vill du ta ett kort till? (J/N)");
            String choice = scanner.nextLine();
            //frågar om spelaren vill ha ett till kort
            if (choice.equalsIgnoreCase("J")) {
                player.addCard(deck.remove(deck.size() - 1));
                System.out.println("Din hand:");
                player.displayHand();
            //om j (oavsett små eller stora bokstäver) får spelaren ett till kort genom att ta bort det sista kortet i "deck"
                if (player.getHandValue() > 21) {
                    System.out.println("Du förlorade! Över 21 poäng.");
                    return;
                    //Skriver ut spelarens hand och kontrollerar om spelarens poäng överstiger 21. Om det gör det, skrivs "Du förlorade! Över 21 poäng." ut och metoden avslutas.
                }
            } else if (choice.equalsIgnoreCase("N")) {
                break;
                //Om svaret är "N" (oavsett om det är stora eller små bokstäver), bryts loopen.
            }
        }

        // Dealern spelar
        System.out.println("Dealerns hand:");
        dealer.displayHand();
        //Skriver ut dealerns hand genom att anropa metoden displayHand() från dealer-objektet.

        while (dealer.getHandValue() < 17) {
            dealer.addCard(deck.remove(deck.size() - 1));
        }
        //Dealern drar kort tills deras handvärde är mindre än 17 genom att ta bort det sista kortet från kortleken och lägger till det till dealerns hand.
        int playerScore = player.getHandValue();
        int dealerScore = dealer.getHandValue();
        //Hämtar spelarens poäng och dealerns poäng.
        System.out.println("Din hand: (" + playerScore + " poäng)");
        player.displayHand();
        //Skriver ut spelarens hand med poäng och dealerns hand med poäng.
        System.out.println("Dealerns hand: (" + dealerScore + " poäng)");
        dealer.displayHand();
        if (playerScore > 21) {
            System.out.println("Du förlorade! Över 21 poäng.");
        } else if (dealerScore > 21) {
            System.out.println("Du vann! Dealern har över 21 poäng.");
        } else if (playerScore > dealerScore) {
            System.out.println("Du vann!");
        } else if (playerScore < dealerScore) {
            System.out.println("Du förlorade!");
        } else {
            System.out.println("Oavgjort!");
        }
    }
    //Kontrollerar olika fall för spelaren baserat på poängen för dealern och player

    private List<Card> createDeck() {
        List<Card> deck = new ArrayList<>();
        //Skapar en ny lista av objektet "Card" med hjälp av ArrayList-klassen och tilldelar den till variabeln "deck".
        String[] suits = {"Hjärter", "Spader", "Ruter", "Klöver"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        //Skapar en array av strängar som innehåller de olika färgerna i en kortlek
        //Skapar en array av strängar som innehåller de olika valörerna i en kortlek
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(rank, suit));
                //Två loops som itererar över varje färg och valör
                // Skapar ett nytt objekt av typen "Card" med den aktuella valören (rank) och färgen (suit) och lägger till det i "deck"-listan.
            }
        }

        return deck;
        //Returnerar "deck"-listan när loopen är klar.
    }

    private void shuffleDeck() {
        Random rnd = new Random();
        // Skapar en ny instans av "Random"-klassen för att kunna generera slumpmässiga tal.
        for (int i = deck.size() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Card temp = deck.get(index);
            deck.set(index, deck.get(i));
            deck.set(i, temp);
            //Genererar ett slumpmässigt tal
            //Hämtar kortet på positionen "index" i "deck"-listan och tilldelar det till variabeln "temp".
            //Ersätter kortet på positionen "i" i "deck"-listan med kortet som tidigare var på positionen "index".
        }
    }

    private void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            player.addCard(deck.remove(deck.size() - 1));
            dealer.addCard(deck.remove(deck.size() - 1));
            //Inleder en loop som itererar två gånger för att dela ut två kort till både spelaren och dealern.
            // Tar bort det sista kortet från "deck"-listan och lägger till det i spelarens kort genom att använda "addCard" metoden
            //gör det samma för dealern

        }
    }
}
