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
        //todo get addresses where they have item by items name

    }

    public void getItems(String adress, Statement statement) throws SQLException {
        //todo get items they have on certain address and items' prices
    }
}







