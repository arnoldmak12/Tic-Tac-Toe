public class Board {

    private Square[][] squares;

    public Board() {
        this.squares = new Square[3][3];
    }

    /* checks if square is empty or not
     * @param int r, row of square location
     * @param int c, col of square location
     * @return true for empty square, false for square with piece
     */
    public boolean isValid(int r, int c) {
        return squares[r][c].getPiece() == null;
    }

    /**Places piece with the given type at the given square.
     * @param piece will either be piece x or piece o.
     * @param int r is either 0, 1, or 2. Represents the row of the 2D array.
     * @param int c is either 0, 1, or 2. Represents the column of the 2D array
     */
    public void movePiece(Piece piece, int r, int c) {
    	squares[r][c].setPiece(piece);
    }
}
