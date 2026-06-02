package game;

import board.Board;
import player.Player;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Game {
    private final Board board;
    private final Player[] players;
    private final int table = 22;
    private final int round = 67;

    public Game(Player white, Player black){
        board = new Board(new ChessmanSet(white, black));
        players = new Player[] {white, black};
    }

    public boolean doesEnd(){
        if (board.getTimeId() >=  50)
            return true;
        for (Player player : players){
            if (player.getFigurePoints() < 1000){ // King is dead
                return true;
            }
        }
        return false;
    }

    public void play(){
        int k = 0, n = players.length;
        while (!doesEnd()){
            players[k].play(board);
            ++k;
            k %= n;
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
        if (doesEnd()){
            endRemark += "\nRanking:\n";
            int place = 1;
            for (Player player : winnerList()){
                endRemark += ("\t" + place + ". " + player + "\n");
                ++place;
            }
        }

        return "Chess game: (w)" + players[0] + " vs (b)" + players[1]
                + "\nTable " + table + " Round " + round + endRemark;
    }
}
