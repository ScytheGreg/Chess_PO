package board.exception;

public class IllegalVectorLetterException extends IllegalArgumentException{
    public IllegalVectorLetterException(char argument){
        super("Vector x-axis may be a" + " letter from 'a' to 'z'" +
                " upper or lower case. Got:" + argument);
    }
}
