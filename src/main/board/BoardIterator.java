package board;

import java.util.Iterator;
import java.util.NoSuchElementException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BoardIterator implements Iterator<Square> {
    private final Square[][] board;
    private int currentRow = 0;
    private int currentCol = 0;

    // The constructor accepts the 2D array to iterate over
    public BoardIterator(Square[][] board) {
        this.board = board;
    }

    @Override
    public boolean hasNext() {
        // Loop through rows to see if there are any columns left to read
        while (currentRow < board.length) {
            if (currentCol < board[currentRow].length) {
                return true;
            }
            // End of the current row reached -> move to the start of the next row
            currentCol = 0;
            currentRow++;
        }
        return false;
    }

    @Override
    public Square next() {
        // Always check if another element exists before retrieving it
        if (!hasNext()) {
            throw new NoSuchElementException("No more squares left on the board.");
        }

        // Grab the current square and advance the column pointer
        Square square = board[currentRow][currentCol];
        currentCol++;

        return square;
    }
}