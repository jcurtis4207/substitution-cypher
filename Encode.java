import javax.swing.JFrame;

public class Encode {
	//Creates the window for encrypting a message
	public static void main(String[] args) {
		JFrame frame = new JFrame("Encode");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new EncodePanel());
		frame.pack();
		frame.setVisible(true);
	}
}
