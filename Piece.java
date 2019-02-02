public abstract class Piece {

    
    private int r;
    private int c;

    public Piece(int R,int C) {
        r = R;
        c = C;
    }
   
   /**Returns the row of the piece
    *
    * @return row number of piece
    */
    public int getR() {
        return r;
    }
    /**Returns the column of the piece
    *
    * @return column number of piece
    */
    public int getC() {
        return c;
    }
}

