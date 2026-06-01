package chessman;

import board.Square;
import player.Player;

public class Bishop extends Chessman{
    public Bishop(Player owner, Square position){
        super(owner, position, 3, 8, Directions.diagonal);
    }
}
