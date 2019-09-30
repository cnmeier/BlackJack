/**
 * @author Rebecca Martino and Chelsea Meier
 * September 30th, 2019
 * CS482
 */

package com.example.chelseameier.blackjack;

public class Card {

    String suit = "";
    String rank = "";
    String filename;

    /**
     * Purpose: To set the suit and rank of a card
     *
     * @param: suit
     *            the suit of the card (hearts, diamonds, spades, or clubs)
     * @param: rank
     *            the rank of the card (1-10, Jack, Queen, King, or Ace)
     */
    public Card(String suit, String rank)
    {
        this.suit = suit;
        this.rank = rank;
        this.filename= rank + "_of_" + suit + ".png";
    }
}
