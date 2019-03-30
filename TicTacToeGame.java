import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//all the logic the controls the flow of the game
public class TicTacToeGame {
	private Board board;
	private Map<Player, ArrayList<int[]>> moveHistory;
	private gameView frame;
	private Player player1;
	private Player player2;
	private ArrayList<int[]> list1;
	private ArrayList<int[]> list2;
	
    /**
     * TicTacToeGame constructor, initializes instance variables needed.
     */
    public TicTacToeGame() {
    	board = new Board();
    	moveHistory = new HashMap<Player, ArrayList<int[]>>();
    	frame = new gameView(this);
    	frame.setVisible(true);
    	player1 = new Human(frame);
    	player2 = new Human(frame);
    	list1 = new ArrayList<int[]>();
    	list2 = new ArrayList<int[]>();
    	moveHistory.put(player1, list1);
    	moveHistory.put(player2, list2);
    	startGame();
        
    }
    /**
     *	Starts a new game
     */
    public void startGame() {
    	
    	//default move when there is no input
    	int[] move = new int[2];
		frame.setMove(-1,  -1);
		
		//displaying move history
		dispMoveHistory();
    	
		//loops between player1 and player 2 while game is not finished yet
    	while(board.checkResult().equals("Not Done")) {
    		
    		//Player1's Turn
    		frame.setLabel("Player 1's Turn");
    		move = player1.makeMove();
    		
    		//if move has [3 3] a new game will be started and current game will end
    		if(move[0] == 3 && move[1] == 3)
    		{
    			startGame();
    			return;
    		}
    		
    		//makes sure the move made is legal
    		while(!board.isEmpty(move[0], move[1])){
    			move = player1.makeMove();
    			
    			//if move has [3 3] a new game will be started and current game will end
    			if(move[0] == 3 && move[1] == 3)
        		{
    				startGame();
    				return;
        		}
    		}
    		
    		//sets X piece to correct place on board
    		board.movePiece(new PieceX(), move[0], move[1]); 
    		
    		//sets X image to gameView
    		frame.setPNG(move[0], move[1], "PieceX.png");
    		
    		//adds move to moveHistory
    		list1.add(new int[] {move[0], move[1]});
    		moveHistory.replace(player1, list1);
    		
    		//displays move history again after player 1's turn
    		dispMoveHistory();
    		
    		//set move to default
    		frame.setMove(-1, -1);
    		
    		//ends game if game is done
    		if(!board.checkResult().equals("Not Done")) {
    			break;
    		}
    		
    		//Player2's Turn
    		frame.setLabel("Player 2's Turn");
    		move = player2.makeMove();
    		
    		//if move has [3 3] a new game will be started and current game will end
    		if(move[0] == 3 && move[1] == 3)
    		{
    			startGame();
    			return;
    		}
    		
    		//makes sure the move made is legal
    		while(!board.isEmpty(move[0], move[1])){
    			move = player2.makeMove();
    			
    			//if move has [3 3] a new game will be started and current game will end
    			if(move[0] == 3 && move[1] == 3)
        		{
    				startGame();
    				return;
        		}
    		}
    		
    		//sets O piece to correct place on board
    		board.movePiece(new PieceO(), move[0], move[1]);
    		
    		//sets O image to gameView
    		frame.setPNG(move[0], move[1], "PieceO.png");
    		
    		//adds move to moveHistory
    		list2.add(new int[] {move[0], move[1]});
    		moveHistory.replace(player2, list2);
    		
    		//displays move history again after player 2's turn
    		dispMoveHistory();
    		
    		//set move to default
    		frame.setMove(-1, -1);
    	}
    	
    	//checks result of game
    	if(board.checkResult().equals("Tie"))
		{
    		frame.setLabel("Tie!");
		}
    	else if(board.checkResult().equals("X"))
		{
    		frame.setLabel("Player 1 Wins!");
		}
    	else if(board.checkResult().equals("O"))
		{
    		frame.setLabel("Player 2 Wins!");
		}
    	
    	//game will wait for a new game to start
    	boolean waiting = true;
    	while(waiting)
    	{
    		//while loop buffer
    		System.out.print("");
    		
    		//game will start when move is set to [3 3]
    		if(frame.getMove()[0] == 3 && frame.getMove()[1] == 3)
    		{
    			waiting = false;
    		}
    	}
    	startGame();
    }
    
    /**
     * Displays move history
     */
    public void dispMoveHistory()
    {    
    	//headers
    	String s = new String();
    	s = "\n\n    Move History";
    	s += "\n\n X:\t O:\n";
    	
    	//loops through contents of moveHistory
    	for(int i = 0; i < moveHistory.get(player1).size(); i++)
    	{
    		s += (moveHistory.get(player1).get(i)[0] + "," + moveHistory.get(player1).get(i)[1]);
    		if(i < moveHistory.get(player2).size()) {
    			s += ("\t" + moveHistory.get(player2).get(i)[0] + "," + moveHistory.get(player2).get(i)[1]);
    			s += "\n";
    		}
    	}
    	
    	//updates move history on gui
    	frame.setMoveHistory(s);
    }
    
    /**
     * Reinitializes players given menu button clicked
     *
     * @param menuName
     *            string name of menu button
     * @ensures Player player1 is set to specified object (Human or Computer)
     * 
     * @ensures Player player2 is set to specified object (Human or Computer)
     * 
     */
    public void setPlayers(String menuName)
    {
    	if(menuName.equals("Player vs. Player"))
    	{
    		//clears board and clears grid on gui
    		clear();
    		
    		//sets player1 and player2
    		player1 = new Human(frame);
    		player2 = new Human(frame);
    		
    		//clears moveHistory
    		moveHistory.clear();
    		list1.clear();
        	list2.clear();
        	
        	//puts keys and values in moveHistory
    		moveHistory.put(player1, list1);
        	moveHistory.put(player2, list2);
    	}
    	else if(menuName.equals("Player vs. Computer"))
    	{
    		//clears board and clears grid on gui
    		clear();
    		
    		//sets player1 and player2
    		player1 = new Human(frame);
    		player2 = new Computer(frame, board);
    		
    		//clears moveHistory
    		moveHistory.clear();
    		list1.clear();
        	list2.clear();
        	
        	//puts keys and values in moveHistory
    		moveHistory.put(player1, list1);
        	moveHistory.put(player2, list2);
    	}
    	else if(menuName.equals("Computer vs. Player"))
    	{
    		//clears board and clears grid on gui
    		clear();
    		
    		//sets player1 and player2
    		player1 = new Computer(frame, board);
    		player2 = new Human(frame);
    		
    		//clears moveHistory
    		moveHistory.clear();
    		list1.clear();
        	list2.clear();
        	
        	//puts keys and values in moveHistory
    		moveHistory.put(player1, list1);
        	moveHistory.put(player2, list2);
    	}
    	else if(menuName.equals("Computer vs. Computer"))
    	{
    		//clears board and clears grid on gui
    		clear();
    		
    		//sets player1 and player2
    		player1 = new Computer(frame, board);
    		player2 = new Computer(frame, board);
    		
    		//clears moveHistory
    		moveHistory.clear();
    		list1.clear();
        	list2.clear();
        	
        	//puts keys and values in moveHistory
    		moveHistory.put(player1, list1);
        	moveHistory.put(player2, list2);
    	}
    }
    
    /**
     * Clears every square in board and clears the grid in gui
     */
    public void clear()
    {
    	board.clearBoard();
    	frame.clearScreen();
    }
}
