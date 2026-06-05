package game;

import move.BoardPrinter;
import move.WriteMove;
import player.Player;
import player.RandomUniformlyPlayer;

public class Main {

    public static void main(String[] args){
        Player white = new RandomUniformlyPlayer("John", true, 22);
        Player black = new RandomUniformlyPlayer("Ben", false, 22);

        white.attach(WriteMove.instance());
        black.attach(WriteMove.instance());

        white.attach(BoardPrinter.instance());
        black.attach(BoardPrinter.instance());

        Game social = new Game(white, black, 50);
        social.play();
    }
}
