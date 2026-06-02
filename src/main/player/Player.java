package player;

import board.Board;
import chessman.Chessman;

public abstract class Player implements Comparable<Player> {
    private Integer figurePoints = 0;
    private String name;

    public Player(String name){
        this.name = name;
    }

    abstract public  void play(Board board);

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
        return name + ", figure points: " + figurePoints;
    }
}
