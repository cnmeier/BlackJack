/**
 * @author Rebecca Martino and Chelsea Meier
 * September 30th, 2019
 * CS 482
 */

package com.example.chelseameier.blackjack;

import android.app.Activity;

public class Hand extends Activity {
    public Card [] hand;
    public int points;
    public int cardsInHand;
    static int MAX_CARDS_IN_HAND = 5;

    /**
     * Purpose: To instantiate a String array as well as set points and cardsInHand to 0
     */
    public Hand()
    {
        this.hand = new Card[MAX_CARDS_IN_HAND];
        this.points = 0;
        this.cardsInHand = 0;
    }

    /**
     * Purpose: Add a card to the hand
     * @param newCard
     * 		    the new card being added
     * @return: Nothing
     */
    public void addCard(Card newCard)
    {
        this.hand[this.cardsInHand] = newCard;
        this.cardsInHand += 1;

        updatePoints();
    }

    /**
     * Purpose: Update the current number of points in the hand
     */
    public void updatePoints()
    {
        boolean ace = false;
        int newPoints = 0;

        for(int i = 0; i < this.cardsInHand; i++)
        {
            //Card card;
            String cardRank = this.hand[i].rank;

            if(cardRank == "jack" || cardRank == "queen" || cardRank == "king" || cardRank == "ten" )
                newPoints += 10;
            else if(cardRank == "ace")
                ace = true;
            else if(cardRank == "one")
                newPoints += 1;
            else if(cardRank == "two")
                newPoints += 2;
            else if(cardRank == "three")
                newPoints += 3;
            else if(cardRank == "four")
                newPoints += 4;
            else if(cardRank == "five")
                newPoints += 5;
            else if(cardRank == "six")
                newPoints += 6;
            else if(cardRank == "seven")
                newPoints += 7;
            else if(cardRank == "eight")
                newPoints += 8;
            else if(cardRank == "nine")
                newPoints += 9;
        }

        if(ace == true)
            if(newPoints + 10 <= 21)
                newPoints += 10;
            else
                newPoints += 1;

        this.points = newPoints;
    }
}
