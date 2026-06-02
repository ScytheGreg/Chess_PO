package game;

import player.Player;
import player.RandomPlayer;

public class Main {

    public static void main(String[] args){
        Player white = new RandomPlayer("John", 1);
        Player black = new RandomPlayer("Ben", 1);
        Game social = new Game(white, black);
        social.play();
    }
}
