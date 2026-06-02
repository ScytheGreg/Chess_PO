package game;

import board.Board;
import player.Player;

public class Game {
    private Board board;

    public Game(Player white, Player black){
        board = new Board(new ChessmanSet(white, black));

    }
}
