package board;

public class Directions {

    public static final Vector[] straight =
            {
                    new Vector(1, 0), // N
                    new Vector(0, 1), // E
                    new Vector(-1, 0),// S
                    new Vector(0, -1) // W
            };

    public static final Vector[] diagonal = {
            new Vector(1, 1), // NE
            new Vector(-1, 1), // SE
            new Vector(-1, -1),// SW
            new Vector(1, -1) // NW
    };
}
