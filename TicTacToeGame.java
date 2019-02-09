import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicTacToeGame {

    public TicTacToeGame() {
        
    }

    private Player annouceWinner() {
        return new Player();
    }

    public static void main(String[] args) {
    	Board board = new Board();
        Player player1 = new Human();
        Player player2 = new Computer();
    	Map<Player, List<int[]>> moveHistory = new HashMap<Player, List<int[]>>();
    	Piece o = new PieceO();
    	int[] move = new int[2];
    	
    	while(board.checkResult().equals("Not Done")) {
    		
    		//Player1's Turn
    		move = player1.makeMove();		
    		while(!board.isEmpty(move[0], move[1])){
    			move = player1.makeMove();
    		}
    		board.movePiece(new PieceX(), move[0], move[1]); 		
    		board.showBoard();
    		
    		if(!board.checkResult().equals("Not Done")) {
    			break;
    		}
    		
    		//Player2's Turn
    		move = player2.makeMove();		
    		while(!board.isEmpty(move[0], move[1])){
    			move = player2.makeMove();
    		}
    		board.movePiece(new PieceO(), move[0], move[1]);    		
    		board.showBoard();   		
    	}
    	
    	System.out.println(board.checkResult());
    }
}
