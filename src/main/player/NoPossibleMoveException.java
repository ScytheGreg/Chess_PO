package player;

public class NoPossibleMoveException extends Exception{
    public NoPossibleMoveException(Player player, int timeId) {
        super("Player " + player + " cannot make move at time " + timeId);
    }
}
