package chessman;

import move.Move;
import board.Board;
import board.Square;
import board.Vector;
import player.Player;

import java.util.LinkedList;

public class Pawn extends Chessman{
    private final Vector forward = new Vector(0, 1);
    private final Vector[] attack = {
            new Vector(1, 1),
            new Vector(-1, 1)
    };
    public Pawn(Player owner, Vector position){
        super(owner, position, 1, 1, null, "Pawn", "");
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
