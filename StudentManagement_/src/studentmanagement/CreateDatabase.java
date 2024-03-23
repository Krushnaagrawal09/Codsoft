package studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentManagementSystem","root","1234");
        Statement st = con.createStatement();
//        st.execute("create database StudentManagementSystem");
        System.out.println("Database Created!!");
//        st.close();
	}

}
