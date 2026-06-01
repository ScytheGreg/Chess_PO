package board.exception;

import board.Vector;

public class vectorOutOfBoundException extends RuntimeException {
    public vectorOutOfBoundException(Vector badVector) {
        super("Vector out of bound: " + badVector.toString());
    }
}
