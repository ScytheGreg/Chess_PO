package player;

import move.Move;
import randomness.UniqueGenerator;

import java.util.LinkedList;
import java.util.Random;

public abstract class  AbstractRandomPlayer extends Player {
    private Random gen;
    public AbstractRandomPlayer(String name, boolean upperCase, int seed){
        super(name, upperCase);
        gen = UniqueGenerator.getGen(seed);
    }


    public Move uniformDecision(LinkedList<Move> possibleMoves){
        int n = possibleMoves.size();
        int k = Math.abs(gen.nextInt() % n);
        return possibleMoves.get(k);
    }
}
