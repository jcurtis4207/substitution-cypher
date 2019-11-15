import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EncodePanel extends JPanel{
	private JTextField keyField, inputField;
	private JButton randomButton, encodeButton, userKeyButton;
	private JLabel keyLabel, output, keyInstructions, inputInstructions;
	
	private boolean randomEntered, userEntered;
	private String encryptedOutput;
	private RandomCipher randomCipherObject;
	private Cipher cipherObject;
	
	private Font font1 = new Font("Helvetica",Font.PLAIN, 15);
	private Font font2 = new Font("Helvetica",Font.BOLD,18);
	
	//Constructor
	public EncodePanel() {
		//Initializing components and listeners
		keyField = new JTextField(30);
		inputField = new JTextField(100);
		inputField.setMaximumSize(new Dimension(1100,30));
		
		Listener bList = new Listener();
		randomButton = new JButton("Generate Random Key");
		encodeButton = new JButton("Encrypt Text");
		userKeyButton = new JButton("Use Entered Key");
		randomButton.addActionListener(bList);
		encodeButton.addActionListener(bList);
		userKeyButton.addActionListener(bList);
		keyField.addActionListener(bList);
		
		keyInstructions = new JLabel("Enter substitution cipher here or click to generate one randomly");
		keyInstructions.setFont(font2);
		keyLabel = new JLabel("---Key will appear here---");
		keyLabel.setFont(font1);
		inputInstructions = new JLabel("Enter message to be encrypted here:");
		inputInstructions.setFont(font2);
		output = new JLabel("---Encrypted message will appear here---");
		output.setFont(font1);
		
		//Defining layout and adding components
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		add(keyInstructions,c);
		c.insets = new Insets (20,0,0,0);
		c.gridy = 1;
		add(keyField,c);
		c.gridy = 2;
		add(userKeyButton,c);
		c.gridy = 3;
		add(randomButton,c);
		c.gridy = 4;
		add(keyLabel,c);
		c.gridy = 5;
		add(inputInstructions,c);
		c.gridy = 6;
		add(inputField,c);
		c.gridy = 7;
		add(encodeButton,c);
		c.gridy = 8;
		add(output,c);
		
		setPreferredSize(new Dimension(1200,400));
		setBackground(Color.LIGHT_GRAY);
	}
	
	//Listener for buttons and text fields
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			//Random Button Pressed - Creates a randomly generated cipher
			if(event.getSource() == randomButton) {
				randomCipherObject = new RandomCipher();
				keyLabel.setText("Key: "+ randomCipherObject.getKey());
				randomEntered = true;
				userEntered = false;
			}
			//User Key Button Pressed - Creates a user defined cipher and verifies its length
			if(event.getSource() == keyField || event.getSource() == userKeyButton) {
				cipherObject = new Cipher(keyField.getText());
				if(cipherObject.getKey().length() == 26) {
					keyLabel.setText("Key: "+ keyField.getText());
					userEntered = true;
					randomEntered = false;
				}else
					keyLabel.setText("***Enter a complete cipher to prevent errors***");
			}
			//Encode Button Pressed - Encrypts the message using the last defined cipher
			if(event.getSource() == encodeButton) {
				String message = inputField.getText();
				if(randomEntered == true) {
					encryptedOutput = randomCipherObject.encrypt(message,randomCipherObject.getKey());
					output.setText("Encrypted Message: " + encryptedOutput);
				} else if(userEntered == true) {
					encryptedOutput = cipherObject.encrypt(message, cipherObject.getKey());
					output.setText("Encrypted Message: " + encryptedOutput);
				} else
					output.setText("***No Key Entered***");
			}
		}
	}
}
