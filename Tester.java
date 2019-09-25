public class Tester
{
    public static void main(String[] args)
    {
        Game game = new Game();
        game.startGame();
         
        if (game.checkWinner() == "dealer")
            System.out.println("DEALER WINS");
        else if (game.checkWinner() == "player")
            System.out.println("PLAYER WINS");
        else
        {
            game.playerTurn();  
            if (game.checkWinner() == "dealer")
                System.out.println("DEALER WINS");
            else
            {           
                game.dealerTurn();
                if(game.checkWinner() == "player")
                    System.out.println("PLAYER WINS");
                else
                    System.out.println("DEALER WINS");
                //at this point need to check who is closest 
            }
        }
    }

}
