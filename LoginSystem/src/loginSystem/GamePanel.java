package loginSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener {

	// Declaring everything we need for the program
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	static final int DELAY = 75;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 6;
	int applesEaten;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
	Timer timer;
	Random random;
	
	// Default constructor
	GamePanel() {
		
		// Instance of the Random class
		random = new Random();
		
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
		
	}
	
	// Starting everything needed at the beginning of the game
	public void startGame() {
		
		newApple();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
		
	}
	
	// Displaying all of the graphics
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		draw(g);
		
	}
	
	public void draw(Graphics g) {
		
		if (running) {
		
			// Draws the grid
			/*for (int i = 0; i<SCREEN_HEIGHT/UNIT_SIZE; i++) {
				
				g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
				g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
				
			}*/
			
			// Drawing the apple
			g.setColor(Color.red);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
			
			// Drawing the snake
			for (int i = 0; i < bodyParts; i++) {
				
				if (i == 0) {
					g.setColor(Color.green);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
				else {
					g.setColor(new Color(45, 180, 0));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
				
			}
			
			// Score text
			g.setColor(Color.red);
			g.setFont(new Font("Ink Free", Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
		
		}
		else {
			gameOver(g);
		}
		
	}
	
	// Spawning the apple on a random coordinate
	public void newApple() {
		
		appleX = random.nextInt((int)SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
		appleY = random.nextInt((int)SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
		
	}
	
	public void move() {
		
		// Iterating through all of the body parts
		for (int i = bodyParts; i > 0; i--) {
			
			 x[i] = x[i-1];
			 y[i] = y[i-1];
			
		}
		
		// Changing the direction where the snake is headed
		switch (direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
		
	}
	
	public void checkApple() {
		
		// Checking if the snake eats the apple
		if ((x[0] == appleX) && (y[0] == appleY)) {
			
			bodyParts++;
			applesEaten++; // The score
			newApple();
			
		}
		
	}
	
	public void checkCollisions() {
		
		// Checking to see if the snake's head collides with it's body
		for (int i = bodyParts; i > 0; i--) {
			
			if((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
			
		}
		
		// Checking if the snake's head touches left border
		if (x[0] < 0) {
			running = false;
		}
		
		// Checking if the snake's head touches right border
		if (x[0] > SCREEN_WIDTH) {
			running = false;
		}
		
		// Checking if the snake's head touches top border
		if (y[0] < 0) {
			running = false;
		}
		
		// Checking if the snake's head touches bottom border
		if (y[0] > SCREEN_HEIGHT) {
			running = false;
		}
		
		if(!running) {
			timer.stop();
		}
		
	}
	
	public void gameOver(Graphics g) {
		
		// Score text
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
		
		// Game over text
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Calling the methods when the game is running
		if (running) {
			move();
			checkApple();
			checkCollisions();
			
		}
		repaint();
		
	}
	
	public class MyKeyAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			// Adding player controls
			switch (e.getKeyCode()) {
			case KeyEvent.VK_A:
				if (direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_D:
				if (direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_W:
				if (direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_S:
				if (direction != 'U') {
					direction = 'D';
				}
				break;
			}
			
		}
		
	}

}
