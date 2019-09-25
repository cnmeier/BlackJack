// Rebecca Martino and Chelsea Meier
// September 23, 2019

import java.util.*;

public class Deck
{
    private Card[] deck;
    private int cardsDealt;

    //char[] suits;
    //char[] rank;

    public Deck()
    {
        deck = new Card[52];
        
        char[] suits = {'s', 'c', 'd', 'h'};
        char[] ranks = {'A', '2', '3', '4', '5', '6', '7', '8', '9', '1', 'J', 'Q', 'K'}; 
        int numCards = 0; 
        for (int i = 0; i < suits.length; i++)
            for (int j = 0; j < ranks.length; j++)
                deck[numCards++] = new Card(suits[i],ranks[j]);
    }

   /* 
    * Purpose: To shuffle the deck of card
    */
    public void shuffleDeck()
    {
        for (int i = deck.length-1; i > 0; i--)
        {
            int randomCard = (int)(Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[randomCard];
            deck[randomCard] = temp;
        }
        
        cardsDealt = 0;
    }

   /* 
    * Purpose: To deal a card from the deck
    * @return a new card to be dealt
    */
    public Card dealCard()
    {
        if (cardsDealt == 52)
            shuffleDeck();

        return deck[cardsDealt++];
    }
}
