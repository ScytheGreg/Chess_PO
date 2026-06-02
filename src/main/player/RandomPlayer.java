package player;

import move.Move;

import java.util.LinkedList;
import java.util.Random;

public class RandomPlayer extends Player{
    int seed;

    public RandomPlayer(String name, int seed){
        super(name);
        this.seed = seed;
    }

    @Override
    public Move chooseMove(LinkedList<Move> possibleMoves){
        Random gen = new Random(seed);
        int n = possibleMoves.size();
        int k = Math.abs(gen.nextInt()) % n;
        return possibleMoves.get(k);
    }
}
