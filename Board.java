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
     *            either 0, 1, or 2. Represents the row of the 2D array.
     * @param c
     *            either 0, 1, or 2. Represents the column of the 2D array.
     * @return true for empty square, false for square with piece
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
     * Checks status of tic tac toe board
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

	public void showBoard() {
			for(int i = 0; i < squares.length; i++) {
				for(int j = 0; j < squares[0].length; j++) {
					if(!isEmpty(i,j) && squares[i][j].getPiece().getClass().equals(new PieceX().getClass())) {
						System.out.print("X\t");
					}
					else if(!isEmpty(i,j) && squares[i][j].getPiece().getClass().equals(new PieceO().getClass())) {
						System.out.print("O\t");
					}
					else {
						System.out.print("\t");
					}
				}
				System.out.println();
			}
			System.out.println("\n");
		}
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

	


	
