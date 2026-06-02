package game;

import board.Square;
import chessman.*;
import player.Player;

import java.util.Iterator;

public class ChessmanSet implements Iterable<Chessman> {
    private final Chessman[][] chessmen;

    private class CSIterator implements Iterator<Chessman> {
        private int idx = 0;

        public CSIterator() {
        }

        public boolean hasNext() {
            return idx < 64;
        }

        public Chessman next() {
            int x = idx / 8;
            int y = idx % 8;
            ++idx;
            return chessmen[x][y];
        }
    }

    public ChessmanSet(Player white, Player black) {
        Chessman[] empty = new Chessman[8];
        this.chessmen = new Chessman[][] {
                figuresRow(white, 1),
                pawnsRow(white, 2),
                empty,      //3
                empty,      //4
                empty,      //5
                empty,      //6
                pawnsRow(black, 7),
                figuresRow(black, 8)
        };
    }

    public Iterator<Chessman> iterator() {
        return new CSIterator();
    }

    private Chessman[] figuresRow(Player owner, int y) {
        y -= 1;
        Square RookA = new Square('A', y);
        Square KnightB = new Square('B', y);
        Square BishopC = new Square('C', y);
        Square QueenD = new Square('D', y);
        Square KingE = new Square('E', y);
        Square BishopF = new Square('F', y);
        Square KnightG = new Square('G', y);
        Square RookH = new Square('H', y);

        return new Chessman[] {
                new Rook(owner, RookA),
                new Knight(owner, KnightB),
                new Bishop(owner, BishopC),
                new Queen(owner, QueenD),
                new King(owner, KingE),
                new Bishop(owner, BishopF),
                new Knight(owner, KnightG),
                new Rook(owner, RookH)
        };
    }
    private Chessman[] pawnsRow(Player owner,  int y) {
        y -= 1;
        Chessman[] pawns = new Chessman[8];
        for (int x = 0; x < 8; ++x) {
            Square position = new Square(x, y);
            pawns[x] = new Pawn(owner, position);
        }
        return pawns;
    }
}
