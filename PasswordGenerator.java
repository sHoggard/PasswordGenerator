package passwordGenerator;

import javax.swing.*;
import java.util.Random;
import java.awt.event.*;

public class PasswordGenerator {
	private Random random = new Random();
	private int length = 10;
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JTextField textField = new JTextField(50);
	private JButton button = new JButton("Generate");
	
	PasswordGenerator() {
		this(10);
	}
	
	PasswordGenerator(int length) {
		this.length = length;
		generate();
	}
	
	private void generate() {
		String output = "";
		char one = 0;
		for (int index = 0; index < length; index++) {
			one = (char)random.nextInt(73);
			one += 35;
			if (one > 38) {
				one += 3;
				if (one > 43) {
					one += 4;
					if (one > 57) {
						one += 2;
						if (one > 90) {
							one += 6;
						}
					}
				}
			}
			output += one;
		}
		System.out.println("New password: " + output);
	}
	
	// GUI not yet implemented, use console for now
	private class Happener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}

	public static void main(String[] args) {
		int[] options = new int[args.length];
		if (args.length > 0) {
			options[0] = Integer.parseInt(args[0]);
			new PasswordGenerator(options[0]);
		}
		else {
			new PasswordGenerator();
		}
	}

}
