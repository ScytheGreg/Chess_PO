package board;

import chessman.Chessman;
import game.ChessmanSet;
import move.Move;
import board.exception.vectorOutOfBoundException;
import player.Player;

import java.util.LinkedList;

public class Board {
    private final int MAX_X = 8;
    private final int MAX_Y = 8;
    private int timeId = 0;

    private final Square[][] board;

    public Board(ChessmanSet startPosition) {
        board = new Square[MAX_X][MAX_Y];
        for (int x = 0; x < MAX_X; ++x) {
            for (int y = 0; y < MAX_Y; ++y) {
                board[x][y] = new Square(x, y);
            }
        }
        for(Chessman figure : startPosition){
            if (figure != null){
                Square boardSquare = getSquare(figure.getPosition());
                assert(boardSquare.isFree());
                figure.attack(boardSquare); // Move figure from virtual
                                            // to real board
            }
        }
    }

    public int getMAX_X() {
        return MAX_X;
    }

    public int getMAX_Y() {
        return MAX_Y;
    }


    public boolean contains(Vector square) {
        return 0 <= square.getX() && square.getX() < MAX_X &&
                0 <= square.getY() && square.getY() < MAX_Y;
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

    public LinkedList<Move> legalMoves(Player player) {
        LinkedList<Move> result = new LinkedList<>();
        for (int i = 0; i < getMAX_X(); ++i) {
            for (Square square : board[i]) {
                if (square.getOwner()!= null && square.getOwner().equals(player)) {
                    result.addAll(square.getChessman().legalMoves(this));
                }
            }
        }
        return result;
    }

    public void movePerformed(){
        ++timeId;
    }

    public void moveRestored(){
        --timeId;
    }

    @Override
    public String toString(){
        
    }
}
