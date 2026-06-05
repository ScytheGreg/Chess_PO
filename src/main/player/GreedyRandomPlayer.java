package player;

import board.Board;
import move.Move;

import java.util.LinkedList;

public class GreedyRandomPlayer extends AbstractRandomPlayer{

    public GreedyRandomPlayer(String name, boolean upperCase, int seed){
        super(name, upperCase, seed);
    }

    public Move chooseMove(LinkedList<Move> possibleMoves, Board board){
        int bestProfit = 0;
        LinkedList<Move> candidates = new LinkedList<>();
        for (Move candidate : possibleMoves){
            if (candidate.takenMaterial() > bestProfit){
                candidates.clear(); // Previous candidates are weaker
                bestProfit = candidate.takenMaterial(); // Update best profit from Move
                candidates.push(candidate);
            }
            else if (candidate.takenMaterial() == bestProfit){
                candidates.push(candidate);
            }
        }
        return uniformDecision(candidates);
    }
}
