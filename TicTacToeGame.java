import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicTacToeGame {
	private Board board;
	private Map<Player, List<int[]>> moveHistory;
	private gameView frame;
	private Player player1;
	private Player player2;
	

    public TicTacToeGame() {
    	board = new Board();
    	moveHistory = new HashMap<Player, List<int[]>>();
    	frame = new gameView(this);
    	frame.setVisible(true);
    	player1 = new Human(frame);
    	player2 = new Human(frame);
    	startGame();
        
    }

    /*private Player annouceWinner() {
        return new Player();
    }*/
    

    public void startGame() {
    	int[] move = new int[2];
		frame.setMove(-1,  -1);
    	
    	while(board.checkResult().equals("Not Done")) {
    		
    		//Player1's Turn
    		move = player1.makeMove();
    		if(move[0] == 3 && move[1] == 3)
    		{
    			startGame();
    			return;
    		}
    		while(!board.isEmpty(move[0], move[1])){
    			move = player1.makeMove();
    			if(move[0] == 3 && move[1] == 3)
        		{
    				startGame();
    				return;
        		}
    		}
    		board.movePiece(new PieceX(), move[0], move[1]); 		
    		frame.setPNG(move[0], move[1], "PieceX.png");
    		frame.setMove(-1, -1);
    		if(!board.checkResult().equals("Not Done")) {
    			break;
    		}
    		
    		//Player2's Turn
    		move = player2.makeMove();
    		if(move[0] == 3 && move[1] == 3)
    		{
    			startGame();
    			return;
    		}
    		while(!board.isEmpty(move[0], move[1])){
    			move = player2.makeMove();
    			if(move[0] == 3 && move[1] == 3)
        		{
    				startGame();
    				return;
        		}
    		}
    		board.movePiece(new PieceO(), move[0], move[1]);
    		frame.setPNG(move[0], move[1], "PieceO.png");
    		frame.setMove(-1, -1);
    	}
    	
    	System.out.println(board.checkResult());
    	boolean waiting = true;
    	
    	while(waiting)
    	{
    		System.out.print("");
    		if(frame.getMove()[0] == 3 && frame.getMove()[1] == 3)
    		{
    			waiting = false;
    		}
    	}
    	startGame();
    	/*if(board.checkResult().equals("O"))
    	{
    		frame.setWinner("winO.png");
    	}
    	else if(board.checkResult().equals("X"))
    	{
    		frame.setWinner("winX.png");
    	}*/
    }
    public void setPlayers(String menuName)
    {
    	if(menuName.equals("Player vs. Player"))
    	{
    		clear();
    		player1 = new Human(frame);
    		player2 = new Human(frame);
    	}
    	else if(menuName.equals("Player vs. Computer"))
    	{
    		clear();
    		player1 = new Human(frame);
    		player2 = new Computer(frame, board);
    	}
    	else if(menuName.equals("Computer vs. Player"))
    	{
    		clear();
    		player1 = new Computer(frame, board);
    		player2 = new Human(frame);
    	}
    	else if(menuName.equals("Computer vs. Computer"))
    	{
    		clear();
    		player1 = new Computer(frame, board);
    		player2 = new Computer(frame, board);
    	}
    }
    public void clear()
    {
    	board.clearBoard();
    	frame.clearScreen();
    }
}
