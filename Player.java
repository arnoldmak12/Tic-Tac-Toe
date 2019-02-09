import java.util.Scanner;

public class Player {

    private String name;

    public Player() {

    }

    public int[] makeMove() {
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("r?");
    	int r = sc.nextInt();
    	
    	System.out.println("c?");
    	int c = sc.nextInt();
    	
        return new int[] {r,c};
    }
}
