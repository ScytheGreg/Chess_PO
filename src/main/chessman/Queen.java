package chessman;

import board.Vector;
import player.Player;

public class Queen extends Chessman{
    public Queen(Player owner, Vector position){
        super(owner, position, 9, 8, Directions.windRose, "Queen", "Q");
    }
}
