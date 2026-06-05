package player;

import board.Board;
import move.Move;

import java.util.LinkedList;

public class CalculatingRandomPlayer extends AbstractRandomPlayer{

    public CalculatingRandomPlayer(String name, boolean upperCase, int seed){
        super(name, upperCase, seed);
    }

    public Move chooseMove(LinkedList<Move> possibleMoves, Board board){
        Player opponent = board.getOpponent(this);

        int bestBalance = Integer.MIN_VALUE;
        LinkedList<Move> candidates = new LinkedList<>();

        for (Move candidate : possibleMoves){
            if (candidate.getInstanceWin()){
                return candidate;
            }
            int profit = candidate.takenMaterial();
            candidate.apply(board);
            for (Move versus : iteratorToList(board.legalMoves(opponent))){
                int balance = profit - versus.takenMaterial();
                if (balance > bestBalance){
                    candidates.clear();
                    candidates.add(candidate);
                    bestBalance = balance;
                }
                else if (balance == bestBalance){
                    candidates.add(candidate);
                }
            }
            candidate.restore(board);
        }

        return uniformDecision(candidates);
    }

}
