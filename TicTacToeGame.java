import java.util.HashMap;
import java.util.Map;

public class TicTacToeGame {

    private Board board;

    private Player player1;
    private Player player2;

    private Map moveHistory;

    public TicTacToeGame() {
        board = new Board();
        player1 = new Human();
        player2 = new Computer();
        moveHistory = new HashMap();
    }

    private Player annouceWinner() {
        return new Player();
    }

    public static void main(String[] args) {

    }
}

