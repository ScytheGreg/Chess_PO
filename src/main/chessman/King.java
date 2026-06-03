package chessman;

import board.Vector;
import player.Player;

public class King extends Chessman {
    public King(Player owner, Vector position) {
        super(owner, position, 1000, 1, Directions.windRose, "K");
    }
}
