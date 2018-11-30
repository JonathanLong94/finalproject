/**
 * @author Jonathan Long Date: 11/04/2018 Assignment: Final Project
 */

import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {
		StudentGUI app = new StudentGUI();
		app.setVisible(true);
		app.setSize(800, 500);
		app.setLocation(200, 100);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
