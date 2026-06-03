package player;

import move.Move;

import java.util.Iterator;
import java.util.Random;

public class RandomPlayer extends Player {
    Random gen;
    private double willingness;

    public RandomPlayer(String name, int seed, double willingness) {
        super(name);
        this.gen = new Random(seed);
        if (willingness < 0 || willingness > 1){
            throw new IllegalArgumentException("Willingness must be in range [0, 1]");
        }
        this.willingness = willingness;
    }

    @Override
    public Move chooseMove(Iterator<Move> possibleMoves) {
        Move possibility;
        do {
            possibility = possibleMoves.next();
            if (gen.nextDouble() < willingness){
                return possibility;
            }
        } while ((possibleMoves.hasNext()));
        return possibility;
    }
}
