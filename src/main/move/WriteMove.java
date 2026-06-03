package move;

public class WriteMove extends MoveObserver {

    private static WriteMove uniqueWriter;

    public static WriteMove instance(){
        if (uniqueWriter == null){
            uniqueWriter = new WriteMove();
        }
        return uniqueWriter;
    }

    private WriteMove(){}

    @Override
    public void update(Move playedMove) {
        System.out.println(String.format("%-3s" ,playedMove.getTimeToken() + ".") + playedMove);
    }
}
