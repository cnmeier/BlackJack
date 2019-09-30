// Rebecca Martino and Chelsea Meier
// September 22, 2019

package com.example.chelseameier.blackjack;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.*;

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

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.game);
//
//        Game game = new Game();
//        game.startGame();
//
//        //if (game.checkWinner() == "dealer")
//        //    System.out.println("DEALER WINS");
//        //else if (game.checkWinner() == "player")
//        //    System.out.println("PLAYER WINS");
//        //else {
//        //    game.playerTurn();
//        //    if (game.checkWinner() == "dealer")
//        //        System.out.println("DEALER WINS");
//        //    else {
//        //        game.dealerTurn();
//        //        if (game.checkWinner() == "player")
//        //           System.out.println("PLAYER WINS");
//        //        else
//        //            System.out.println("DEALER WINS");
//        //    }
//        //}
//
//
//    }

    /**
     * Purpose: Add a card to the hand
     * @param: newCard, the new card being added
     * @return: Nothing
     */
    public void addCard(Card newCard)
    {
        this.hand[this.cardsInHand] = newCard;
        this.cardsInHand += 1;
//        ImageView imgView=(ImageView) findViewById(R.id.ace_of_diamonds);
//        imgView.setVisibility(View.VISIBLE);

        updatePoints();

        //printHand(); //UPDATE THE HAND DISPLAYED
    }

    /**
     * Purpose: To display the image corresponding to the card dealt out
     * @param: newCard, the card that was dealt out
     * @return: nothing
     */
//    public void displayCard(String newCard){
//        if (newCard.equals("ace_of_clubs")) {
//            ImageView imgView = (ImageView) findViewById(R.id.ace_of_clubs);
//            imgView.setVisibility(View.VISIBLE);
//
////            ImageView imgView2 = (ImageView) findViewById(R.id.dealer_back1);
////            imgView2.setVisibility(View.INVISIBLE);
//        }
//
//        else if(newCard.equals("ace_of_hearts")) {
//            ImageView imgView = (ImageView) findViewById(R.id.ace_of_hearts);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("ace_of_spades")) {
//            ImageView imgView = (ImageView) findViewById(R.id.ace_of_spades);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("ace_of_diamonds")) {
//            ImageView imgView = (ImageView) findViewById(R.id.ace_of_diamonds);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("two_of_clubs")) {
//            ImageView imgView = (ImageView) findViewById(R.id.two_of_clubs);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("two_of_hearts")) {
//            ImageView imgView = (ImageView) findViewById(R.id.two_of_hearts);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("two_of_spades")) {
//            ImageView imgView = (ImageView) findViewById(R.id.two_of_spades);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("two_of_diamonds")) {
//            ImageView imgView = (ImageView) findViewById(R.id.two_of_diamonds);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("three_of_clubs")) {
//            ImageView imgView = (ImageView) findViewById(R.id.three_of_clubs);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("three_of_hearts")) {
//            ImageView imgView = (ImageView) findViewById(R.id.three_of_hearts);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("three_of_spades")) {
//            ImageView imgView = (ImageView) findViewById(R.id.three_of_spades);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("three_of_diamonds")) {
//            ImageView imgView = (ImageView) findViewById(R.id.three_of_diamonds);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("four_of_clubs")) {
//            ImageView imgView = (ImageView) findViewById(R.id.four_of_clubs);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("four_of_hearts")) {
//            ImageView imgView = (ImageView) findViewById(R.id.four_of_hearts);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("four_of_spades")) {
//            ImageView imgView = (ImageView) findViewById(R.id.four_of_spades);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("four_of_diamonds")) {
//            ImageView imgView = (ImageView) findViewById(R.id.four_of_diamonds);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("five_of_clubs")) {
//            ImageView imgView = (ImageView) findViewById(R.id.five_of_clubs);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("five_of_hearts")) {
//            ImageView imgView = (ImageView) findViewById(R.id.five_of_hearts);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("five_of_spades")) {
//            ImageView imgView = (ImageView) findViewById(R.id.five_of_spades);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("five_of_diamonds")) {
//            ImageView imgView = (ImageView) findViewById(R.id.five_of_diamonds);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("six_of_clubs")) {
//            ImageView imgView = (ImageView) findViewById(R.id.six_of_clubs);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("six_of_hearts")) {
//            ImageView imgView = (ImageView) findViewById(R.id.six_of_hearts);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("six_of_spades")) {
//            ImageView imgView = (ImageView) findViewById(R.id.six_of_spades);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("six_of_diamonds")) {
//            ImageView imgView = (ImageView) findViewById(R.id.six_of_diamonds);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("seven_of_clubs")) {
//            ImageView imgView = (ImageView) findViewById(R.id.seven_of_clubs);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("seven_of_hearts")) {
//            ImageView imgView = (ImageView) findViewById(R.id.seven_of_hearts);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("seven_of_spades")) {
//            ImageView imgView = (ImageView) findViewById(R.id.seven_of_spades);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("seven_of_diamonds")) {
//            ImageView imgView = (ImageView) findViewById(R.id.seven_of_diamonds);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("eight_of_clubs")) {
//            ImageView imgView = (ImageView) findViewById(R.id.eight_of_clubs);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("eight_of_hearts")) {
//            ImageView imgView = (ImageView) findViewById(R.id.eight_of_hearts);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("eight_of_spades")) {
//            ImageView imgView = (ImageView) findViewById(R.id.eight_of_spades);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("eight_of_diamonds")) {
//            ImageView imgView = (ImageView) findViewById(R.id.eight_of_diamonds);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("nine_of_clubs")) {
//            ImageView imgView = (ImageView) findViewById(R.id.nine_of_clubs);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("nine_of_hearts")) {
//            ImageView imgView = (ImageView) findViewById(R.id.nine_of_hearts);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("nine_of_spades")) {
//            ImageView imgView = (ImageView) findViewById(R.id.nine_of_spades);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("nine_of_diamonds")) {
//            ImageView imgView = (ImageView) findViewById(R.id.nine_of_diamonds);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("ten_of_clubs")) {
//            ImageView imgView = (ImageView) findViewById(R.id.ten_of_clubs);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("ten_of_hearts")) {
//            ImageView imgView = (ImageView) findViewById(R.id.ten_of_hearts);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("ten_of_spades")) {
//            ImageView imgView = (ImageView) findViewById(R.id.ten_of_spades);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("ten_of_diamonds")) {
//            ImageView imgView = (ImageView) findViewById(R.id.ten_of_diamonds);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("jack_of_clubs")) {
//            ImageView imgView = (ImageView) findViewById(R.id.jack_of_clubs);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("jack_of_hearts")) {
//            ImageView imgView = (ImageView) findViewById(R.id.jack_of_hearts);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("jack_of_spades")) {
//            ImageView imgView = (ImageView) findViewById(R.id.jack_of_spades);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("jack_of_diamonds")) {
//            ImageView imgView = (ImageView) findViewById(R.id.jack_of_diamonds);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("queen_of_clubs")) {
//            ImageView imgView = (ImageView) findViewById(R.id.queen_of_clubs);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("queen_of_hearts")) {
//            ImageView imgView = (ImageView) findViewById(R.id.queen_of_hearts);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("queen_of_spades")) {
//            ImageView imgView = (ImageView) findViewById(R.id.queen_of_spades);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("queen_of_diamonds")) {
//            ImageView imgView = (ImageView) findViewById(R.id.queen_of_diamonds);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("king_of_clubs")) {
//            ImageView imgView = (ImageView) findViewById(R.id.king_of_clubs);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("king_of_hearts")) {
//            ImageView imgView = (ImageView) findViewById(R.id.king_of_hearts);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("king_of_spades")) {
//            ImageView imgView = (ImageView) findViewById(R.id.king_of_spades);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//        else if(newCard.equals("king_of_diamonds")) {
//            ImageView imgView = (ImageView) findViewById(R.id.king_of_diamonds);
//            imgView.setVisibility(View.VISIBLE);
//        }
//
//
//    }


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

    /**
     * Purpose: To print out the updated number of points based on the cards in the hand
     *
    public void printHand()
    {
        for(int i = 0; i < cardsInHand; i++)
            System.out.println(hand[i].rank + "" + hand[i].suit);
        System.out.println("Points: " + this.points);
    }*/

//    /**
//     * Purpose: To retrieve the rank of each card
//     * @param card, the card dealt out that the rank will be retrieved from
//     * @return rank, the rank of the card
//     */
//    private String getRank(String card) {
//        //String element = deck.get(card);
//        String delimiter = "_";
//        String[] splitElement = card.split(delimiter);
//        String rank = splitElement[2];
//        return rank;
//    }

    /**
     * Purpose: To retrieve the suit of each card
     * @param card, the card dealt out that the suit will be retrieved from
     * @return suit, the suit of the card

    protected String getSuit(String card) {

        String delimiter = "_";
        String[] splitElement = card.split(delimiter);
        String suit = splitElement[0];

        return suit;
    }*/
}
