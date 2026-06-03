package game;

import move.BoardPrinter;
import move.WriteMove;
import player.Player;
import player.RandomPlayer;

public class Main {

    public static void main(String[] args){
        Player white = new RandomPlayer("John", 1);
        Player black = new RandomPlayer("Ben", 1);

        white.attach(WriteMove.instance());
        black.attach(WriteMove.instance());

        white.attach(BoardPrinter.instance());
        black.attach(BoardPrinter.instance());

        Game social = new Game(white, black, 2);
        social.play();
    }
}
