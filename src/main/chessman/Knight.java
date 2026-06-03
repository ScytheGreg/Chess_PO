package chessman;

import board.Vector;
import player.Player;

public class Knight extends Chessman{
    public Knight(Player owner, Vector position){
        super(owner, position, 3, 1, Directions.knight ,"N");
    }
}
