public abstract class Piece {

    private int x;
    private int y;

    public Piece(int X, int Y) {
        this.x = X;
        this.y = Y;
    }

    private int getX() {
        return this.x;
    }

    private int getY() {
        return this.y;
    }
}
