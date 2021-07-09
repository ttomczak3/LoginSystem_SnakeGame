package loginSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements ActionListener{

	JButton resetButton = new JButton("Restart");
	
	// Default constructor
	GameFrame() {
		
		this.add(new GamePanel());
		this.setTitle("SnakeGame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		// Restart button
		resetButton.setBounds(250, 400, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		this.add(resetButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Restarting the game when the reset button is clicked
		if (e.getSource() == resetButton) {
			
			this.dispose();
			GameFrame gameFrame = new GameFrame();
			
		}
		
	}
	
}
