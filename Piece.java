public abstract class Piece {

    private String side;
    private int x;
    private int y;

    public Piece(int X, int Y, String s) {
        this.x = X;
        this.y = Y;
        this.side = s;
    }

    private String getSide() {
        return this.side;
    }

    private int getX() {
        return this.x;
    }

    private int getY() {
        return this.y;
    }
}
