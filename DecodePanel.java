import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DecodePanel extends JPanel{
	private JTextField keyField, inputField;
	private JButton decodeButton;
	private JLabel keyInstructions, inputInstructions, decodedOutput;
	
	private Font font1 = new Font("Helvetica",Font.PLAIN, 15);
	private Font font2 = new Font("Helvetica",Font.BOLD,18);
	
	//Constructor
	public DecodePanel() {
		//Initializing components and listeners
		keyField = new JTextField(30);
		inputField = new JTextField(100);
		inputField.setMaximumSize(new Dimension(1100,30));
			
		decodeButton = new JButton("Decode");
		decodeButton.addActionListener(new ButtonListener());
		
		keyInstructions = new JLabel("Enter cipher key here:");
		keyInstructions.setFont(font2);
		inputInstructions = new JLabel("Enter encrypted message here:");
		inputInstructions.setFont(font2);
		decodedOutput = new JLabel("---Decrypted message will appear here---");
		decodedOutput.setFont(font1);
		
		//Defining layout and adding components
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		add(keyInstructions,c);
		c.insets = new Insets (20,0,0,0);
		c.gridy = 1;
		add(keyField,c);
		c.gridy = 2;
		add(inputInstructions,c);
		c.gridy = 3;
		add(inputField,c);
		c.gridy = 4;
		add(decodeButton,c);
		c.gridy = 5;
		add(decodedOutput,c);
		
			
		setPreferredSize(new Dimension(1200,250));
		setBackground(Color.LIGHT_GRAY);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String substitutionKey = keyField.getText();
			String userInput = inputField.getText();
			//if 'substitutionKey' length is correct, create a user generated Cipher and decode 'userInput'
			if(substitutionKey.length() == 26) {
				Cipher c1 = new Cipher(substitutionKey);
				String out = c1.decrypt(userInput,substitutionKey);
				decodedOutput.setText("Decrypted Message: "+out);
			} else
				decodedOutput.setText("***Enter a complete cipher to prevent errors***");
		}
	}
}
