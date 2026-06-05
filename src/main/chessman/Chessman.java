package chessman;

import board.*;
import move.CaptureMove;
import move.Move;
import board.exception.vectorOutOfBoundException;
import move.NoCaptureMove;
import player.Player;
import java.util.LinkedList;

public abstract class Chessman {
    private final int value;
    private final Player owner;
    private final int singularMoveLimit;
    private final Vector[] directions;
    private final String shortName;
    private final Vector startPosition;

    private Square position = null;


    public Chessman(Player owner, Vector startPosition, int value, int singularMoveLimit, Vector[] directions, String shortName){
        this.owner = owner;
        this.startPosition = startPosition;
        this.value = value;
        this.singularMoveLimit = singularMoveLimit;
        this.directions = directions;
        if (owner.getUpperCase()){
            this.shortName = shortName.toUpperCase();
        }else {
            this.shortName = shortName.toLowerCase();
        }
        owner.gainFigure(this);
    }

    public int getValue(){return value;}
    public Player getOwner(){return owner;}
    public Square getPosition(){return position;}
    public Vector getStartPosition(){return startPosition;}
    public String getShortName() {return shortName;}

    public LinkedList<Move> legalMoves(Board board){
        LinkedList<Move> result = new LinkedList<>();
        int timeId = board.getTimeId();
        for (Vector dir : directions){
            Vector targetCoords = new Vector(position);
            targetCoords.add(dir);
            for (int i = 0 ; i < singularMoveLimit ; ++i){
                try {
                    Square target = board.getSquare(targetCoords); // Change target to actual target square
                    if (target.isFree()){
                        result.addLast(new NoCaptureMove(this, target, timeId)); // Target is free
                    }
                    else if (! target.getOwner().equals(owner)){ // Case there's opponents figure at target
                        result.addLast(new CaptureMove(this, target, timeId));
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
        owner.looseFigure(this);
        position.leave();
        position = null;
    }
    public void attack(Square target){
        if (position != null) {
            position.leave();
        }
        target.attack(this);
        position = target;
    }
    @Override
    public String toString(){
        return shortName + position.toString();
    }

}
