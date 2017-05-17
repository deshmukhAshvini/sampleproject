package demo.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StartingTransactioncontext {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "Ashvini", "raj");
			System.out.println("connection obtained");

			

			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			stmt.execute("INSERT INTO AUTHOR VALUES (103123,'rachel','mcginn')");
			stmt.execute("INSERT INTO BOOK VALUES ('1031323337','her american dolls-new','30-AUG-12','paperback',7.95)");
			stmt.execute("INSERT INTO BOOKS_BY_AUTHOR VALUES (103123,'1031323338')");
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
