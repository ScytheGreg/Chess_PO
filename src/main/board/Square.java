package board;

import board.exception.IllegalSquareLetterException;
import chessman.Chessman;
import player.Player;

import java.util.ArrayList;

public class Square extends Vector{

    private Chessman chessman = null;
    public Square(int x, int y){
        super(x, y);
    }
    public Square(char x, int y){
        if ('a' <= x && x <= 'h'){
            x -= 'a';
        } else if ('A' <= x && x <= 'H'){
            x -= 'A';
        }
        else {
            throw new IllegalSquareLetterException(x);
        }
        super(x, y);
    }
    public Square(Vector coordinates){
        super(coordinates);
    }

    @Override
    public String toString(){
        return String.format("%c%d", 'a' + getX(), getY() + 1);
    }

    public Chessman getChessman() {
        return chessman;
    }

    public void setChessman(Chessman soldier){
        chessman = soldier;
    }

    public boolean isFree(){
        return chessman == null;
    }
    public Player getOwner(){
        return chessman.getOwner();
    }

    private Square[]  neighbours(Vector[] directions, Board board){
        ArrayList<Square> result = new ArrayList<>();
        for(Vector dir : directions){
            Square neighbour = this;
            neighbour.add(dir);
            if(board.contains(neighbour)){
                result.add(neighbour);
            }
        }
        return result.toArray(new Square[0]);
    }

    public void leave(){
        chessman = null;
    }

    public void attack(Chessman raider){
        if (chessman != null){
            chessman.beTaken();
        }
        chessman = raider;
    }
}
