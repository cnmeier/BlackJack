//Rebecca Martino and Chelsea Meier
//September 23, 2019

import java.util.*;

public class Game
{
    /*public static void main(String[] args)
    {
        char bet = 'y';
        Scanner input = new Scanner(System.in);
    
        int totalBets = 0;
        int maxBets = 3;         
   
        


        while(totalBets < maxBets)
        {
            do
            {
                System.out.print("Would you like to bet? Enter y for yes or n for no");
                bet = input.nextChar();
            }while (bet != true && bet != false);
     
            if (bet == 'y')
                //deal a card to the user
                totalBets++;
            //Check if user won
        }
    }*/

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
    
        dealerHand.dealCard(deck.dealCard());
        dealerHand.dealCard(deck.dealCard());

        playerHand.dealCard(deck.dealCard()); 
        playerHand.dealCard(deck.dealCard());

        playerHand.updatePoints();
        dealerHand.updatePoints();

        checkWinner(); 
    }
   
    public String checkWinner()
    {
        if(playerHand.points == 21 && dealerHand.points != 21)
            return "player";
        else if(playerHand.points != 21 && dealerHand.points == 21)
            return "dealer";
        else if(playerHand.points == 21 && dealerHand.points == 21)  
            return "draw";
            //check if one has ace and queen
            //if yes, that player wins
            //if not, draw
        return "no winner";
    }
}

