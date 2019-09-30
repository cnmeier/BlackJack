/**
 * @author Rebecca Martino and Chelsea Meier
 * September 30th, 2019
 * CS482
 */

package com.example.chelseameier.blackjack;

import java.util.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Game extends Activity {
    private Deck deck;
    private Hand dealerHand;
    private Hand playerHand;
    private Game game;
    private int count;

    /**
     * Purpose: to instantiate Deck and Hand objects that will be represented as the deck and dealer or player hand
     */
    public Game() {
        deck = new Deck();
        dealerHand = new Hand();
        playerHand = new Hand();
        count = 0;
    }

    /**
     * Purpose: To create the layout and view of the second screen of the app
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        game = new Game();

        deck.shuffleDeck();
    }

    /**
     * Purpose: To display the initial cards of the came after onCreate is set up
     */
    @Override
    protected void onStart() {
        super.onStart();

        dealerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        game.initialDisplayHand(dealerHand);

        playerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        game.initialDisplayHand(playerHand);

        if (game.checkWinner() == "dealer")
            showDialog("DEALER WINS");
        else if (game.checkWinner() == "player")
            showDialog("PLAYER WINS");
    }

    /**
     * Purpose: To allow the user to click the "Hit" button a max of 3 times
     *
     * @param view
     *          the view of the screen
     */
    public void hit_button(View view) {

        Button button = (Button) findViewById(R.id.hit_button);
        if (count <= 3 && playerHand.points < 21) {
            count++;
            button.setEnabled(true);
            playerHand.addCard(deck.dealCard());

            if (count == 0)
                game.displayHand("R.id.player_back3", playerHand.hand[playerHand.cardsInHand - 1]);
            else if (count == 1)
                game.displayHand("R.id.player_back4", playerHand.hand[playerHand.cardsInHand - 1]);
            else
                game.displayHand("R.id.player_back5", playerHand.hand[playerHand.cardsInHand - 1]);

        }
        button.setEnabled(false);
        if (count >= 3) {
            if (game.checkWinner() == "dealer")
                showDialog("DEALER WINS");
            else {
                game.dealerTurn();
                if (game.checkWinner() == "player")
                    showDialog("PLAYER WINS");
                else if (game.checkWinner() == "dealer")
                    showDialog("DEALER WINS");
                else
                    showDialog("TIE");
            }
        }
    }

    /**
     * Purpose: To go back to the beginning and end this round if user clicks "New Game"
     *
     * @param view
     *          the view of the screen
     */
    public void goBack(View view) {
        finish();
    }

    /**
     * Purpose: To check if there's a winner by checking if the players or dealers cards are equal or more than 21
     *
     * @return: a string of the winner of the game based on number of points the dealer and player have
     */
    public String checkWinner() {
        if (playerHand.points > 21)
            return "dealer";
        else if (dealerHand.points > 21)
            return "player";
        else if (playerHand.points == 21 && dealerHand.points != 21)
            return "player";
        else if (playerHand.points != 21 && dealerHand.points == 21)
            return "dealer";
        else if (playerHand.points == 21 && dealerHand.points == 21)
            return "draw";

        return "no draw";
    }


    /**
     * Purpose: To deal the dealer cards for a total of at most 3 rounds if they have 16 or less points
     */
    public void dealerTurn() {
        for (int i = 0; i < 3; i++) {
            if (dealerHand.points <= 16) {
                dealerHand.addCard(deck.dealCard());
                if (i == 0)
                    game.displayHand("R.id.dealer_back8", dealerHand.hand[dealerHand.cardsInHand - 1]);
                else if (i == 1)
                    game.displayHand("R.id.dealer_back9", dealerHand.hand[dealerHand.cardsInHand - 1]);
                else
                    game.displayHand("R.id.dealer_back10", dealerHand.hand[dealerHand.cardsInHand - 1]);
            } else
                break;
        }
    }

    /**
     * Purpose: To display an alert box stating the winner of the game
     *
     * @param winner
     *            a string of the winner that will be displayed in the alert box
     */
    public void showDialog(String winner) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(winner);
        alert.show();
    }

    /**
     * Purpose: To retrieve the id of the string
     *
     * @param imageId
     *              the string that the id is being retrieved from
     * @return the id numbers of the string
     */
    public int getIdFromString(String imageId) {
        int id = 0;

        if(imageId.equals("R.id.dealer_back1"))
            id = R.id.dealer_back1;

        else if(imageId.equals("R.id.dealer_back2"))
            id = R.id.dealer_back2;

        else if(imageId.equals("R.id.dealer_back3"))
            id = R.id.dealer_back3;

        else if(imageId.equals("R.id.dealer_back4"))
            id = R.id.dealer_back4;

        else if(imageId.equals("R.id.dealer_back5"))
            id = R.id.dealer_back5;

        else if(imageId.equals("R.id.player_back1"))
            id = R.id.player_back1;

        else if(imageId.equals("R.id.player_back2"))
            id = R.id.player_back2;

        else if(imageId.equals("R.id.player_back3"))
            id = R.id.player_back3;

        else if(imageId.equals("R.id.player_back4"))
            id = R.id.player_back4;

        else if(imageId.equals("R.id.player_back5"))
            id = R.id.player_back5;

        return id;
    }

    /**
     * Purpose: To display the initial images of the cards (the first 2 cards of dealer and player)
     *
     * @param hand
     *          an array of the cards in the hand
     */
    public void initialDisplayHand(Hand hand){
        ArrayList<String> initialCards = new ArrayList<String>();
        initialCards.add("R.id.dealer_back1");
        initialCards.add("R.id.dealer_back2");
        initialCards.add("R.id.player_back1");
        initialCards.add("R.id.player_back2");

        for(int i = 0; i < hand.cardsInHand; i++) {
            String cardName = initialCards.get(i);
            int cardId = getIdFromString(cardName);
            ImageView imgview = (ImageView) findViewById(cardId);
            String name = hand.hand[i].filename;
            int imageId = getResources().getIdentifier(name, "drawable", getPackageName());
            imgview.setImageResource(imageId);
        }
    }

    /**
     * Purpose: To display the images of the cards after the first 2 cards are drawn
     *
     * @param idString
     *          the string that the id is being retrieved from
     * @param card
     *          the card being displayed
     */
    public void displayHand(String idString, Card card) {
        int id = getIdFromString(idString);
        ImageView cardImage = (ImageView) findViewById(id);
        int imageId = getResources().getIdentifier(card.filename, "drawable", getPackageName());
        cardImage.setImageResource(imageId);
    }
}
