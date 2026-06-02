package chessman;

import board.Square;
import player.Player;

public class Rook extends Chessman{
    public Rook(Player owner, Square position){
        super(owner, position, 5, 8, Directions.straight, "Rook", "R");
    }
}
