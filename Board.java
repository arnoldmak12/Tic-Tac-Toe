public class Board {

    private Square[][] squares;

    public Board() {
        squares = new Square[3][3];
    }

    /**
     * Checks if square is empty or not
     *
     * @param r
     *            either 0, 1, or 2. Represents the row of the 2D array.
     * @param c
     *            either 0, 1, or 2. Represents the column of the 2D array.
     * @return true for empty square
     * @return false for square with piece
     */
    public boolean isEmpty(int r, int c) {
        return squares[r][c].getPiece() == null;
    }

    /**
     * Places piece with the given type at the given square.
     *
     * @param piece
     *            will either be piece x or piece o.
     * @param r
     *            either 0, 1, or 2. Represents the row of the 2D array.
     * @param c
     *            either 0, 1, or 2. Represents the column of the 2D array
     */
    public void movePiece(Piece piece, int r, int c) {
        squares[r][c].setPiece(piece);
    }
}
