package chessman;

import board.Square;
import player.Player;

public class King extends Chessman {
    public King(Player owner, Square position) {
        super(owner, position, 1000, 1, Directions.windRose, "King", "K");
    }
}
