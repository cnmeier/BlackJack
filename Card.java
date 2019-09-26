// Rebecca Martino and Chelsea Meier
// September 22, 2019

public class Card
{
   char suit = '\0';
   char rank = '\0';

   /* 
    * Purpose: To set the suit and rank of a card
    * @param: suit, the suit of the card (hearts, diamonds, spades, or clubs)
    * @param: rank, the rank of the card (1-10, Jack, Queen, King, or Ace)
    * @return: Nothing
    */
    public Card(char suit, char rank)
    {
        this.suit = suit;
        this.rank = rank;
    }
}
