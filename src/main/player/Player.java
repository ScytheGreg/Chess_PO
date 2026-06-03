package player;

import board.Board;
import chessman.Chessman;
import move.Move;
import move.MoveObserver;

import java.util.*;

public abstract class Player implements Comparable<Player> {
    private Integer figurePoints = 0;
    private final ArrayList<MoveObserver> observers = new ArrayList<>();
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
        Move playedMove = chooseMove(possibleMoves);
        playedMove.apply(board);
        for (MoveObserver observer : observers){
            observer.update(playedMove);
        }
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
        return -1 * figurePoints.compareTo(other.getFigurePoints());
    }

    public void attach(MoveObserver observer){
        observers.add(observer);
    }

    public void detach(MoveObserver observer){
        if (!observers.remove(observer)) {
            throw new NoSuchElementException("There is no called observer");
        }
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
