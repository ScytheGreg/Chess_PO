package chessman;

import board.Square;
import player.Player;

public class King extends Chessman {
    public King(Player owner, Square position) {
        super(owner, position, 2222, 1, Directions.windRose);
    }
}
