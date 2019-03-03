import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicTacToeGame {

    public TicTacToeGame() {
        
    }

    /*private Player annouceWinner() {
        return new Player();
    }*/

    public static void main(String[] args) {
    	Board board = new Board();
        Map<Player, List<int[]>> moveHistory = new HashMap<Player, List<int[]>>();
    	Piece o = new PieceO();
    	int[] move = new int[2];
    	gameView frame = new gameView();
    	Player player1 = new Human(frame);
    	Player player2 = new Human(frame);
		frame.setVisible(true);
		frame.setMove(-1,  -1);
    	
    	while(board.checkResult().equals("Not Done")) {
    		
    		//Player1's Turn
    		move = player1.makeMove();		
    		while(!board.isEmpty(move[0], move[1])){
    			move = player1.makeMove();
    		}
    		board.movePiece(new PieceX(), move[0], move[1]); 		
    		frame.setPNG(move[0], move[1], "PieceX.png");
    		frame.setMove(-1, -1);
    		if(!board.checkResult().equals("Not Done")) {
    			break;
    		}
    		
    		//Player2's Turn
    		move = player2.makeMove();		
    		while(!board.isEmpty(move[0], move[1])){
    			move = player2.makeMove();
    		}
    		board.movePiece(new PieceO(), move[0], move[1]);    		
    		frame.setPNG(move[0], move[1], "PieceO.png");
    		frame.setMove(-1, -1);
    	}
    	
    	System.out.println(board.checkResult());
    	if(board.checkResult().equals("O"))
    	{
    		frame.setWinner("winO.png");
    	}
    	else if(board.checkResult().equals("X"))
    	{
    		frame.setWinner("winX.png");
    	}
    }
}
