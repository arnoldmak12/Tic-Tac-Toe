import java.util.HashMap;
import java.util.Map;

public class TicTacToeGame {

    private Board board;

    private Player player1;
    private Player player2;

    private Map moveHistory;

    public TicTacToeGame() {
        this.board = new Board();
        this.player1 = new Human();
        this.player2 = new Computer();
        this.moveHistory = new HashMap();
    }

    private static void startGame() {

    }

    private static Player annouceWinner() {
        return new Player();
    }

    public static void main(String[] args) {

    }
}
