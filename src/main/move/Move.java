package move;

import board.*;
import board.exception.outdatedMoveException;
import chessman.Chessman;

public class Move {
    private final Chessman movedChessman;
    private final Square target;
    private final int timeToken;

    public Move(Chessman movedChessman, Square target, int timeToken){
        this.movedChessman = movedChessman;
        this.target = target;
        this.timeToken = timeToken;
    }

    public Chessman getMovedChessman(){return movedChessman;};
    public Square getTarget(){return target;}

    public void apply(Board board){
        if (timeToken != board.getTimeId()){
            throw new outdatedMoveException(timeToken, board.getTimeId());
        }
        movedChessman.attack(target);
    }

}
