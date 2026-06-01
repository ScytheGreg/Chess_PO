package game;

import board.Board;
import player.Player;

import java.util.prefs.BackingStoreException;

public class Game {
    private Board board;

    public Game(Player white, Player black){
        board = new Board();

    }
}
