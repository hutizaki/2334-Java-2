package guistuff;

import java.awt.*;

public class Guimanagers {
	
	public static void main(String[] args) {
		// Create the main frame (window)
	    JFrame frame = new JFrame("Three Buttons");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(300, 150);
	    frame.setLayout(new FlowLayout()); // simple layout for side-by-side buttons

	    // Create and add three buttons
	    for (int i = 0; i < 3; i++) {
	    	JButton button = new JButton("Click Me");
	        frame.add(button);
	    }

	    // Make the window visible
	    frame.setVisible(true);
	}
	

}
