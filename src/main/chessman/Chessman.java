package chessman;

import board.*;
import move.Move;
import board.exception.vectorOutOfBoundException;
import player.Player;
import java.util.LinkedList;

public abstract class Chessman {
    private final int value;
    private final Player owner;
    private final int singularMoveLimit;
    private final Vector[] directions;

    private Square position;


    public Chessman( Player owner, Square position, int value, int singularMoveLimit, Vector[] directions){
        this.owner = owner;
        this.position = position;
        this.value = value;
        this.singularMoveLimit = singularMoveLimit;
        this.directions = directions;
    }

    public int getValue(){return value;}
    public Player getOwner(){return owner;}
    public Square getPosition(){return position;}

    public LinkedList<Move> legalMoves(Board board){
        LinkedList<Move> result = new LinkedList<>();
        int timeId = board.getTimeId();
        for (Vector dir : directions){
            Square target = new Square(position);
            target.add(dir);
            for (int i = 0 ; i < singularMoveLimit ; ++i){
                try {
                    target = board.getSquare(target); // Change target to actual target square
                    if (target.isFree()){
                        result.addLast(new Move(this, target, timeId));
                    }
                    else if (! target.getOwner().equals(owner)){ // Case there's opponents figure at target
                        result.addLast(new Move(this, target, timeId));
                    }
                    else {
                        break; // Case this player figure blocks move
                    }
                }catch (vectorOutOfBoundException e){
                    break;    // Case move will get out of bound
                }
            }
        }
        return result;
    }
    public void beTaken(){
        position = null;
    }
    public void attack(Square target){
        position.leave();
        target.attack(this);
        this.position = target;
    }


}
