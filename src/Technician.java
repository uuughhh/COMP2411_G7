import java.util.*;
import java.io.*;
import java.io.Console;
import java.sql.*;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.*;
import oracle.sql.*;

public class Technician {
    private final String id;

    public Technician (String id, OracleConnection Conn) throws SQLException {
        this.id = id;
        Statement stmt = Conn.createStatement();
        boolean run = true;
        while (run) {
        System.out.print("1 -->> Get your refill invoice \n" +
                "2 -->> Get a list of job to be done  \n" +
                "3 -->> Get the location of your warehouse  \n" +
                "-1 -->> Exit\n" +
                "Please select the type of query you like to make:\n");
        Scanner operation = new Scanner(System.in);
        int operationNum;
            if (operation.hasNextLine()) {
                operationNum = Integer.parseInt(operation.nextLine());
                try{
                    switch (operationNum) {

                        case 1 -> {this.getRefillInvoice(stmt);}

                        case 2 -> {
                            this.getJobs(stmt);

                            System.out.print("Enter the Job id number if you want to set a job as done. Enter -1 to exit.");
                            Scanner job = new Scanner(System.in);
                            this.setJobDone(job.nextLine(), stmt);
                            System.out.print("The job has been set as finished.");
                        }

                        case 3 -> {
                            this.getLocation(stmt);
                        }

                        case -1 -> run = false;
                        default -> throw new IllegalArgumentException("Please enter a legit number.");
                    }
                } catch (IllegalArgumentException e){System.out.println(e.getMessage());}
            }
        }
    }

    public void getRefillInvoice (Statement statement) {
        try {
            ResultSet rset = statement.executeQuery("SELECT * FROM RefillInvoices WHERE Technician_id = "+ id);
            while (rset.next())
            {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getJobs (Statement statement)  {
        try {
            ResultSet rset = statement.executeQuery("SELECT * FROM Job WHERE TECHNICIANID ="+id);
            while (rset.next())
            {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void setJobDone (String jobID,Statement statement) {
        try {
            int rowNum0 = statement.executeUpdate("UPDATE Job SET Status = ??? WHERE Job_id = " + jobID);
            if (rowNum0 == 0) throw new IllegalArgumentException("Wrong job ID.");
            //need to add to refill invoice too
            int rowNum1 = statement.executeUpdate("");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getLocation (Statement statement)  {
        try {
            ResultSet rset = statement.executeQuery("SELECT Location FROM Warehouse WHERE Job_id = "+
                    id + "AND Status = ???");
            while (rset.next())
            {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
