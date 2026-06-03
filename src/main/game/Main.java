package game;

import move.BoardPrinter;
import move.WriteMove;
import player.Player;
import player.RandomPlayer;

public class Main {

    public static void main(String[] args){
        Player white = new RandomPlayer("John", true, 22, 0.01);
        Player black = new RandomPlayer("Ben", false, 22, 0.02);

        white.attach(WriteMove.instance());
        black.attach(WriteMove.instance());

        white.attach(BoardPrinter.instance());
        black.attach(BoardPrinter.instance());

        Game social = new Game(white, black, 50);
        social.play();
    }
}
