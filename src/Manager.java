import java.util.*;
import java.io.*;
import java.io.Console;
import java.sql.*;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.*;
import oracle.sql.*;
public class Manager {



    public  Manager (OracleConnection Conn) throws SQLException {
        Statement stmt = Conn.createStatement();
        boolean run = true;
        while (run) {
            System.out.print("1 -->> Check out vending machines \n" +
                    "2 -->> Check out Purchase information \n"+
                    "3 -->> Check out warehouses\n" +
                    "4 -->> Check out Jobs\n" +
                    "5 -->> Check out Technicians\n" +
                    "-1 -->> Exit\n" +
                    "Please choose an option to execute:");
            Scanner operation = new Scanner(System.in);
            int operationNum;
            if (operation.hasNextLine()) {
                operationNum = Integer.parseInt(operation.nextLine());
                try {
                    switch (operationNum) {
                        case 1 -> {
                            System.out.print("If you want to check on a certain machine, please enter its ID number, " +
                                    "else enter 1 to check all.");
                            Scanner machine = new Scanner(System.in);
                            if (machine.nextLine().equals("1")) this.checkVMachine(stmt);
                            else this.checkVMachine(machine.nextLine(), stmt);
                        }

                        case 2 -> {
                            System.out.print("If you want to check purchase records on a certain machine, " +
                                "please enter its ID number, else enter 1 to check all.");
                            Scanner purchase = new Scanner(System.in);
                            if (purchase.nextLine().equals("1")) this.checkPurchase(stmt);
                            else this.checkPurchase(purchase.nextLine(), stmt);
                        }

                        case 3 -> {
                            System.out.print("If you want to check on a certain warehouse, please enter its ID number, " +
                                    "else enter 1 to check all.");
                            Scanner warehouse = new Scanner(System.in);
                            if (warehouse.nextLine().equals("1")) this.checkWhouse(stmt);
                            else this.checkWhouse(warehouse.nextLine(), stmt);
                        }

                        case 4 -> {
                            this.checkJobs(stmt);
                        }

                        case 5 -> {
                            this.checkTechnician(stmt);
                        }

                        case -1 -> {
                            run = false;
                        }

                        default -> throw new IllegalArgumentException("Please enter a legit number.");
                    }
                } catch (IllegalArgumentException e){System.out.println(e.getMessage());}
            }
        }
    }

    public void checkVMachine (Statement statement)  {
        try {
            ResultSet rset = statement.executeQuery("SELECT * FROM" );
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }

    public void checkVMachine (String machineNum, Statement statement)  {
        try {
            ResultSet rset = statement.executeQuery("SELECT * FROM ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }


    }

    public void checkPurchase (Statement statement){
        try {
            ResultSet rset = statement.executeQuery("SELECT * FROM ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }

    public void checkPurchase (String machineNum, Statement statement){
        try {
            ResultSet rset = statement.executeQuery("SELECT * FROM ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void checkWhouse (Statement statement){
        //join warehouse table and warehouse stock table
        try {
            ResultSet rset = statement.executeQuery("SELECT * FROM ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void checkWhouse (String machineNum, Statement statement){
        //join warehouse table and warehouse stock table
        try {
            ResultSet rset = statement.executeQuery("SELECT * FROM ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void checkJobs (Statement statement){
        try {
            ResultSet rset = statement.executeQuery("SELECT * FROM ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }

    public void checkTechnician (Statement statement){
        try {
            ResultSet rset = statement.executeQuery("SELECT * FROM ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }



}
