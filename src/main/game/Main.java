package game;

import move.BoardPrinter;
import move.WriteMove;
import player.*;

public class Main {

    public static void main(String[] args){

        if (args.length != 1){
            System.err.println("Usage: <program> arg1 - random seed");
            System.exit(1);
        }
        int seed = 0;
        try {
            seed = Integer.parseInt(args[0]);
        } catch (Exception e){
            System.err.println(e.getMessage());
            System.err.println("Usage: <program> arg1 - randomness seed");
            System.exit(1);
        }

        Player white = new RandomUniformlyPlayer("Alice", true, seed);
        Player black = new GreedyRandomPlayer("Bob", false, seed);

        white.attach(WriteMove.instance());
        black.attach(WriteMove.instance());

        white.attach(BoardPrinter.instance());
        black.attach(BoardPrinter.instance());

        Game social = new Game(white, black, 1000);
        social.play();
    }
}
