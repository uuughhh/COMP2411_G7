import java.util.*;
import java.io.*;
import java.io.Console;
import java.sql.*;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.driver.*;
import oracle.sql.*;

public class Technician {
    private String id;

    public Technician (String id, OracleConnection Conn) throws SQLException {
        this.id = id;
        Statement stmt = Conn.createStatement();
        boolean run = true;
        while (run) {
        System.out.print("1 -->> Get your refill invoice \n" +
                "2 -->> Get a list of job to be done  \n" +
                "-1 -->> Exit\n" +
                "Please select the type of query you like to make:\n");
        Scanner operation = new Scanner(System.in);
        int operationNum;
            if (operation.hasNextLine()) {
                operationNum = Integer.parseInt(operation.nextLine());
                switch (operationNum) {

                    case 1 -> {this.getRefillInvoice(stmt);}

                    case 2 -> {
                        System.out.print("If you want to check the jobs of a certain machine, please enter its name, else enter 1 to check all.");
                        Scanner machine = new Scanner(System.in);
                        if (machine.nextLine().equals("1")) this.getJobs(stmt);
                        else this.getJobs(machine.nextLine(), stmt);

                        System.out.print("Enter the Job id number if you want to set a job as done. Enter -1 to exit.");
                        Scanner job = new Scanner(System.in);
                        this.setJobDone(job.nextLine(), stmt);
                        System.out.print("The job has been set as finished.");
                    }

                    case -1 -> run = false;
                    default -> throw new IllegalArgumentException("Please enter a legit number.");
                }
            }
        }
    }

    public void getRefillInvoice (Statement statement) throws SQLException {
        ResultSet rset = statement.executeQuery("SELECT * FROM RefillInvoices WHERE Technician_id = "+ id);
        while (rset.next())
        {

        }
    }

    public void getJobs (Statement statement) throws SQLException {
        ResultSet rset = statement.executeQuery("SELECT * FROM Job");
        while (rset.next())
        {

        }
    }

    public void getJobs (String machineID,Statement statement) throws SQLException {
        ResultSet rset = statement.executeQuery("SELECT * FROM Job WHERE Job_id = "+machineID);
        int counter = 0;
        while (rset.next())
        {
            counter++;
        }
        if (counter == 1) throw new IllegalArgumentException("Wrong machine number.");
    }

    public void setJobDone (String jobID,Statement statement) throws SQLException {
        ResultSet rset = statement.executeQuery("SELECT * FROM Job WHERE Job_id = "+jobID+ "AND Status = ???");
        int counter = 0;
        while (rset.next())
        {
            counter++;
        }
        if (counter == 1) throw new IllegalArgumentException("Wrong Job ID number.");
        //need to add to refill invoice too
    }



}
