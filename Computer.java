public class Computer implements Player {
	private gameView frame;

    public Computer(gameView frame1) {
    	frame = frame1;

    }
    
    public int[] makeMove()
    {
    	int r = (int)(Math.random()*3);
    	int c = (int)(Math.random()*3);
    	return new int[] {r,c};
    }
}
