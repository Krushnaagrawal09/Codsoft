package studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentManagementSystem {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem", "root",
				"1234");
		Statement st = con.createStatement();
		Scanner scanner = new Scanner(System.in);
        System.out.print("---STUDENT MANAGEMENT SYSTEM---");
		for (;;) {
			System.out.println("\n");
			System.out.println("Enter Choice : ");
			System.out.println(
					"1.Add Student 2.Remove Student 3.Search Student 4.Display All Student 5.Update Student 6.Exit");
			switch (scanner.nextInt()) {
			case 1:
				addStudent();
				break;
			case 2:
				removeStudent();
				break;
			case 3:
				searchStudent();
				break;
			case 4:
				displayAllStudent();
				break;
			case 5:
				updateStudent();
				break;
			case 6:
				System.out.println("Exit done!!");
				System.exit(0);
				break;
			}
		}
	}

	public static void addStudent() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem", "root",
				"1234");
		Scanner scanner = new Scanner(System.in);
		PreparedStatement insertStudent = con
				.prepareStatement("insert into StudentInformation(name,rollNumber,grade,age)values(?,?,?,?)");
		// Add student name
		boolean isValidName = false;
		String addName = "";
		while(isValidName == false) {
			System.out.print("Enter full name : ");
			addName = scanner.nextLine().toUpperCase();
			if (Validations.isValidInput(addName, isValidName)) {
				isValidName = true;
			}
		}
		insertStudent.setString(1, addName);

		// Add roll number
		boolean isValidRollNumber = false;
		int addRollNumber = 0;
		while (isValidRollNumber == false) {
			System.out.print("Enter roll number : ");
			String input = scanner.nextLine();
			if (Validations.integerValidation(input)) {
				addRollNumber = Integer.parseInt(input);
				isValidRollNumber = true;
			} else {
				System.err.println("Invalid input. Please enter a valid integer!!");
			}
		}
		insertStudent.setInt(2, addRollNumber);

//		Add student grade
		boolean isValidGrade = false;
		String addGrade = "";
		while (isValidGrade == false) {
			System.out.print("Enter grade : ");
			String input = scanner.next().toUpperCase();
			if (Validations.characterValidation(input)) {
				char character = input.charAt(0);
				addGrade += character;
				addGrade.toUpperCase();
				isValidGrade = true;
			} else {
				// If input is empty, null, or contains more than one character, print an error
				// message
				System.err.println("Please enter single character for the grade");
			}
		}
		insertStudent.setString(3, addGrade);

//      Add student age
		boolean isValidAge = false;
		int addAge = 0;
		while (isValidAge == false) {
			System.out.print("Enter age : ");
			String ageInput = scanner.next();
			if (Validations.integerValidation(ageInput)) {
				addAge = Integer.parseInt(ageInput);
				isValidAge = true;
			} else {
				System.err.println("Please enter a valid integer for the age!!");
			}
		}
		insertStudent.setInt(4, addAge);

		System.out.println("---STUDENT ADDED---");
		insertStudent.execute();
		insertStudent.close();
	}

//  remove student 
	public static void removeStudent() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem", "root",
				"1234");

		Scanner scanner = new Scanner(System.in);
		PreparedStatement deleteStudent = con.prepareStatement("delete from StudentInformation where name=?");

		boolean isValidName = false;
		String removeStudent = "";
		while (isValidName == false) {
			System.out.print("Enter full name : ");
			removeStudent = scanner.nextLine().toUpperCase();
			if (Validations.isValidInput(removeStudent, isValidName)) {
				isValidName = true;
			}
		}
		deleteStudent.setString(1, removeStudent);
		deleteStudent.execute();
		System.out.println("---STUDENT REMOVED---");
		deleteStudent.close();
	}

	// find student details
	public static void searchStudent() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem", "root",
				"1234");

		Scanner scanner = new Scanner(System.in);
		PreparedStatement fetchStudent = con.prepareStatement("select * from StudentInformation where name=?");

		boolean isValidName = false;
		String searchStudentName = "";
		while (isValidName == false) {
			System.out.print("Enter full name : ");
			searchStudentName = scanner.nextLine().toUpperCase();
			if (Validations.isValidInput(searchStudentName, isValidName)) {
				isValidName = true;
			}
		}
		fetchStudent.setString(1, searchStudentName);

		ResultSet resultset = fetchStudent.executeQuery();
		if (resultset.next()) {
			System.out.println("---STUDENT DETAILS---");
			System.out.println(resultset.getString(1) + " " + resultset.getInt(2) + " " + resultset.getString(3) + " "
					+ resultset.getInt(4));
		} else {
			System.out.println("---STUDENT NOT FOUND---");
		}
	}

	// display all student
	public static void displayAllStudent() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem", "root",
				"1234");

		Scanner scanner = new Scanner(System.in);
		PreparedStatement fetchStudent = con.prepareStatement("select * from StudentInformation");

		ResultSet resultset = fetchStudent.executeQuery();
		System.out.println("---ALL STUDENTS INFORMATION---");
		while (resultset.next()) {
			System.out.println("Name :"+resultset.getString(1) + ". Roll No: " + resultset.getInt(2) + ". Grade: " + resultset.getString(3) + ". Age :"
					+ resultset.getInt(4));
		}
	}

//	update student details
	public static void updateStudent() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem", "root",
				"1234");

		Scanner scanner = new Scanner(System.in);
		PreparedStatement updateStudent = con.prepareStatement("update StudentInformation set name=?,grade=?,age=? where rollnumber=?");

		System.out.print("Enter Student Roll Number to Update Information : ");
		boolean isValidRollNumber = false;
		int rollNumber = 0;
		while (isValidRollNumber == false) {
//			System.out.print("Enter roll number : ");
			String input = scanner.nextLine();
			if (Validations.integerValidation(input)) {
				rollNumber = Integer.parseInt(input);
				isValidRollNumber = true;
			} else {
				System.err.println("Invalid input. Please enter a valid integer!!");
			}
		}
		updateStudent.setInt(4, rollNumber);

		// update student name
		boolean isValidName = false;
		String name = "";
		while (isValidName == false) {
			System.out.print("Enter full name : ");
			name = scanner.nextLine().toUpperCase();
			if (Validations.isValidInput(name, isValidName)) {
				isValidName = true;
			}
		}
		updateStudent.setString(1, name);

		boolean isValidGrade = false;
		String grade = "";
		while (isValidGrade == false) {
			System.out.print("Enter grade : ");
			String input = scanner.next().toUpperCase();
			if (Validations.characterValidation(input)) {
				char character = input.charAt(0);
				grade += character;
				grade.toUpperCase();
				isValidGrade = true;
			} else {
				// If input is empty, null, or contains more than one character, print an error
				// message
				System.err.println("Invalid input. Please enter a single non-empty character.");
			}
		}
		updateStudent.setString(2, grade);

		boolean isValidAge = false;
		int age = 0;
		while (isValidAge == false) {
			System.out.print("Enter age : ");
			String input = scanner.nextLine();
			if (Validations.integerValidation(input)) {
				age = Integer.parseInt(input);
				isValidAge = true;
			} else {
				System.err.println("Invalid input. Please enter a valid integer!!");
			}
		}
		updateStudent.setInt(3, age);

		updateStudent.execute();
		System.out.println("---STUDENT INFORMATION UPDATED---");
		updateStudent.close();
	}

}
