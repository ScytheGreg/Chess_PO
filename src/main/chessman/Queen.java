package chessman;

import board.Square;
import player.Player;

public class Queen extends Chessman{
    public Queen(Player owner, Square position){
        super(owner, position, 9, 8, Directions.windRose, "Queen", "Q");
    }
}
