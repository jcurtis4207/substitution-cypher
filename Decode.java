package extraCredit1302;

import javax.swing.JFrame;

public class Decode {
	//Creates the window for decoding a message
	public static void main(String[] args) {
		JFrame frame = new JFrame("Decode");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new DecodePanel());
		frame.pack();
		frame.setVisible(true);
	}
}
