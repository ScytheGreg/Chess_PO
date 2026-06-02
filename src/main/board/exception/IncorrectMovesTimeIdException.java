package board.exception;

public class IncorrectMovesTimeIdException extends RuntimeException {
    public IncorrectMovesTimeIdException(int expected, int actual) {

        super("Incorrect timeof Move. Move was accepted at timeId " + expected + ", but is called at timeId " + actual);
    }
}
