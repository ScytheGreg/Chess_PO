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
    public Pawn(Player owner, Square position){
        super(owner, position, 1, 1, null, "Pawn", "");
    }

    @Override
    public LinkedList<Move> legalMoves(Board board){
        LinkedList<Move> result = new LinkedList<>();
        int timeId = board.getTimeId();

        // Forward move
        Square target = new Square(getPosition());
        target.add(forward);
        if (board.contains(target)){
            target = board.getSquare(target);
            if (target.isFree()){
                result.addLast(new Move(this, target, timeId));
            }
        }

        // Diagonal attack
        for(Vector dir : attack) {
            target = new Square(getPosition());
            target.add(dir);
            if (board.contains(target)){
                target = board.getSquare(target);
                if (!target.getOwner().equals(getOwner())){
                    result.addLast(new Move(this, target, timeId));
                }
            }
        }

        return result;
    }
}
