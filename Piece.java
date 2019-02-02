public abstract class Piece {

    private int x;
    private int y;

    public Piece(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

