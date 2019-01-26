public abstract class Piece {

    private String side;
    private int x;
    private int y;

    public Piece() {

    }

    private void setSide(String s) {
        this.side = s;
    }

    private void setX(int X) {
        this.x = X;
    }

    private void setY(int Y) {
        this.y = Y;
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

