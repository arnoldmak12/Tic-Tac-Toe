import java.util.ArrayList;

public class Computer implements Player {
	private gameView frame;
	private Board board;
	private int pruneCounts;

    public Computer(gameView frame1, Board board1) {
    	frame = frame1;
    	board = board1;
    	pruneCounts = 0;

    }
    /*depth represents how many moves deep the computer calculates.
     * currentBoard is, well,the current board position that the computer is evaluating
     * maxOrMin is true when it is a maximizing node, false when its a minimizing node. Will switch with each method call.
     * alpha is the maximizer, which is the best possible value for O
     * beta is the minimizer, which is the best possible value for X
     */
    public int[] minimax(int depth, Board currentBoard, boolean maxOrMin, int alpha, int beta)
    {
    	ArrayList<int[]> emptySpots = getAvailableSpots(currentBoard);
    	int r = -1;
    	int c = -1;
    	int score = 0;
    	//goes here when game is over
    	if(!currentBoard.checkResult().equals("Not Done"))
    	{
    		//is maximizer node, use alpha. otherwise, its a minimizer node, so use beta
    		if(maxOrMin)
    		{
    			alpha = currentBoard.evaluatePosition();
    		}
    		else
    		{
    			beta = currentBoard.evaluatePosition();
    		}
    		
    	}
    	//goes here when it reaches how deep you want the computer to analyze. Changing this value can change the behavior of the computer.
    	else if(depth == 9)
    	{
    		if(maxOrMin)
    		{
    			alpha = currentBoard.evaluatePosition();
    		}
    		else
    		{
    			beta = currentBoard.evaluatePosition();
    		}
    	}
    	//when game isnt over and depth hasnt been reached, evaluate the next possible move
    	else
    	{
    		//goes through every possible move
    		for(int[] move : emptySpots)
    		{
    			//uncomment this section when you want to see what the computer is thinking throughout the process.
    			
    			/*currentBoard.transferBoard();
    			System.out.println(depth + " " + move[0] + " " + move[1] + " " + alpha + " " + beta);
    			try {
    				Thread.sleep(100);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}*/
    			
    			//if there are an even number of empty spots left, then its O's turn. if its an odd number, its X's turn.
    			if(emptySpots.size()%2 == 0)
    			{
    				currentBoard.movePiece(new PieceO(), move[0], move[1]);
    				//here if maximizing
    				if(maxOrMin)
    				{
    					/*calls it again and adds one to depth since it will calulate the next possible moves in this position.
    					maxOrMin gets flipped because the maximizer and minimizer nodes swap when you go further down the tree*/
    					score = minimax(depth+=1, currentBoard, !maxOrMin, alpha, beta)[0];
    					depth-=1;
        				if(score > alpha)
        				{
        					alpha = score;
        					r = move[0];
        					c = move[1];
        				}
    				}
    				//here if minimizing
    				else
    				{
    					score = minimax(depth+=1, currentBoard, !maxOrMin, alpha, beta)[0];
    					depth-=1;
        				if(score < beta)
        				{
        					beta = score;
        					r = move[0];
        					c = move[1];
        				}
    				}
    				
    				
    			}
    			//goes here when its X's turn
    			else
    			{
    				currentBoard.movePiece(new PieceX(), move[0], move[1]);
    				if(maxOrMin)
    				{
    					score = minimax(depth+=1, currentBoard, !maxOrMin, alpha, beta)[0];
    					depth-=1;
        				if(score > alpha)
        				{
        					alpha = score;
        					r = move[0];
        					c = move[1];
        				}
    				}
    				else
    				{
    					score = minimax(depth+=1, currentBoard, !maxOrMin, alpha, beta)[0];
    					depth-=1;
        				if(score < beta)
        				{
        					beta = score;
        					r = move[0];
        					c = move[1];
        				}
    				}
    			}
    			/*after you go through a move, you have to remove that piece from the board to reset to the position it had before.
    			This way, it can check the next available move with the previous position.*/
    			currentBoard.removePiece(move[0], move[1]);
    			
    			//if it has evaluated a move that results to a win, ignore all future cases.
    			if(alpha >= 50 || beta <= -50)
    			{
    				break;
    			}
    			//will ignore the other possible moves in this position when this is true.
    			//pruneCounts is just a variable that let me see how many times this happened with each move. The total gets printed to the console each move.
    			if(alpha >= beta)
    			{
    				pruneCounts+=1;
    				break;
    			}
    			
    		}
    	}
    	//if first call was maximizer, returns alpha. if first call was minimizing, returns beta
    	if(maxOrMin)
    	{
    		return new int[] {alpha,r,c};
    	}
    	return new int[] {beta, r, c};
    	
    }
    
    public int[] makeMove()
    {
    	//i dont really know if this is needed or not. you might be able to just call minimax with board
    	Board temp = board.transferBoard();
    	int move[];
    	//if computer is O, it wants to maximize the value. a positive score = better for O
    	if(getAvailableSpots(board).size()%2 == 0)
    	{
    		move = minimax(0,temp,true, Integer.MIN_VALUE, Integer.MAX_VALUE);
    	}
    	//if computer is X, it wants to minimize the value. a negative score = better for X
    	else
    	{
    		move = minimax(0,temp,false, Integer.MIN_VALUE, Integer.MAX_VALUE);
    	}
    	int[] result = new int[2];
    	//prints number of times alpha beta pruning was used to the console and resets pruneCounts
    	System.out.println(pruneCounts);
    	pruneCounts = 0;
    	result[0] = move[1];
    	result[1] = move[2];
    	return result;
    }
    //creates an arraylist of every empty spot on the given board
    public ArrayList<int[]> getAvailableSpots(Board currentBoard)
    {
    	ArrayList<int[]> spots = new ArrayList<int[]>();
    	for(int i = 0; i < 3; i++)
    	{
    		for(int k = 0; k < 3; k++)
    		{
    			if(currentBoard.isEmpty(i, k))
    			{
    				spots.add(new int[] {i,k});
    			}
    		}
    	}
    	return spots;
    }
}
