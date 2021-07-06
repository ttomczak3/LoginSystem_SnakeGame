package loginSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {

	// The login page
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel();
	
	// Making a copy of our login info globally available to all methods
	HashMap<String, String> logininfo = new HashMap<String, String>();
	
	// Default constructor
	LoginPage(HashMap<String, String> loginInfoOriginal) {
		
		logininfo = loginInfoOriginal;
		
		// Adding components
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		
		messageLabel.setBounds(125, 250, 250, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		
		// The design of the JFrame
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Reseting the login fields when the reset button is clicked
		if (e.getSource() == resetButton) {
			
			userIDField.setText("");
			userPasswordField.setText("");
			
		}
		
		// Logging in the user when the login button is clicked
		if (e.getSource() == loginButton) {
			
			String userID = userIDField.getText();
			String userPassword = String.valueOf(userPasswordField.getPassword());
			
			if (logininfo.containsKey(userID)) {
				if (logininfo.get(userID).equals(userPassword)) {
					
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login Successful!");
					frame.dispose();
					
					// Instance of our GameFrame page
					new GameFrame();
					
					// Instance of our welcome page
					//WelcomePage welcomePage = new WelcomePage(userID);
					
				}	
				else {
					
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong Password");
					
				}
			}
			else {
				
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username Not Found");
				
			}
			
		}
		
	}
	
}
