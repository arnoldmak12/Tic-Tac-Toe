import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicTacToeGame {
	private Board board;
	private Map<Player, ArrayList<int[]>> moveHistory;
	private gameView frame;
	private Player player1;
	private Player player2;
	private ArrayList<int[]> list1;
	private ArrayList<int[]> list2;
	

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
    public void startGame() {
    	int[] move = new int[2];
		frame.setMove(-1,  -1);
    	
    	while(board.checkResult().equals("Not Done")) {
    		
    		//Player1's Turn
    		frame.setLabel("Player 1's Turn");
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
    		list1.add(new int[] {move[0], move[1]});
    		moveHistory.replace(player1, list1);
    		frame.setMove(-1, -1);
    		if(!board.checkResult().equals("Not Done")) {
    			break;
    		}
    		
    		//Player2's Turn
    		frame.setLabel("Player 2's Turn");
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
    		list2.add(new int[] {move[0], move[1]});
    		moveHistory.replace(player2, list2);
    		frame.setMove(-1, -1);
    	}
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
    	System.out.println("\n\nPlayer 1 Move History:\tPlayer 2 Move History:");
    	for(int i = 0; i < moveHistory.get(player1).size(); i++)
    	{
    		System.out.print("\t" + moveHistory.get(player1).get(i)[0] + "," + moveHistory.get(player1).get(i)[1]);
    		if(i < moveHistory.get(player2).size()) {
    			System.out.println("\t\t\t" + moveHistory.get(player2).get(i)[0] + "," + moveHistory.get(player2).get(i)[1]);
    		}
    	}
    	System.out.println("\n\n" + board.checkResult() + "\n");
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
    }
    public void setPlayers(String menuName)
    {
    	if(menuName.equals("Player vs. Player"))
    	{
    		clear();
    		player1 = new Human(frame);
    		player2 = new Human(frame);
    		moveHistory.clear();
    		list1.clear();
        	list2.clear();
    		moveHistory.put(player1, list1);
        	moveHistory.put(player2, list2);
    	}
    	else if(menuName.equals("Player vs. Computer"))
    	{
    		clear();
    		player1 = new Human(frame);
    		player2 = new Computer(frame, board);
    		moveHistory.clear();
    		list1.clear();
        	list2.clear();
    		moveHistory.put(player1, list1);
        	moveHistory.put(player2, list2);
    	}
    	else if(menuName.equals("Computer vs. Player"))
    	{
    		clear();
    		player1 = new Computer(frame, board);
    		player2 = new Human(frame);
    		moveHistory.clear();
    		list1.clear();
        	list2.clear();
    		moveHistory.put(player1, list1);
        	moveHistory.put(player2, list2);
    	}
    	else if(menuName.equals("Computer vs. Computer"))
    	{
    		clear();
    		player1 = new Computer(frame, board);
    		player2 = new Computer(frame, board);
    		moveHistory.clear();
    		list1.clear();
        	list2.clear();
    		moveHistory.put(player1, list1);
        	moveHistory.put(player2, list2);
    	}
    }
    public void clear()
    {
    	board.clearBoard();
    	frame.clearScreen();
    }
}
