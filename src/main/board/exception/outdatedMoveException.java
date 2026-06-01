package board.exception;

public class outdatedMoveException extends RuntimeException {
    public outdatedMoveException(int expected, int actual) {

        super("Outdated move. Move was accepted at timeId " + expected + ", but is called at timeId " + actual);
    }
}
