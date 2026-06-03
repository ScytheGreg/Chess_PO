package board;

import chessman.Chessman;
import game.ChessmanSet;
import move.Move;
import board.exception.vectorOutOfBoundException;
import player.Player;

import java.util.Iterator;
import java.util.LinkedList;

public class Board {
    private final int MAX_X = 8;
    private final int MAX_Y = 8;
    private int timeId = 0;

    private final Square[][] board;
    private static Board uniqeBoard;

    public static Board instance(){
        if (uniqeBoard == null){
            uniqeBoard = new Board();
        }
        return uniqeBoard;
    }

    private Board() {
        board = new Square[MAX_X][MAX_Y];
        for (int x = 0; x < MAX_X; ++x) {
            for (int y = 0; y < MAX_Y; ++y) {
                board[x][y] = new Square(x, y);
            }
        }
    }

    public void prepareGame(ChessmanSet startPosition){
        for(Chessman figure : startPosition){
            if (figure != null){
                Square boardSquare = getSquare(figure.getPosition());
                assert(boardSquare.isFree());
                figure.attack(boardSquare); // Move figure to its start position
            }
        }
    }

    public int getMAX_X() {
        return MAX_X;
    }

    public int getMAX_Y() {
        return MAX_Y;
    }


    public boolean contains(Vector coordinates) {
        return 0 <= coordinates.getX() && coordinates.getX() < MAX_X &&
                0 <= coordinates.getY() && coordinates.getY() < MAX_Y;
    }

    public Square getSquare(Vector coordinates) {
        if (!contains(coordinates))
            throw new vectorOutOfBoundException(coordinates);
        return board[coordinates.getX()][coordinates.getY()];
    }

    public Square getSquare(int x, int y){
        return getSquare(new Vector(x, y));
    }

    public int getTimeId() {
        return timeId;
    }

    public Iterator<Move> legalMoves(Player player) {
        LinkedList<Move> result = new LinkedList<>();
        for (int i = 0; i < getMAX_X(); ++i) {
            for (Square square : board[i]) {
                if (square.getOwner()!= null && square.getOwner().equals(player)) {
                    result.addAll(square.getChessman().legalMoves(this));
                }
            }
        }
        return result.iterator();
    }

    public void movePerformed(){
        ++timeId;
    }

    public void moveRestored(){
        --timeId;
    }

}
