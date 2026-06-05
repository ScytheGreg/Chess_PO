package move;

import board.Square;
import chessman.Chessman;

public class CaptureMove extends Move{
    private final Chessman takenChessman;
    public CaptureMove(Chessman movedChessman, Square target, int timeToken){
        super(movedChessman, target, timeToken);
        this.takenChessman = target.getChessman();
    }

    public int takenMaterial(){
        return takenChessman.getValue();
    }

    @Override
    public String toString(){
        return "("+ getMovedChessman().getShortName() + ") " + getStation() + "x" + getTarget();
    }

    public Chessman getTakenChessman(){
        return takenChessman;
    }
}
