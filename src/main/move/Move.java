package move;

import board.*;
import board.exception.IncorrectMovesTimeIdException;
import chessman.Chessman;

public class Move {
    private final Chessman movedChessman;
    private final Square station;
    private final Square target;
    private final int timeToken;
    private boolean wasPlayed = false;

    public Move(Chessman movedChessman, Square target, int timeToken){
        this.movedChessman = movedChessman;
        this.target = target;
        this.timeToken = timeToken;
        this.station = movedChessman.getPosition();
    }

    public Chessman getMovedChessman(){return movedChessman;}
    public Square getTarget(){return target;}

    public void apply(Board board){
        if (timeToken != board.getTimeId()){
            throw new IncorrectMovesTimeIdException(timeToken, board.getTimeId());
        }
        movedChessman.attack(target);
        board.movePerformed();
        wasPlayed = true;
    }

    public void restore(Board board){
        if (timeToken + 1 != board.getTimeId()){
            throw new IncorrectMovesTimeIdException(timeToken, board.getTimeId());
        }
        if (! wasPlayed){
            throw new RestoringOfNotPlayedMove(toString(), timeToken);
        }
        movedChessman.attack(station);
        board.moveRestored();
        wasPlayed = false;
    }

    @Override public String toString(){
        return "(" +  movedChessman.getShortName() + ") " + station + " " + target;
    }

    public int getTimeToken(){
        return timeToken;
    }

    public Square getStation(){return station;}

}
