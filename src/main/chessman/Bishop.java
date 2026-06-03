package chessman;

import board.Vector;
import player.Player;

public class Bishop extends Chessman{
    public Bishop(Player owner, Vector position){
        super(owner, position, 3, 8, Directions.diagonal, "Bishop", "B");
    }
}
