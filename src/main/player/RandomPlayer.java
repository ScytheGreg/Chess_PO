package player;

import move.Move;

import java.util.Iterator;
import java.util.Random;

public class RandomPlayer extends Player {
    Random gen;

    public RandomPlayer(String name, int seed) {
        super(name);
        this.gen = new Random(seed);
    }

    @Override
    public Move chooseMove(Iterator<Move> possibleMoves) {
        Move possibility;
        do {
            possibility = possibleMoves.next();
            if (gen.nextDouble() < 0.3){
                return possibility;
            }
        } while ((possibleMoves.hasNext()));
        return possibility;
    }
}
