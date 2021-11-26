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
		Console console = System.console();
		System.out.print("Enter your username: ");    // Your Oracle ID with double quote
        String username = console.readLine();         // e.g. "98765432D"
        System.out.print("Enter your password: ");    // Password of your Oracle Account
        char[] password = console.readPassword();
		String pwd = String.valueOf(password);

		// Connection
		DriverManager.registerDriver(new OracleDriver());
		OracleConnection conn = 
			(OracleConnection)DriverManager.getConnection(
			 "jdbc:oracle:thin:@studora.comp.polyu.edu.hk:1521:dbms",username,pwd);

		System.out.print("1 -->> Customer \n" +
				"2 -->> Technician  \n" +
				"3 -->> Manager\n" +
				"-1 -->> Exit\n" +
				"Please enter the number of your position:");
		Scanner pos = new Scanner(System.in);
		int posNum = 0;
		if (pos.hasNextLine()) posNum = Integer.parseInt(pos.nextLine());

		switch (posNum){
			case 1 -> {

			}

			case 2 -> {
				System.out.print("Please enter your Technician id:");
				Scanner id = new Scanner(System.in);
				String idNum = null;
				if (id.hasNextLine()) idNum = pos.nextLine();
				Technician tech = new Technician(idNum, conn);

			}

			case 3 -> {

			}
			case 4 -> {break;}
			default -> throw new IllegalArgumentException("Please enter a legit number.");
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
