package move;

import board.Board;

public class BoardPrinter extends MoveObserver{
    private static BoardPrinter uniquePrinter;
    private final Board board = Board.instance();

    public static BoardPrinter instance(){
        if (uniquePrinter == null){
            uniquePrinter = new BoardPrinter();
        }
        return uniquePrinter;
    }

    @Override
    public void update(Move playedMove) {
        System.out.println(board);
    }
}
