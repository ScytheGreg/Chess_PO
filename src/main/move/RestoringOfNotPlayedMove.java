package move;

public class RestoringOfNotPlayedMove extends RuntimeException {
    public RestoringOfNotPlayedMove(String move, int timeId) {
        super("Tried to restore not played move " + move + "at time: " + timeId);
    }
}
