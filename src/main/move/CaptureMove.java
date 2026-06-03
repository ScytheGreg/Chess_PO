package move;

import board.Square;
import chessman.Chessman;

public class CaptureMove extends Move{
    private final Chessman takenChessman;
    public CaptureMove(Chessman movedChessman, Square target, int timeToken, Chessman takenChessman){
        super(movedChessman, target, timeToken);
        this.takenChessman = takenChessman;
    }

    @Override
    public String toString(){
        return "("+ getMovedChessman().getShortName() + ") " + getStation() + "x" + getTarget();
    }

    public Chessman getTakenChessman(){
        return takenChessman;
    }
}
