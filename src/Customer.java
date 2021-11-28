import java.util.*;
import java.io.*;
import java.io.Console;
import java.sql.*;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.*;
import oracle.sql.*;

public class Customer {
    public Customer(OracleConnection Conn) throws SQLException {
        Statement statement = Conn.createStatement();}


    public void getMachine(String name, Statement statement) throws SQLException {
        try {
            ResultSet rset = statement.executeQuery("SELECT Adress FROM VendingMachine WHERE Item_Name = " + name);
            //change
            while (rset.next()) {

            }
            //which one should we choose
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getItems(String adress, Statement statement) throws SQLException {

    }
}


    /*
    * get addresses where they have item, not id, NAME OF ITEMS
    * get items they have on certain address and items' prices
    * */




