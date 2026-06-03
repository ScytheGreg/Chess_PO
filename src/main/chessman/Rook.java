package chessman;

import board.Vector;
import player.Player;

public class Rook extends Chessman{
    public Rook(Player owner, Vector position){
        super(owner, position, 5, 8, Directions.straight, "Rook", "R");
    }
}
