
/**
 * @author Jonathan Long Date: 11/04/2018 Assignment: Final Project
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentGUI extends JFrame {

	// Creating the text area, labels and textfields for the GUI
	JTextArea studentTextArea = new JTextArea();

	JLabel idLabel = new JLabel("ID: ");
	JTextField idTextField = new JTextField(10);

	JLabel nameLabel = new JLabel("Name: ");
	JTextField nameTextField = new JTextField(10);

	JLabel creditLabel = new JLabel("Credit Hours Completed: ");
	JTextField creditTextField = new JTextField(10);

	JLabel majorLabel = new JLabel("Major: ");
	JTextField majorTextField = new JTextField(10);

	JLabel crnLabel = new JLabel("CRN: ");
	JTextField crnTextField = new JTextField(10);

	JLabel courseLabel = new JLabel("Course: ");
	JTextField courseTextField = new JTextField(10);

	JLabel instructorLabel = new JLabel("Instructor: ");
	JTextField instructorTextField = new JTextField(10);

	JLabel classroomLabel = new JLabel("Classroom: ");
	JTextField classRoomTextField = new JTextField(10);

	// Creating the buttons
	JButton addButton = new JButton("Add Student");
	JButton deleteButton = new JButton("Delete Student");
	JButton displayAllButton = new JButton("Display All");
	JButton sortButton = new JButton("Sort");
	JButton exitButton = new JButton("Exit");

	// Creating the linked list for the student
	List<Student> studentLinkedList = new LinkedList<Student>();

	public StudentGUI() {
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));

		JPanel gridPanel = new JPanel(new GridLayout(2, 1));
		JPanel gridPanel2 = new JPanel(new GridLayout(2, 1));

		studentTextArea.setEditable(false);

		// Adding buttons, labels and text fields to the window
		panel1.add(idLabel);
		panel1.add(idTextField);
		panel1.add(nameLabel);
		panel1.add(nameTextField);
		panel1.add(creditLabel);
		panel1.add(creditTextField);
		panel1.add(majorLabel);
		panel1.add(majorTextField);

		panel2.add(crnLabel);
		panel2.add(crnTextField);
		panel2.add(courseLabel);
		panel2.add(courseTextField);
		panel2.add(instructorLabel);
		panel2.add(instructorTextField);
		panel2.add(classroomLabel);
		panel2.add(classRoomTextField);

		panel3.add(addButton);
		panel3.add(deleteButton);
		panel3.add(displayAllButton);
		panel3.add(sortButton);
		panel3.add(exitButton);

		gridPanel.add(panel1);
		gridPanel.add(panel2);
		gridPanel2.add(panel3);

		add(gridPanel, BorderLayout.NORTH);
		add(studentTextArea, BorderLayout.CENTER);
		add(gridPanel2, BorderLayout.SOUTH);

		// Making the buttons functional
		addButton.addActionListener(event -> addStudent());
		displayAllButton.addActionListener(event -> displayAll());
		deleteButton.addActionListener(event -> deleteStudent());
		sortButton.addActionListener(event -> sortStudents());
		exitButton.addActionListener(event -> exitOut());

	}

	// To check if the student ID exists in the linked list
	private boolean isIDInLinkedList(String str) {
		boolean isIDdifferent = true;

		// If the student ID matches, regardless of upper and lower case
		for (Student std : studentLinkedList) {
			if (std.getId().compareToIgnoreCase(str) == 0) {
				isIDdifferent = false;
			}
		}
		return isIDdifferent;
	}

	private void addStudent() {

		// Show error message if the ID is in the database
		if (isIDInLinkedList(idTextField.getText()) == false) {
			JOptionPane.showMessageDialog(null,
					"The student ID " + idTextField.getText() + " is already in the database! Try again");

		} else {
			// Adding all information from textfields and displaying message to user that
			// the student has been added
			studentLinkedList.add(new Student(idTextField.getText(), nameTextField.getText(), creditTextField.getText(),
					majorTextField.getText() + new Course(crnTextField.getText(), courseTextField.getText(),
							instructorTextField.getText(), classRoomTextField.getText())));
			JOptionPane.showMessageDialog(null, "Student " + idTextField.getText()
					+ " has been added to the database! Please press the display button to update the list!");
			JOptionPane.showMessageDialog(null, "Important: Please sort the list before displaying it!");

			// Reseting all the text fields to blank after adding students
			idTextField.setText("");
			nameTextField.setText("");
			creditTextField.setText("");
			majorTextField.setText("");
			crnTextField.setText("");
			courseTextField.setText("");
			instructorTextField.setText("");
			classRoomTextField.setText("");

		}
	}

	private void deleteStudent() {
		// If the student ID cannot be found to be deleted
		if (isIDInLinkedList(idTextField.getText()) == true) {
			JOptionPane.showMessageDialog(null,
					"The student ID " + idTextField.getText() + " is not in the database! Cannot be deleted!");
		} else {
			// Retrieve the current ID and compare to the ID in the text fields
			for (int i = 0; i < studentLinkedList.size(); i++) {
				String currentID = studentLinkedList.get(i).getId();

				if (currentID.compareToIgnoreCase(idTextField.getText()) == 0) {
					studentLinkedList.remove(i);
				}
			}
			// Displaying message to user that the student has been deleted 
			JOptionPane.showMessageDialog(null, "Student " + idTextField.getText()
					+ " has been deleted! Please press the display button for updated list");

			// Reseting all textfields to blank after deleting a student
			idTextField.setText("");
			nameTextField.setText("");
			creditTextField.setText("");
			majorTextField.setText("");
			crnTextField.setText("");
			courseTextField.setText("");
			instructorTextField.setText("");
			classRoomTextField.setText("");
		}
	}

	private void displayAll() {
		studentTextArea.setText("");
		for (Student std : studentLinkedList) {
			studentTextArea.append(std + "\n");
		}
	}
	public void sortStudents() {
		studentLinkedList.sort(Comparator.comparing(Student::getId)); // Sorting the students by ID
	}
	
	private void exitOut() {
		System.exit(0); // Close the student enrollment application
	}

} // end class 
