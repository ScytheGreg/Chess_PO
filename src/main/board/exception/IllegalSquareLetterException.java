package board.exception;

public class IllegalSquareLetterException extends IllegalArgumentException{
    public IllegalSquareLetterException(char argument){
        super("Square name must be a" + " letter from 'a' to 'h'" +
                " upper or lower case. Got:" + argument);
    }
}
