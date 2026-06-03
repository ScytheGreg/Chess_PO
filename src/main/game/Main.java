package game;

import move.BoardPrinter;
import move.WriteMove;
import player.Player;
import player.RandomPlayer;

public class Main {

    public static void main(String[] args){
        Player white = new RandomPlayer("John", 1, 0.01);
        Player black = new RandomPlayer("Ben", 1, 0.02);

        white.attach(WriteMove.instance());
        black.attach(WriteMove.instance());

        white.attach(BoardPrinter.instance());
        black.attach(BoardPrinter.instance());

        Game social = new Game(white, black, 1000);
        social.play();
    }
}
