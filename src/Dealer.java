// Klassen Dealer representerar dealern i Blackjack-spelet och ärver från Player.
//"extends Player" visar Dealer är en subklass av Player.
//tillgång till alla medlemsvariabler och metoder som finns i Player-klassen.
//Med andra ord ärver Dealer egenskaper från Player och kan använda dem i sin egen implementation.
class Dealer extends Player {
    public void displayPartialHand() {
        System.out.println("Första kortet: " + hand.get(0));
        System.out.println("Dolt kort");
    }
}
    // skriver ut en sträng som beskriver det första kortet i dealerns hand
    // skriver ut en sträng som beskriver att det finns ett dolt kort. Detta används för att representera att dealern
    // har ytterligare ett kort som inte avslöjas för spelarna. Detta kort kommer inte att skrivas ut på konsolen för
    // att behålla spänningen i spelet.