package chessman;

import board.Square;
import player.Player;

public class Knight extends Chessman{
    public Knight(Player owner, Square position){
        super(owner, position, 3, 1, Directions.knight);
    }
}
