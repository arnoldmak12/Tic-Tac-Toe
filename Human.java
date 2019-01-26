import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Human extends Player {

    public Human() {
    	
    }

    public Square makeMove() {
    	return new Square();
    }
    
    private class MyMouseAdapter extends MouseAdapter {
    	
        @Override
        public void mousePressed(MouseEvent e) {
        	
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        	
        }

        public void updateLocation(MouseEvent e) {
        	
           
        }
    }
}
