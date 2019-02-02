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
    
    public String checkResult() {
        String result = "";
        boolean win = false;

        win = checkWin(0, 0, 0, "horizontal");

        return result;
    }

    private boolean checkWin(int x, int y, int checked, String direction) {

        if (checked == 3) {
            return true;
        }
        if (x < 0 || x > 2 || y < 0 || y > 2 || squares[x][y] == null) {
            return false;
        }

        if (direction.equals("horizontal")) {
            if (squares[x][y + 1] == null) {
                return false;
            } else if (squares[x][y].equals(squares[x][y + 1])) {
                checkWin(x, y + 1, checked + 1, "horizontal");
            } else if (x == 2) {
                checkWin(x + 1, y + 1, checked + 1, "horizontal");
            } else {
                checkWin(0, 0, checked + 1, "vertical");
            }

        }
        return false;
    }
}
