import java.util.*;
import java.io.*;
import java.io.Console;
import java.sql.*;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.*;
import oracle.sql.*;
public class Administrator {

    public Statement stmt;

    public Administrator(OracleConnection Conn) throws SQLException {
        stmt = Conn.createStatement();
        boolean run = true;
        while (run) {
            System.out.print("1 -->> Get information about the vending machine system \n" +
                    "2 -->> Updates information of the vending machine system\n"+
                    "-1 -->> Exit\n" +
                    "Please choose an option to execute:");
            Scanner operation_0 = new Scanner(System.in);
            int operationNum_0;
            if (operation_0.hasNextLine()) {
                operationNum_0 = Integer.parseInt(operation_0.nextLine());
                switch (operationNum_0){
                    case 1 -> this.queries();

                    case 2 -> this.updates();

                    case -1 -> run = false;
                }
            }
        }
    }



    public void updates (){}

    public void queries () {
        System.out.print("1 -->> Check out vending machines \n" +
                "2 -->> Check out Purchase information \n"+
                "3 -->> Check out warehouses\n" +
                "4 -->> Check out Jobs\n" +
                "5 -->> Check out Technicians\n" +
                "Please choose an option to execute:");
        Scanner operation_1 = new Scanner(System.in);
        int operationNum_1;
        if (operation_1.hasNextLine()) {
            operationNum_1 = Integer.parseInt(operation_1.nextLine());
            try {
                switch (operationNum_1) {
                    case 1 -> {
                        System.out.print("If you want to check on a certain machine, please enter its ID number, " +
                                "else enter 1 to check all.");
                        Scanner machine = new Scanner(System.in);
                        if (machine.nextLine().equals("1")) this.checkVMachine();
                        else this.checkVMachine(machine.nextLine());
                    }

                    case 2 -> {
                        System.out.print("If you want to check purchase records on a certain machine, " +
                                "please enter its ID number, else enter 1 to check all.");
                        Scanner purchase = new Scanner(System.in);
                        if (purchase.nextLine().equals("1")) this.checkPurchase();
                        else this.checkPurchase(purchase.nextLine());
                    }

                    case 3 -> {
                        System.out.print("If you want to check on a certain warehouse, please enter its ID number, " +
                                "else enter 1 to check all.");
                        Scanner warehouse = new Scanner(System.in);
                        if (warehouse.nextLine().equals("1")) this.checkWhouse();
                        else this.checkWhouse(warehouse.nextLine());
                    }

                    case 4 -> {
                        this.checkJobs();
                    }

                    case 5 -> {
                        this.checkTechnician();
                    }

                    default -> throw new IllegalArgumentException("Please enter a legit number.");
                }
            } catch (IllegalArgumentException e){System.out.println(e.getMessage());}
        }
    }

    public void checkVMachine ()  {
        try {
            ResultSet rset = stmt.executeQuery("SELECT * FROM" );
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }

    public void checkVMachine (String machineNum)  {
        try {
            ResultSet rset = stmt.executeQuery("SELECT * FROM ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }


    }

    public void checkPurchase (){
        try {
            ResultSet rset = stmt.executeQuery("SELECT * FROM ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }

    public void checkPurchase (String machineNum){
        try {
            ResultSet rset = stmt.executeQuery("SELECT * FROM ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void checkWhouse (){
        //join warehouse table and warehouse stock table
        try {
            ResultSet rset = stmt.executeQuery("SELECT * FROM ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void checkWhouse (String machineNum){
        //join warehouse table and warehouse stock table
        try {
            ResultSet rset = stmt.executeQuery("SELECT * FROM ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void checkJobs (){
        try {
            ResultSet rset = stmt.executeQuery("SELECT * FROM ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }

    public void checkTechnician (){
        try {
            ResultSet rset = stmt.executeQuery("SELECT * FROM ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }



}
