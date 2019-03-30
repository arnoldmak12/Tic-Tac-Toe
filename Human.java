/**
 * How the user will interact with the board
 */
public class Human implements Player {
	private gameView frame;

    public Human(gameView frame1) {
    	frame = frame1;
    	
    }
    
    /**
     * Gets the slected move from the user
     *
     * @return int[] of size 2, index 0 for the row and index 1 for the column selected by user
     */
    public int[] makeMove() {
    	boolean waiting = true;
    	int[] move = new int[2];
    	while(waiting)
    	{
    		System.out.print("");
    		if(frame.getMove()[0] != -1 && frame.getMove()[1] != -1)
    		{
    			move = frame.getMove();
    			waiting = false;
    		}
    	}
        return move;
    }
}
