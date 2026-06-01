package board.exception;

public class incorrectMoveException extends RuntimeException {
    public incorrectMoveException(String message) {
        super(message);
    }
}
