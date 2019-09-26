// Rebecca Martino and Chelsea Meier
// September 22, 2019

import java.util.*;

public class Hand
{
    private Card[] hand;// = new ArrayList<>(); 
    public int points;
    public int cardsInHand;
    static int MAX_CARDS_IN_HAND = 5;

    //Card card = new Card(void, void);
 
    /*
     * Purpose: To create a Card object that declares how many cards there can be in a hand and 
     * instantiate points and the number of cards in a hand to 0 to start off with
     */
    public Hand()
    {
       hand = new Card[MAX_CARDS_IN_HAND];
       this.points = 0;
       this.cardsInHand = 0;
    }

   /* 
    * Purpose: To create a Hand object with the first two cards
    * @param: The first card dealt
    * @param: The second card dealt
    * @return: Nothing
    *
    public void createHand(Card card1, Card card2)
    {
        hand.dealCard(card1);
        hand.dealCard(card2);    
    }*/

   /*
    * Purpose: Add a card to the hand
    * @param: newCard, the new card being added
    * @return: Nothing
    */
    public void addCard(Card newCard)
    {
        hand[this.cardsInHand] = newCard;
        this.cardsInHand += 1; 
        updatePoints();
        //printHand();
    }
    
   /* 
    * Purpose: Update the current number of points in the hand
    */
    public void updatePoints()
    {
        boolean ace = false;
        int newPoints = 0;        
 
        for(int i = 0; i < this.cardsInHand; i++)
        {
            Card card;
            char cardRank = (hand[i]).rank;

            if(cardRank == 'J' || cardRank == 'Q' || cardRank == 'K' || cardRank == '1' )
                newPoints += 10;
            else if(cardRank == 'A')
                ace = true;
            else
                newPoints += Character.getNumericValue(cardRank);
        }
    
        if(ace == true)
            if(newPoints + 10 <= 21)
                newPoints += 10;
            else
                newPoints += 1;

        this.points = newPoints;
    }

    public void printHand()
    {
        for(int i = 0; i < cardsInHand; i++)
            System.out.println(hand[i].rank + "" + hand[i].suit);
        System.out.println("Points: " + this.points);
    }
    
   /* 
    * Purpose: Check the current number of points to determine game status
    * @return: The status of the game after the new card
    *
    public String checkWinner()
    {
        String status = "in progress";
       
        if (points == 21)
            status = "winner"; // need to check if Ace and face card or not
        else if (points > 21)
            status = "loser";
       
        return status;
    }*/
}
