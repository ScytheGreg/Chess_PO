package board;

import chessman.Chessman;

import java.util.ArrayList;

public class Square extends Vector{


    private Chessman chessman = null;
    public Square(int x, int y){
        super(x, y);
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


}
