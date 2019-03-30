//Board is a background representation of the Tic Tac Toe board
public class Board {

    private Square[][] squares;

    public Board() {
        squares = new Square[3][3];
        for(int i = 0; i < 3; i++)
        {
        	for(int k = 0; k < 3; k++)
        	{
        		squares[i][k] = new Square();
        	}
        }
    }

    /**
     * Checks if square is empty or not
     *
     * @param r
     *            Either 0, 1, or 2. Represents the row of the 2D array.
     * @param c
     *            Either 0, 1, or 2. Represents the column of the 2D array.
     * @return true for empty square, false for square with piece
     */
    public boolean isEmpty(int r, int c) {
        return squares[r][c].getPiece() == null;
    }

    /**
     * Places piece with the given type at the given square.
     *
     * @param piece
     *            Will either be piece x or piece o.
     * @param r
     *            Either 0, 1, or 2. Represents the row of the 2D array.
     * @param c
     *            Either 0, 1, or 2. Represents the column of the 2D array
     * 
     */
    public void movePiece(Piece piece, int r, int c) {
        squares[r][c].setPiece(piece);
    }
    /**
     * Removes the piece at the given board location
     * @param r
     * The row of the square.
     * @param c
     * The column of the square.
     */
    public void removePiece(int r, int c)
    {
    	squares[r][c].setPiece(null);
    }
    
    /**
     * Checks status of tic tac toe board
     * 
     * @return String that corresponds to status on the board. "Not Done" is not done, "Tie" is tie, "O" is O wins, and "X" is X wins.
     */
    public String checkResult()
    {
    	String result = "Not Done";
    	int win = 0;
    	win = status();
    	if(win == 3)
    	{
    		result = "O";
    	}
    	else if(win == 6)
    	{
    		result = "X";
    	}
    	else if(win == 1)
    	{
    		result= "Tie";
    	}
    	return result;
    }
    
    /**
     * Calculates and quantifies the status of tic tac toe board.
     * 
     * @return int that corresponds to status on the board. 0 is not done, 1 is tie, 3 is O wins, and 6 is X wins.
     */
    private int status()
    {
    	int[][] results = new int[3][3];
    	Piece p = new PieceO();
    	int sum = 0;
    	for(int i = 0; i < 3; i++)
    	{
    		for(int k = 0; k < 3; k++)
    		{
    			if(isEmpty(i,k))
    			{
    				results[i][k] = 0;
    			}
    			else if(squares[i][k].getPiece().getClass().equals(p.getClass()))
    			{
    				results[i][k] = 1;
    				sum +=1;
    			}
    			else
    			{
    				results[i][k] = 2;
    				sum +=2;
    			}
    		}
    	}
    	for(int j = 0; j < 3; j++)
    	{
    		if(results[0][j] == results[1][j] && results[0][j] == results[2][j] && results[0][j]!= 0)
    		{
    			return results[0][j]*3;
    		}
    		else if(results[j][0] == results[j][1] && results[j][0] == results[j][2] && results[j][0]!= 0)
    		{
    			return results[j][0]*3;
    		}
    	}
    	if((results[0][0] == results[1][1] && results[0][0] == results[2][2] && results[0][0]!= 0))
    	{
    		return results[0][0]*3;
    	}
    	else if(results[2][0] == results[1][1] && results[2][0] == results[0][2] && results[2][0]!= 0)
    	{
    		return results[2][0]*3;
    	}
    	if(sum == 14)
    	{
    		return 1;
    	}
    	return 0;
    }    	
    /**
     * Transfers the current game board to a copy.
     * 
     * @return a copy of the actual board.
     */
	public Board transferBoard() {
		Board copy = new Board();
			for(int i = 0; i < squares.length; i++) {
				for(int j = 0; j < squares[0].length; j++) {
					if(!isEmpty(i,j) && squares[i][j].getPiece().getClass().equals(new PieceX().getClass())) {
						copy.movePiece(new PieceX(),i,j);
					}
					else if(!isEmpty(i,j) && squares[i][j].getPiece().getClass().equals(new PieceO().getClass())) {
						copy.movePiece(new PieceO(),i,j);
					}
				}
			}
			return copy;
		}
	/**
	 * Generates a number that represents the overall position of the board. A positive number is better for O, a negative number is better for X.
	 * 
	 * @return value representing the overall position of the board.
	 */
	public int evaluatePosition()
	{
		int sum = 0;
		//each row
		for(int i = 0; i < 3; i++)
		{
			sum += evaluateLine(i,0,i,1,i,2);
		}
		//each column
		for(int k = 0; k < 3; k++)
		{
			sum += evaluateLine(0,k,1,k,2,k);
		}
		//diagonals
		sum += evaluateLine(0,0,1,1,2,2);
		sum += evaluateLine(0,2,1,1,2,0);
		return sum;
		
	}
	/**
	 * Helper method for evaluate. Evaluates and quantifies the board position for a given line.
	 * 
	 * @param r1
	 * Row of the first square.
	 * @param c1
	 * Column of the first square.
	 * @param r2
	 * Row of the second square.
	 * @param c2
	 * Column of the second square.
	 * @param r3
	 * Row of the third square.
	 * @param c3
	 * Column of the third square.
	 * @return Returns 0 whenever pieces of opposing types are in the same line, or if the line has no pieces in it.
	 * Returns +/- 1 whenever only 1 piece of the same type is in the line and other 2 positions are empty.
	 * Returns +/- 10 whenever only 2 pieces of the same type are in the line and other position is empty.
	 * Returns +/- 100 whenever all 3 pieces in a line are of the same type.
	 */
	private int evaluateLine(int r1, int c1, int r2, int c2, int r3, int c3)
	{
		int value = 0;
		//first box in the line
		if(!isEmpty(r1,c1) && squares[r1][c1].getPiece().getClass().equals(new PieceO().getClass()))
		{
			value = 1;
		}
		else if(!isEmpty(r1,c1) && squares[r1][c1].getPiece().getClass().equals(new PieceX().getClass()))
		{
			value = -1;
		}
		//checks second box in line and stops if the pieces oppose each other
		if(!isEmpty(r2,c2) && squares[r2][c2].getPiece().getClass().equals(new PieceO().getClass()))
		{
			if(value == -1)
			{
				return 0;
			}
			else if(value == 1)
			{
				value = 10;
			}
			else
			{
				value = 1;
			}
		}
		else if(!isEmpty(r2,c2) && squares[r2][c2].getPiece().getClass().equals(new PieceX().getClass()))
		{
			if(value == 1)
			{
				return 0;
			}
			else if(value == -1)
			{
				value = -10;
			}
			else
			{
				value = -1;
			}
		}
		//checks third box in line
		if(!isEmpty(r3,c3) && squares[r3][c3].getPiece().getClass().equals(new PieceO().getClass()))
		{
			if(value < 0)
			{
				return 0;
			}
			else if(value > 0)
			{
				return value*10;
			}
		}
		else if(!isEmpty(r3,c3) && squares[r3][c3].getPiece().getClass().equals(new PieceX().getClass()))
		{
			if(value > 0)
			{
				return 0;
			}
			else if(value < 0)
			{
				return value*10;
			}
		}
		return value;
	}
	/**
	 * Clears and resets the board to an empty board.
	 */
	public void clearBoard()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int k = 0; k < 3; k++)
			{
				squares[i][k].setPiece(null);
			}
		}
	}

}

	
