package player;

import move.Move;

import java.util.LinkedList;

public class GreedyRandomPlayer extends AbstractRandomPlayer{

    public GreedyRandomPlayer(String name, boolean upperCase, int seed){
        super(name, upperCase, seed);
    }

    public Move chooseMove(LinkedList<Move> possibleMoves){
        return possibleMoves.get(0);
    }
}
