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


        // White have definitive advantage ???
        Player white = new CalculatingRandomPlayer("Alice", true, seed);
        Player black = new GreedyRandomPlayer("Bob", false, seed);

//        white.attach(WriteMove.instance());
//        black.attach(WriteMove.instance());
//
//        white.attach(BoardPrinter.instance());
//        black.attach(BoardPrinter.instance());


        int aliceCnt = 0;
        int bobCnt = 0;

        for (int i = 0 ; i < 300 ; ++i) {
            if (i % 30 == 0) {
                System.out.println("Playing game nr " + i);
            }
            Game social = new Game(white, black, 1000);
            social.play();
            if (social.getWinner().equals(white)){
                ++aliceCnt;
            }
            else{
                ++bobCnt;
            }
        }
        System.out.println("Alice wins: " + aliceCnt + "\nBob wins: " + bobCnt);
    }
}
