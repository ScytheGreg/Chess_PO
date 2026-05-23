package chessman;

import board.Board;
import board.Vector;
import move.Move;
import player.Player;

public abstract class Chessman {
    private final int value;
    private final Player owner;
    private final int singularMoveLimit;
    private final Vector[] directions;


    public Chessman(int value, Player owner, int singularMoveLimit, Vector[] directions){
        this.value = value;
        this.owner = owner;
        this.singularMoveLimit =singularMoveLimit;
        this.directions = directions;
    }

    public int getValue(){return value;}
    public Player getOwner(){return owner;}

    public Move[] legalMoves(Board board){

    }

}
