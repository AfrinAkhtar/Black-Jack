public class Card
{
    // Instance variables
    private String name = " ";
    private String suit = " ";

    // defult constructors 
    public Card(){

    }

    // constructors 
    public Card(String name, String suit) {
        this.name = name; 
        this.suit = suit; 
    }

    Card(int num) {
        if (num % 4 == 0)
            suit = "Diamonds";
        if (num % 4 == 1)
            suit = "Clubs";
        if (num % 4 == 2)
            suit = "Hearts";
        if (num % 4 == 3)
            suit = "Spades";

        if (num % 13 == 0)
            name = "2";
        if (num % 13 == 1)
            name = "3";
        if (num % 13 == 2)
            name = "4";
        if (num % 13 == 3)
            name = "5";
        if (num % 13 == 4)
            name = "6";
        if (num % 13 == 5)
            name = "7";
        if (num % 13 == 6)
            name = "8";
        if (num % 13 == 7)
            name = "9";
        if (num % 13 == 8)
            name = "10";
        
        if (num % 13 == 9)
            name = "Jack";
        if (num % 13 == 10)
            name = "Queen";
        if (num % 13 == 11)
            name = "King";
        if (num % 13 == 12)
            name = "Ace";
    }

    // accessors 
    public String getName() {
        return name; 
    }
       
    public String getSuit() {
        return suit;
    }

    // mutators
    public void setName(String name) {
        this.name = name; 
    }
   
    public void setSuit(String suit) {
        this.suit = suit; 
    }

    public int getValue() {
        if (name.equals("2"))
            return 2; 
        if (name.equals("3"))
            return 3; 
        if (name.equals("4"))
            return 4;  
        if (name.equals("5"))
            return 5; 
        if (name.equals("6"))
            return 6; 
        if (name.equals("7"))
            return 7; 
        if (name.equals("8"))
            return 8; 
        if (name.equals("9"))
            return 9; 
        if (name.equals("10"))
            return 10; 
        if (name.equals("Jack"))
            return 11; 
        if (name.equals("Queen"))
            return 12; 
        if (name.equals("King"))
            return 13; 
        if (name == "Ace")
            return 14; 
        else 
            return -1; 
    }

    public String toString() {
        return name + " of " + suit; 
    }
}