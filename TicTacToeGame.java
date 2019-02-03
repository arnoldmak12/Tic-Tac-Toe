import java.util.HashMap;
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
    	Map moveHistory = new HashMap();
    	Piece o = new PieceO();
    	board.movePiece(o, 1, 1);
    }
}
