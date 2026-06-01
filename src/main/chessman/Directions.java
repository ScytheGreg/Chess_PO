package chessman;

import board.Vector;

public class Directions {
    public static final Vector[] straight =
            {
                    new Vector(1, 0), // N
                    new Vector(0, 1), // E
                    new Vector(-1, 0),// S
                    new Vector(0, -1) // W
            };

    public static final Vector[] diagonal =
            {
                    new Vector(1, 1), // NE
                    new Vector(-1, 1), // SE
                    new Vector(-1, -1),// SW
                    new Vector(1, -1) // NW
            };
    public static final Vector[] windRose =
            {
                    new Vector(1, 1), // NE
                    new Vector(-1, 1), // SE
                    new Vector(-1, -1),// SW
                    new Vector(1, -1), // NW
                    new Vector(1, 0), // N
                    new Vector(0, 1), // E
                    new Vector(-1, 0),// S
                    new Vector(0, -1) // W
            };
    public static final Vector[] knight = {
            new Vector(1, 2), // None negative
            new Vector(2, 1),

            new Vector(-1, 2), // X negative
            new Vector(-2, 1),

            new Vector(1, -2), // Y negative
            new Vector(2, -1),

            new Vector(-1, 2), // Ones negative
            new Vector(2, -1),

            new Vector(1, -2), // Twos negative
            new Vector(-2, 1)
    };


}
