package game;

import board.Board;
import player.NoPossibleMoveException;
import player.Player;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Game {
    private final Board board;
    private final Player[] players;
    private final int moveLimit;
    private boolean stalemate = false;

    public Game(Player white, Player black, int moveLimit){
        board = Board.instance();
        board.prepareGame(new ChessmanSet(white, black));
        players = new Player[] {white, black};
        this.moveLimit  = moveLimit;
    }

    public boolean doesEnd(){
        if (board.getTimeId() >=  moveLimit)
            return true;
        for (Player player : players){
            if (player.getFigurePoints() < 1000){ // King is dead
                return true;
            }
        }
        return stalemate;
    }

    public void play(){
        int k = 0, n = players.length;
        while (!doesEnd()){
            try {
                players[k].play(board);
                ++k;
                k %= n;
            }catch (NoPossibleMoveException e){
                System.out.println(e.getMessage());
                stalemate = true;
                break;
            }
        }
        System.out.println(this);
    }

    public LinkedList<Player> winnerList(){
        if (doesEnd()){
            PriorityQueue<Player> results =
                    new PriorityQueue<>(Arrays.asList(players));
            return new LinkedList<>(results);
        }
        return null;
    }

    @Override
    public String toString(){
        String endRemark = "";
        if (stalemate){
            endRemark += "Game has end with stalemate. There's a tie";
        }

        if (doesEnd()){
            endRemark += "\nRanking:\n";
            int place = 1;
            for (Player player : winnerList()){
                endRemark += ("\t" + place + ". " + player.stats() + "\n");
                ++place;
            }
        }

        return "Chess game: (w) " + players[0] + " vs (b) "
                + players[1] + endRemark;
    }
}
