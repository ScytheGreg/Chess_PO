package chessman;

import move.Move;
import board.Board;
import board.Square;
import board.Vector;
import player.Player;

import java.util.LinkedList;

public class Pawn extends Chessman{
    private final Vector forward;
    private final Vector[] attack = {
            new Vector(1, 0),
            new Vector(-1, 0)
    };
    public Pawn(Player owner, Vector position, Vector forward){
        super(owner, position, 1, 1, null, "P");
        this.forward = forward;
        for (Vector diagonal : attack){
            diagonal.add(forward);
        }
    }

    @Override
    public LinkedList<Move> legalMoves(Board board){
        LinkedList<Move> result = new LinkedList<>();
        int timeId = board.getTimeId();

        // Forward move
        {
            Vector targetCoords = new Vector(getPosition());
            targetCoords.add(forward);
            if (board.contains(targetCoords)) {
                Square target = board.getSquare(targetCoords);
                if (target.isFree()) {
                    result.addLast(new Move(this, target, timeId));
                }
            }
        }

        // Diagonal attack
        for(Vector dir : attack) {
            Vector targetCoords = new Vector(getPosition());
            targetCoords.add(dir);
            if (board.contains(targetCoords)){
                Square target = board.getSquare(targetCoords);
                Player targetOwner = target.getOwner();
                if (targetOwner != null && ! targetOwner.equals(getOwner())){
                    result.addLast(new Move(this, target, timeId));
                }
            }
        }

        return result;
    }
}
