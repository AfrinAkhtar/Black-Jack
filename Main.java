import java.util.Scanner; 
import  java.util.Random;
public class Main
{
  public static void main(String[] args) 
  { 
    // Generate a card array named deck
      Scanner sc = new Scanner(System.in);
      Card[] deck = new Card[52]; 

    //Shuffle deck 
      for(int i = 0; i < 52; i++)
      {
        deck[i] = new Card(i);
      }

      for(int i = 0; i < deck.length; i++)
      {
         
        int r1 = (int)(Math.random() * 52); 
        int r2 = (int)(Math.random() * 52); 
        
        Card tmp = deck[r1]; 
        deck[r1] = deck[r2]; 
        deck[r2] = tmp;
      }
      
    //Intialize variables 
      int top = 0; 
      int ptotal = 100; // bank
      int dtotal = 100; 
      int pbet = 0;
    
    // for loop to repeat lines 2-6 again 
    while ((ptotal > 0) && (dtotal > 0))
    {
      int pvalue = 0; 
      int dvalue = 0;
      //make sure deck has more than 10 cards lol
      if (top > 42)
      {
        deck = new Card[52]; 

        //Shuffle deck 
        for(int i = 0; i < 52; i++)
        {
        deck[i] = new Card(i);
        }

        for(int i = 0; i < deck.length; i++)
        {
          
          int r1 = (int)(Math.random() * 52); 
          int r2 = (int)(Math.random() * 52); 
          
          Card tmp = deck[r1]; 
          deck[r1] = deck[r2]; 
          deck[r2] = tmp;
        } 
        
      }
      //Print out amounts 
        System.out.println("Dealer: " + dtotal); 
        System.out.println("Player: " + ptotal);

      //Ask for bet amount 
        System.out.print("\nBet Amount? ");
        pbet = sc.nextInt();
      
      // Deal card to player and display
        pvalue += deck[top].getValue();
        System.out.println(deck[top]);
        top += 1; 

      //Deal card to player and display 
        pvalue += deck[top].getValue();
        System.out.println(deck[top]);
        top += 1;

      //Print player total 
        System.out.println("You have a value of " + pvalue);

      //Deal card to dealer and display 
        dvalue += deck[top].getValue();
        System.out.println("\nDealers turn \n" + deck[top]);
        top += 1; 

      //Deal card to dealer and display 
        dvalue += deck[top].getValue();
        System.out.println("This card is face down");
        top += 1; 

      //Print dealer total
        System.out.println("Dealer has a value of " + dvalue + "\n");
      // Ask player for cards until they want to stop
        while (pvalue < 21)
        {
          int reply = 0; 
          System.out.println ("Your turn.");
          System.out.print("Would you like to hit (1) or Stay (2)? "); 
          reply = sc.nextInt();
          if (reply== 1)
          {
            System.out.println(deck[top]);
            pvalue += deck[top].getValue();
            System.out.println("You have a value of " + pvalue);
            top += 1;  
          }
          else if (reply == 2)
          {
            break; 
          }
      
        }
      //Deals to dealer until bust or over 17 
        while (dvalue < 21)
        {
          while (dvalue < 17)
          {
            System.out.println("\nDealers turn \n" + deck[top]);
            dvalue += deck[top].getValue();
            System.out.println("Dealer has a value of " + dvalue );
            top += 1; 
          }
          break; 
        }
      // Determine the winner 
        if (pvalue > 21)
        {
          dtotal += pbet; 
          ptotal -= pbet; 
          System.out.println ("Dealer wins");
          System.out.println ("\nPlayer bank = "+ ptotal );
          System.out.println ("Dealer bank = "+ dtotal);
        }
        if ((dvalue > 21) && (pvalue <= 21))
        {
          ptotal += pbet; 
          dtotal -= pbet; 
          System.out.println ("Player wins");
          System.out.println ("\nPlayer bank = "+ ptotal );
          System.out.println ("Dealer bank = "+ dtotal);
        }
        if ((pvalue < 21) && (dvalue < 21))
        {
          if (pvalue > dvalue)
          {
            dtotal -= pbet; 
            ptotal += pbet;
            System.out.println ("Player wins");
            System.out.println ("\nPlayer bank = "+ ptotal );
            System.out.println ("Dealer bank = "+ dtotal);
          }
          if (pvalue < dvalue)
          {
            dtotal += pbet; 
            ptotal -= pbet;
            System.out.println ("Dealer wins");
            System.out.println ("\nPlayer bank = "+ ptotal );
            System.out.println ("Dealer bank = "+ dtotal);
          }
          if( pvalue == dvalue)
          {
            System.out.println ("Tie.");
            System.out.println ("\nPlayer bank = "+ ptotal );
            System.out.println ("Dealer bank = "+ dtotal);
          }
        }
      
      }
      
        
    }
  }
/*       
Player hits 1 or more times and busts (over 21) --> Dealer wins
Dealer hits 1 or more times and busts --> Player wins
Both player and dealer have hands less than or equal to 21...
Player stays, but has hand less than dealer --> Dealer wins
Dealer stays when hand >16, but has hand less than Player --> Player wins
Both player and dealer have same value hand --> Tie/Push
*/