/**
 * @author Jonathan Long Date: 11/04/2018 Assignment: Final Project
 */

public class Student {

	// Declaring variables for student class
	private String id;
	private String name;
	private String creditHoursCompleted;
	private String major;

	// Creating constructors
	public Student() {
		super();
	}

	public Student(String id, String name, String creditHoursCompleted, String major) {
		this.id = id;
		this.name = name;
		this.creditHoursCompleted = creditHoursCompleted;
		this.major = major;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreditHoursCompleted() {
		return creditHoursCompleted;
	}

	public void setCreditHoursCompleted(String creditHoursCompleted) {
		this.creditHoursCompleted = creditHoursCompleted;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	// Creating toString method
	@Override
	public String toString() {
		return id + "\t" + name + "\t" + creditHoursCompleted + "\t" + major;
	}

}
