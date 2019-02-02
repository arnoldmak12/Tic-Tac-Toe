public class Square {

    private Piece piece;

    public Square() {
        this.piece = null;
    }

    private void setPiece(Piece p) {
        this.piece = p;
    }

    private Piece getPiece() {
        return this.piece;
    }
}
