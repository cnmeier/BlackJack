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
    
        dealerHand.dealCard(deck.dealCard());
        dealerHand.dealCard(deck.dealCard());

        playerHand.dealCard(deck.dealCard()); 
        playerHand.dealCard(deck.dealCard());

        playerHand.updatePoints();
        dealerHand.updatePoints();
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

    /*
    public void playerTurn()
    {
        System.out.println("Your cards are: "); //d
        for (int i = 0; i < playerHand.cardsInHand; i++)
            System.out.println(" " + playerHand.get(i).suit + playerHand.get(i).rank); //d
       
        System.out.println("Your current point value is " + playerHand.points);



    }*/
}

