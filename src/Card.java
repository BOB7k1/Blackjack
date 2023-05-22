
 class Card {
    // Klassen Card representerar ett spelkort.
        private String rank;
        private String suit;
        //representerar kortets rang och färg
        public Card(String rank, String suit) {
            this.rank = rank;
            this.suit = suit;
        }
        //En konstruktor som tar emot rang och färg som parametrar när ett nytt Card-objekt skapas.

        public String getRank() {
            return rank;
        }
        //En metod som returnerar kortets rang.
        public String getSuit() {
            return suit;
        }
        //En metod som returnerar kortets färg.
        public int getValue() {
            if (rank.equals("A")) {
                return 11;
            } else if (rank.equals("K") || rank.equals("Q") || rank.equals("J")) {
                return 10;
            } else {
                return Integer.parseInt(rank);
            }
        }
        //  Kontrollerar om kortets rang är "A" (ess).Returnerar värdet 11 om kortet är ett ess.
        //  Returnerar värdet 10 om kortet är en kung, dam eller knekt.
        //  Konverterar rangen till ett heltal och returnerar det. Detta gäller för kort med rang mellan 2 och 10.

        @Override
        public String toString() {
            return rank + " " + suit;
        }
    }
        //Returnerar en sträng som består av rang och färg och skriver ut det
