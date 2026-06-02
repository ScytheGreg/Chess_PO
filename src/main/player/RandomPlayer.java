package player;

import board.Board;
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
    public void play(Board board){
        LinkedList<Move> possibleMoves = board.legalMoves(this);

        Random gen = new Random(seed);
        try {
            int n = possibleMoves.size();
            int k = Math.abs(gen.nextInt()) % n;
            Move playThis = possibleMoves.get(k);
            playThis.apply(board);
        }
        catch(ArithmeticException e){
            throw NoPossibleMoveException(this, board.getTimeId());
        }
    }
}
