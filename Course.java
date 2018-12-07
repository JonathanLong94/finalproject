/**
 * @author Jonathan Long Date: 11/04/2018 Assignment: Final Project
 */

public class Course {

	// Declaring variables for the course class
	private String crn;
	private String courseTitle;
	private String instructor;
	private String classroom;

	// Creating constructors
	public Course() {
		super();
	}

	public Course(String crn, String courseTitle, String instructor, String classroom) {
		super();
		this.crn = crn;
		this.courseTitle = courseTitle;
		this.instructor = instructor;
		this.classroom = classroom;
	}

	// Getters and setters
	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	// Creating toString method
	@Override
	public String toString() {
		return "\t" + crn + "\t" + courseTitle + "\t" + instructor + "\t" + classroom;
	}

}
