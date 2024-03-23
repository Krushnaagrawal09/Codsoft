package studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem","root","1234");
		Statement st = con.createStatement();
		
		st.execute("create table StudentInformation(Name varchar(20), RollNumber int, Grade varchar(20), Age int)");	
		System.out.println("Student Table Created!!");
		st.close();
	}
	
}
