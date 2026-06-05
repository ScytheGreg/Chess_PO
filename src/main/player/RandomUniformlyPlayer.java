package player;

import move.Move;
import java.util.LinkedList;

public class RandomUniformlyPlayer extends AbstractRandomPlayer {
    public RandomUniformlyPlayer(String name, boolean upperCase, int seed) {
        super(name, upperCase, seed);
    }

    @Override
    public Move chooseMove (LinkedList<Move> possibleMoves){
        return uniformDecision(possibleMoves);
    }
}
