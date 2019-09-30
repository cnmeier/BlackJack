/**
 * @author Rebecca Martino and Chelsea Meier
 * September 30th, 2019
 * CS482
 */

package com.example.chelseameier.blackjack;

import android.support.v7.app.AppCompatActivity;

public class Deck extends AppCompatActivity {

    private int cardsDealt;
    Card[] deck;

    /**
     * Purpose: To insert 52 card objects into the deck array
     */
    public Deck() {

        deck = new Card[52];
        int numCards = 0;

        String[] suits = {"spades", "clubs", "diamonds", "hearts"};    //array holding all possible suits of cards
        String[] ranks = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};    //array holding all possible ranks of cards

        //looping through each suit and rank so all possible combinations between the two are met and stored into the deck
        for (int i = 0; i < suits.length; i++)
            for (int j = 0; j < ranks.length; j++)
                deck[numCards++] = new Card(suits[i],ranks[j]);
    }

    /**
     * Purpose: To shuffle the deck of cards
     */
    public void shuffleDeck()
    {
        Card temp;
        for (int i = deck.length-1; i > 0; i--)
        {
            int randomCard = (int)(Math.random() * (i + 1));
            temp = new Card(deck[i].rank, deck[i].suit);
            deck[i] = deck[randomCard];
            deck[randomCard] = temp;
        }
        cardsDealt = 0;
    }

    /**
     * Purpose: To deal a card from the deck
     *
     * @return a new card to be dealt
     */
    public Card dealCard()
    {
        if (cardsDealt == 52)
            shuffleDeck();

        return deck[cardsDealt++];
    }
}
