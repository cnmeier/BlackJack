//Rebecca Martino and Chelsea Meier
//September 23, 2019

import java.util.*;

public class Game
{
    private Deck deck;
    private Hand dealerHand;
    private Hand playerHand;
  
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
  
        playerHand.addCard(deck.dealCard()); 
        playerHand.addCard(deck.dealCard());
    }
   
    public String checkFirstDeal()
    {
        if(playerHand.points > 21)
            return "dealer";
        return "";
    }

    public String checkWinner()
    {
        //if(playerHand.points > 21)
          //  return "dealer";
        if(playerHand.points == 21 && dealerHand.points != 21)
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
        String bet;
        Scanner input = new Scanner(System.in);
 
        for(int i = 0; i < 3; i++)
        {
            do
            {
                System.out.println("Would you like to bet? (y for yes, n for no)");
                bet = input.next().trim();
            } while(!(bet != "y" || bet != "n"));
            if( bet == "y")
            {  
                playerHand.addCard(deck.dealCard());
            
            }
            else
                break;
        }
    }

    public void dealerTurn()
    {
        //for (int i = 0; i < dealerHand.cardsInHand; i++)
            //dealerHand.printHand();

        for(int i = 0; i < 3; i++)
        {
            if(dealerHand.points <= 16)
                dealerHand.addCard(deck.dealCard());
            else
                break;
        }
    }
}

