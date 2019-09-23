// Rebecca Martino and Chelsea Meier
// September 22, 2019

import java.util.*;

public class Hand
{
    private List<Card> hand = new ArrayList<>(); 
    private int points = 0;
    //Card card = new Card(void, void);
 
    public Hand()
    {
    }

   /* 
    * Purpose: To create a Hand object with the first two cards
    * @param: The first card dealt
    * @param: The second card dealt
    * @return: Nothing
    */
    public void createHand(Card card1, Card card2)
    {
        hand.add(card1);
        hand.add(card2);       
    }

   /* 
    * Purpose: Add a card to the hand
    * @param: The new card
    * @return: Nothing
    */
    public void addCard(Card newCard)
    {
        hand.add(newCard);
    }
    
   /* 
    * Purpose: Update the current number of points in the hand
    * @return: The current number of points
    */
    public void updatePoints()
    {
        for(int i = 0; i < hand.size(); i++)
        {
            if ('2' <= hand.get(i).rank && (char)10 >= hand.get(i).rank)
                points += Integer.valueOf(hand.get(i).rank);
            else if (hand.get(i).rank == 'J' || hand.get(i).rank == 'Q' || hand.get(i).rank == 'K')
                points += 10;
            else 
                if (points <= 10)
                    points += 11;
                else
                    points += 1;  
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
