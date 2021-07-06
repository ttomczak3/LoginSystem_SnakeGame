package loginSystem;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame{

	// Default constructor
	GameFrame() {
		
		this.add(new GamePanel());
		this.setTitle("SnakeGame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	
}
