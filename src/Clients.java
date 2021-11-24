import java.util.*;
import java.io.*;
import java.io.Console;
import java.sql.*;
import oracle.jdbc.driver.*;
import oracle.sql.*;

public class Clients
{
	public static void main(String args[]) throws SQLException, IOException
	{
		/*Console console = System.console();
		System.out.print("Enter your username: ");    // Your Oracle ID with double quote
        String username = console.readLine();         // e.g. "98765432D"
        System.out.print("Enter your password: ");    // Password of your Oracle Account
        char[] password = console.readPassword();
		String pwd = String.valueOf(password);

		// Connection
		DriverManager.registerDriver(new OracleDriver());
		OracleConnection conn = 
			(OracleConnection)DriverManager.getConnection(
			 "jdbc:oracle:thin:@studora.comp.polyu.edu.hk:1521:dbms",username,pwd);*/

		System.out.print("1 -->> Customer \n" +
				"2 -->> Technician  \n" +
				"3 -->> Manager\n" +
				"Please enter the number of your identification:");
		Scanner id = new Scanner(System.in);
		int idNum = 0;
		if (id.hasNextLine()) idNum = Integer.parseInt(id.nextLine());

		switch (idNum){
			case 1 -> {

			}

			case 2 -> {
				System.out.print("Please enter your name:");
				Scanner name = new Scanner(System.in);
			}

			case 3 -> {

			}

			default -> throw new IllegalArgumentException();
		}


		/*Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery("SELECT EMPNO, ENAME, JOB FROM EMP");
		while (rset.next())
		{
			System.out.println(rset.getInt(1) 
			+ " " + rset.getString(2) 
			+ " " + rset.getString(3));
		}
		System.out.println();
		conn.close();*/
	}
}
