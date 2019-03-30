//Class for each individual square on the board
public class Square {

    private Piece piece;

    public Square() {
        piece = null;
    }

    /**
     * Sets the piece for a specific square
     * @param p
     * The piece being placed on the square
     */
    public void setPiece(Piece p) {
        piece = p;
    }

    /**
     * Gets the piece at the given square
     * @return the piece at the given square
     */
    public Piece getPiece() {
        return piece;
    }
}
