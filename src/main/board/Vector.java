package board;

public class Vector {
    private int x, y;
    public Vector(int x, int y){
        this.x = x; this.y = y;
    }
    public Vector(Vector vector){
        this.x = vector.getX();
        this.y = vector.getY();
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }

    @Override
    public String toString(){
        return "X: " + x + " Y: " + y;
    }

    @Override
    public boolean equals(Object other){
        if ((other instanceof Vector otherVector)) {
            return (x == otherVector.getX()) && (y == otherVector.getY());
        }
        return false;
    }

    public void add(Vector other){
        x += other.getX();
        y += other.getY();
    }

    public void multiply(int scalar){
        this.x *= scalar;
        this.y *= scalar;
    }

}
