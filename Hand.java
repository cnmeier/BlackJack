// Rebecca Martino and Chelsea Meier
// September 22, 2019

import java.util.*;

public class Hand
{
    private List<Card> hand;// = new ArrayList<>(); 
    public int points;
    public int cardsInHand;

    //Card card = new Card(void, void);
 
    public Hand()
    {
       hand = new ArrayList<>();
       this.points = 0;
       this.cardsInHand = 0;
    }

   /* 
    * Purpose: To create a Hand object with the first two cards
    * @param: The first card dealt
    * @param: The second card dealt
    * @return: Nothing
    */
    public void createHand(Card card1, Card card2)
    {
        hand.dealCard(card1);
        hand.dealCard(card2);    
    }

   /*
    * Purpose: Add a card to the hand
    * @param: The new card
    * @return: Nothing
    */
    public void dealCard(Card newCard)
    {
        hand.add(newCard);
        this.cardsInHand += 1; 
    }
    
   /* 
    * Purpose: Update the current number of points in the hand
    * @return: The current number of points
    */
    public void updatePoints()
    {
        for(int i = 0; i < hand.size(); i++)
        {
            if ('1' <= hand.get(i).rank && 9 >= hand.get(i).rank) //where 1 represents 10
                this.points += Integer.valueOf(hand.get(i).rank);
            else if (hand.get(i).rank == 'J' || hand.get(i).rank == 'Q' || hand.get(i).rank == 'K')
                this.points += 10;
            else 
                if (this.points <= 10)
                    this.points += 11;
                else
                    this.points += 1;  
        }
    }
    
   /* 
    * Purpose: Check the current number of points to determine game status
    * @return: The status of the game after the new card
    */
    public String checkPoints()
    {
        String status = "in progress";
       
        if (points == 21)
            status = "winner"; // need to check if Ace and face card or not
        else if (points > 21)
            status = "loser";
       
        return status;
    }
}
