package player;

import board.Board;
import chessman.Chessman;
import move.Move;

import java.util.Iterator;

public abstract class Player implements Comparable<Player> {
    private Integer figurePoints = 0;
    private final String name;

    public Player(String name){
        this.name = name;
    }

    public abstract Move chooseMove(Iterator<Move> possibleMoves);

    public void play(Board board) throws NoPossibleMoveException{
        Iterator<Move> possibleMoves = board.legalMoves(this);
        if (!possibleMoves.hasNext()){
            throw new NoPossibleMoveException(this, board.getTimeId());
        }
        chooseMove(possibleMoves).apply(board);
    }

    public void gainFigure(Chessman figure){
        figurePoints += figure.getValue();
    }

    public void looseFigure(Chessman figure){
        figurePoints -= figure.getValue();
    }

    public int getFigurePoints(){
        return figurePoints;
    }

    public int compareTo(Player other){
        return figurePoints.compareTo(other.getFigurePoints());
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }

    public String stats(){
        return name + ", (figure points: " + figurePoints + ")";
    }
}
