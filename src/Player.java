import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Klassen Player representerar en spelare i Blackjack-spelet.
class Player {
    protected List<Card> hand;
    //Detta är spelarens hand som innehåller kort.
    public Player() {
        hand = new ArrayList<>();
        // Den initierar spelarens hand genom att skapa en ny ArrayList.
    }

    public void addCard(Card card) {
        hand.add(card);
        //En metod som lägger till ett kort i spelarens hand.
    }

    public int getHandValue() {
        //En metod som returnerar värdet av spelarens hand.
        int value = 0;
        int aceCount = 0;

        for (Card card : hand) {
            value += card.getValue();
            if (card.getRank().equals("A")) {
                aceCount++;
        //summerar kortens värden.
        //Om ett kort är ett ess ("A") räknas det som 1
        //totala summan av handen kontrolleras om värdet är över 21 och om det finns ess i handen.
            }
        }

        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        //om det ovan stämmer minskas värdet med 10 och antalet ess minskar.
        }

        return value;
        //Sedan returneras det beräknade värdet.
    }

    public void displayHand() {
        for (Card card : hand) {
            System.out.println(card);
            // En metod som visar spelarens hand(skriver ut den)
        }
    }
}
