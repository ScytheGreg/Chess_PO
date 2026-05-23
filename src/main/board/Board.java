package board;

public class Board {
    private final int MAX_X = 8;
    private final int MAX_Y = 8;

    private final Square[][] board;

    public Board(){
        board = new Square[MAX_X][MAX_Y];
        for(int x = 0 ; x < MAX_X ; ++x){
            for(int y = 0 ; y < MAX_Y ; ++y){
                board[x][y] = new Square(x, y);
            }
        }

    }


    public int getMAX_X() {
        return MAX_X;
    }

    public int getMAX_Y() {
        return MAX_Y;
    }


    public boolean contains(Square square) {
        return 0 <= square.getX() && square.getX() < MAX_X &&
                0 <= square.getY() && square.getY() < MAX_Y;
    }

}
