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
	int bodyparts = 6;
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
		
		// Draws the grid
		for (int i = 0; i<SCREEN_HEIGHT/UNIT_SIZE; i++) {
			
			g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
			g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
			
		}
		
		// Drawing the apple
		g.setColor(Color.red);
		g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
		
	}
	
	// Spawning the apple on a random coordinate
	public void newApple() {
		
		appleX = random.nextInt((int)SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
		appleY = random.nextInt((int)SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
		
	}
	
	public void move() {
		
	}
	
	public void checkApple() {
		
	}
	
	public void checkCollisions() {
		
	}
	
	public void gameOver(Graphics g) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public class MyKeyAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			
		}
		
	}

}
