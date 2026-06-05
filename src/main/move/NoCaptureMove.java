package move;

import board.Square;
import chessman.Chessman;

public class NoCaptureMove extends Move{

    public NoCaptureMove(Chessman movedChessman, Square target, int timeToken){
        super(movedChessman, target, timeToken);
        if (!target.isFree()){
            throw  new InvalidMoveException("No capture move has to have clean target");
        }
    }

    public int takenMaterial(){
        return 0;
    }


    @Override public String toString(){
        return "(" +  getMovedChessman().getShortName() + ") " + getStation() + " " + getTarget();
    }
}
