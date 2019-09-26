//Rebecca Martino and Chelsea Meier
//September 23, 2019

import java.util.*;

public class Game
{
    private Deck deck;
    private Hand dealerHand;
    private Hand playerHand;

    /*
     * Purpose: to instantiate Deck and Hand objects that will be represented as the deck and dealer or player hand
     */  
    public Game()
    {
        deck = new Deck();        
        dealerHand = new Hand();
        playerHand = new Hand();
    }

    public void startGame()
    {
        deck.shuffleDeck();
        
        dealerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        System.out.println("The dealer has: ");
        dealerHand.printHand();
  
        playerHand.addCard(deck.dealCard()); 
        playerHand.addCard(deck.dealCard());
        System.out.println("You have: ");
        playerHand.printHand();
    }
   
/*    public String checkOver()
    {
        if(playerHand.points > 21)
            return "dealer";
        else if (dealerHand.points > 21
        return "";
    }
*/
    public String checkWinner()
    {
        if(playerHand.points > 21)
            return "dealer";
        else if (dealerHand.points > 21)
            return "player";
        else if(playerHand.points == 21 && dealerHand.points != 21)
            return "player";
        else if(playerHand.points != 21 && dealerHand.points == 21)
            return "dealer";
        else if(playerHand.points == 21 && dealerHand.points == 21)  
            return "draw";
            //check if one has ace and face
            //if yes, that player wins
            //if not, draw
        return "no draw";
    }

    
    public void playerTurn()
    {
        int bet;
        Scanner input = new Scanner(System.in);
 
        for(int i = 0; i < 3; i++)
        {
            do
            {
                System.out.println("Would you like to bet? (1 for yes, 0 for no)");
                bet = input.nextInt();
            } while(bet != 1 && bet != 0);

            if( bet == 1)
            {  
                playerHand.addCard(deck.dealCard());
                System.out.println("You have: ");
                playerHand.printHand();    
            }
            else
                break;
        }
      
        

    }

    public void dealerTurn()
    {
        for(int i = 0; i < 3; i++)
        {
            if(dealerHand.points <= 16)
            {
                dealerHand.addCard(deck.dealCard());
                System.out.println("Dealer has: ");
                dealerHand.printHand();
            }
            else
                break;
        }
    }
}

