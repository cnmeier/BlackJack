//Rebecca Martino and Chelsea Meier
//September 23, 2019

import java.util.*;

public class Game
{
    /*private Game game;

    public static void main(String[] args)
    {
        game = new Game();
        game.startGame();
       
        // game.checkWinner();
        
        game.playerTurn();

        /*
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

    public void playerTurn()
    {
        System.out.println("Your cards are: "); //d
        for (int i = 0; i < playerHand.cardsInHand; i++)
            System.out.println(" " + playerHand.get(i).suit + playerHand.get(i).rank); //d
       
        System.out.println("Your current point value is " + playerHand.points);



    }
}

