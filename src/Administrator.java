import java.util.*;
import java.sql.*;
import java.time.LocalTime;
import oracle.jdbc.OracleConnection;

public class Administrator {

    private PreparedStatement pstmt;
    private OracleConnection Conn;

    public Administrator(OracleConnection Conn) throws SQLException {
        this.Conn = Conn;
        boolean run = true;
        while (run) {
            try {
                System.out.print("1 -->> Get information about the vending machine system \n" +
                        "2 -->> Update information of the vending machine system\n" +
                        "-1 -->> Exit\n" +
                        "Please choose an option to execute:");
                Scanner operation_0 = new Scanner(System.in);
                int operationNum_0;
                if (operation_0.hasNextLine()) {
                    operationNum_0 = Integer.parseInt(operation_0.nextLine());
                    switch (operationNum_0) {
                        case 1 -> this.queries();

                        case 2 -> this.updates();

                        case -1 -> run = false;

                        default -> throw new IllegalArgumentException("Please enter a legit number.");
                    }
                }
            } catch (IllegalArgumentException e) {System.out.println(e.getMessage());}
        }
    }



    public void updates (){
        System.out.print("1 -->> Change information about vending machines \n" +
                "   2 -->> Change Available Items\n" +
                "   3 -->> Change Jobs\n" +
                "   4 -->> Change Technicians\n" +
                "   5 -->> Change Suppliers\n" +
                "   Please choose an option to execute:");
        Scanner operation = new Scanner(System.in);
        int num;
        if (operation.hasNextLine()) {
            num = Integer.parseInt(operation.nextLine());
            try {
                switch (num) {
                    case 1 -> {
                        System.out.print("If you want to remove a certain machine, please enter its ID number, " +
                                "else enter 1 to add new machine");
                        Scanner machine = new Scanner(System.in);
                        if (machine.nextLine().equals("1")) createMachine();
                        else deleteMachine(machine.toString());
                    }

                    case 2 -> {
                        System.out.print("If you want to remove existing item, please enter its ID number, " +
                                "else enter 1 to add new item");
                        Scanner item = new Scanner(System.in);
                        if (item.nextLine().equals("1")) createItem();

                        else deleteItem(item.toString());
                    }

                    case 3 -> {
                        Scanner job = new Scanner(System.in);
                        if (job.nextLine().equals("1")) createJob();

                        else deleteJob(job.toString());
                    }

                    case 4 -> {
                        System.out.print("If you want to remove technician, please enter their ID number, " +
                                "else enter 1 to add new technician");
                        Scanner technician = new Scanner(System.in);
                        if (technician.nextLine().equals("1")) createTechnician();

                        else deleteTechnician(technician.toString());
                    }

                    case 5 -> {
                        System.out.print("If you want to remove supplier, please enter their ID number, " +
                                "else enter 1 to add new supplier");
                        Scanner supplier = new Scanner(System.in);
                        if (supplier.nextLine().equals("1")) createSupplier();

                        else deleteSupplier(supplier.toString());
                    }

                    default -> throw new IllegalArgumentException("Please enter a legit number.");
                }
            } catch (IllegalArgumentException | SQLException e){System.out.println(e.getMessage());}
        }
    }

    public void queries () {
        System.out.print("[About Vending Machine] \n"+
                "   1 -->> Check out vending machines \n" +
                "   2 -->> Check out machine stock \n" +
                "   3 -->> Check out machine refill status \n" +
                "   4 -->> Check out Purchase information \n"+
                "[About Warehouse] \n"+
                "   5 -->> Check out warehouses\n" +
                "   6 -->> Check out suppliers\n" +
                "   7 -->> Check out existing items \n"+
                "[About Tasks & Technicians] \n"+
                "   8 -->> Check out Technicians\n" +
                "   9 -->> Check out Tasks\n" +
                "   10 -->> Check out Technicians refill status\n" +
                "11 -->> Enter a legit query by yourself\n" +

                "Please choose an option to execute:");
        Scanner operation_1 = new Scanner(System.in);
        int operationNum_1;
        if (operation_1.hasNextLine()) {
            operationNum_1 = Integer.parseInt(operation_1.nextLine());
            try {
                switch (operationNum_1) {
                    case 1 -> {
                        System.out.print("If you want to check on a certain machine, please enter its ID number, " +
                                "else enter -1 to check all.");
                        Scanner machine = new Scanner(System.in);
                        if (machine.nextLine().equals("-1")) this.checkVMachine();
                        else this.checkVMachine(machine.nextLine());
                    }

                    case 2 -> {
                        this.checkVMachine();
                        System.out.print("Enter a machine id to check its stock.");
                        Scanner stock = new Scanner(System.in);
                        this.checkMStock(stock.nextLine());
                    }

                    case 3 -> {
                        this.checkVMachine();
                        System.out.print("Enter a machine id to check its refill status.");
                        Scanner refill = new Scanner(System.in);
                        this.checkMachineRefill(refill.nextLine());
                    }

                    case 4 -> {
                        this.checkVMachine();
                        System.out.print("If you want to check purchase records on a certain machine, please enter its ID number");
                        Scanner purchase = new Scanner(System.in);
                        this.checkPurchase(purchase.toString());
                    }

                    case 5 -> {
                        this.checkWhouse();
                        System.out.print("If you want to check on the stock of a certain warehouse, please enter its ID number, " +
                                "else enter -1 to check all.");
                        Scanner warehouse = new Scanner(System.in);
                        if (warehouse.toString().equals("-1")) this.checkWStock();
                        else this.checkWStock(warehouse.toString());
                    }

                    case 6 -> this.checkSupp();

                    case 7 ->{
                        this.checkSupp();
                        System.out.print("If you want to check on the items provide a certain supplier, please enter its ID number, " +
                                "else enter -1 to check all.");
                        Scanner supp = new Scanner(System.in);
                        if (supp.toString().equals("-1")) this.checkItem();
                        else this.checkItem(supp.toString());
                    }

                    case 8 ->this.checkTechnician();

                    case 9 ->{
                        this.checkTechnician();
                        System.out.print("If you want to check out tasks of a certain technician, please enter the ID number, " +
                                "else enter -1 to check all.");
                        Scanner task = new Scanner(System.in);
                        if (task.nextLine().equals("-1")) this.checkTasks();
                        else this.checkTasks(task.nextLine());
                    }

                    case 10 ->{
                        this.checkTechnician();
                        System.out.print("Please enter a technician ID to check corresponding refill invoice");
                        Scanner techID = new Scanner(System.in);
                        this.checkTechRefill(techID.toString());
                    }

                    case 11 ->{
                        System.out.print("Please enter a legit sql query.");
                        Scanner query = new Scanner(System.in);
                        this.otherQuery(query.toString());
                    }

                    default -> throw new IllegalArgumentException("Please enter a legit number.");
                }
            } catch (IllegalArgumentException e){System.out.println(e.getMessage());}
        }
    }

    public void checkVMachine ()  {
        try {
            pstmt = Conn.prepareStatement("SELECT * FROM Vending_Machine ");
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                System.out.println(rset.getString(1)
                        + " " + rset.getString(2)
                        + " " + rset.getString(3)
                        + " " + rset.getString(4)
                        + " " + rset.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }

    public void checkVMachine (String machineNum)  {
        try {
            pstmt = Conn.prepareStatement("SELECT * FROM Vending_Machine WHERE Vending_Machine_ID = ?");
            pstmt.setInt(1,Integer.parseInt(machineNum));
            ResultSet rset = pstmt.executeQuery();
            if (!rset.next()) throw new IllegalArgumentException("Wrong machine ID.");
            while (rset.next())
            {
                System.out.println(rset.getString(2)
                        + " " + rset.getString(3)
                        + " " + rset.getString(4)
                        + " " + rset.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void checkMStock(String machineNum)  {
        try {
            pstmt = Conn.prepareStatement("SELECT Delivery_Invoice.Item_ID, Vending_Machine_Stock.Quantity " +
                    "FROM(Vending_Machine_Stock INNER JOIN " +
                    "(Delivery_Invoice INNER JOIN " +
                    "(SELECT Refill_Invoice.Delivery_ID,Refill_Invoice.Refill_ID FROM Refill_Invoice WHERE Machine_ID = ?) " +
                    "ON Delivery_Invoice.Delivery_ID = Refill_Invoice.Delivery_ID) " +
                    "ON Vending_Machine_Stock.Refill_ID = Refill_Invoice.Refill_ID)");
            pstmt.setInt(1,Integer.parseInt(machineNum));
            ResultSet rset = pstmt.executeQuery();
            if (!rset.next()) throw new IllegalArgumentException("Wrong address or empty stock in the machine.");
            while (rset.next())
            {
                System.out.println(rset.getString(1)
                        + " " + rset.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }


    }

    public void checkMachineRefill (String machineNum)  {
        try {
            pstmt = Conn.prepareStatement("SELECT Refill_Invoice.Refill_ID, Delivery_Invoice.Item_ID, Refill_Invoice.Quantity,Refill_Invoice.Refill_Date, Refill_Invoice.Technician_ID " +
                    "FROM Refill_Invoice, Delivery_Invoice " +
                    "WHERE Refill_Invoice.Machine_ID = ? AND Refill_Invoice.Delivery_ID = Delivery_Invoice.Delivery_ID "  );
            pstmt.setInt(1,Integer.parseInt(machineNum));
            ResultSet rset = pstmt.executeQuery();
            if (!rset.next()) throw new IllegalArgumentException("Wrong machine ID or empty refill invoice.");
            while (rset.next())
            {
                System.out.println(rset.getString(1)
                        + " " + rset.getString(2)
                        + " " + rset.getString(3)
                        + " " + rset.getString(4)
                        + " " + rset.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }



    public void checkPurchase (String machineNum){
        try {
            pstmt = Conn.prepareStatement("SELECT Purchase_Invoice.Purchase_ID, Delivery_Invoice.Item_ID, Purchase_Invoice.Purchase_Date " +
                    "FROM(Purchase_Invoice INNER JOIN " +
                    "(Delivery_Invoice INNER JOIN " +
                    "(SELECT Refill_Invoice.Delivery_ID,Refill_Invoice.Refill_ID FROM Refill_Invoice WHERE Machine_ID = ?) " +
                    "ON Delivery_Invoice.Delivery_ID = Refill_Invoice.Delivery_ID) " +
                    "ON Purchase_Invoice.Refill_ID = Refill_Invoice.Refill_ID)");
            pstmt.setInt(1, Integer.parseInt(machineNum));
            ResultSet rset = pstmt.executeQuery();

            if (!rset.next()) throw new IllegalArgumentException("Wrong input.");
            while (rset.next())
            {
                System.out.println(rset.getString(1)
                        + " " + rset.getString(2)
                        + " " + rset.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void checkWhouse (){
        try {
            pstmt = Conn.prepareStatement("SELECT * FROM Warehouse");
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                System.out.println(rset.getString(1)
                        + " " + rset.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void checkWStock (){
        try {
            pstmt = Conn.prepareStatement("SELECT Delivery_Invoice.Warehouse_ID, Delivery_Invoice.Item_ID, Warehouse_Stock.Quantity " +
                    "FROM Warehouse_Stock, Delivery_Invoice");
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                System.out.println(rset.getString(1)
                        + " " + rset.getString(2)
                        + " " + rset.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }

    public void checkWStock (String houseNum){
        try {
            pstmt = Conn.prepareStatement("SELECT Delivery_Invoice.Item_ID, Warehouse_Stock.Quantity " +
                    "FROM Warehouse_Stock, Delivery_Invoice " +
                    "WHERE Delivery_Invoice.Warehouse_ID = ? AND Delivery_Invoice.Delivery_ID = Warehouse_Stock.Delivery_ID ");
            pstmt.setInt(1, Integer.parseInt(houseNum));
            ResultSet rset = pstmt.executeQuery();
            if (!rset.next()) throw new IllegalArgumentException("Wrong warehouse Id or empty stock.");
            while (rset.next())
            {
                System.out.println(rset.getString(1)
                        + " " + rset.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void checkSupp (){
        try {
            pstmt = Conn.prepareStatement("SELECT * FROM Supplier");
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                System.out.println(rset.getString(1)
                        + " " + rset.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }

    public void checkItem (){
        try {
            pstmt = Conn.prepareStatement("SELECT * FROM Item");
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                System.out.println(rset.getString(1)
                        + " " + rset.getString(2)
                        + " " + rset.getString(3)
                        + " " + rset.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }

    public void checkItem (String supp){
        try {
            pstmt = Conn.prepareStatement("SELECT Item_ID, Item_Name, Sell_Price " +
                    "FROM Item WHERE Supplier = ?");
            pstmt.setInt(1, Integer.parseInt(supp));
            ResultSet rset = pstmt.executeQuery();
            if (!rset.next()) throw new IllegalArgumentException("Wrong supplier id or it has no item.");
            while (rset.next())
            {
                System.out.println(rset.getString(1)
                        + " " + rset.getString(2)
                        + " " + rset.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void checkTechnician (){
        try {
            pstmt = Conn.prepareStatement("SELECT * FROM Technician");
            ResultSet rset = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }

    public void checkTasks(String techID)  {
        try {
            pstmt = Conn.prepareStatement("SELECT * FROM Task " +
                    "WHERE Technician_Assigned_ID = ?");
            pstmt.setInt(1, Integer.parseInt(techID));
            ResultSet rset = pstmt.executeQuery();
            if (!rset.next()) throw new IllegalArgumentException
                    ("Wrong technician ID or no task has been assigned.");
            while (rset.next())
            {
                System.out.println(rset.getString(1)
                        + " " + rset.getString(2)
                        + " " + rset.getString(3)
                        + " " + rset.getString(4)
                        + " " + rset.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void checkTasks(){
        try {
            pstmt = Conn.prepareStatement("SELECT * FROM Task");
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                System.out.println(rset.getString(1)
                        + " " + rset.getString(2)
                        + " " + rset.getString(3)
                        + " " + rset.getString(4)
                        + " " + rset.getString(5)
                        + " " + rset.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }

    public void checkTechRefill(String techID){
        try {
            pstmt = Conn.prepareStatement("SELECT Refill_Invoice.Refill_ID, Delivery_Invoice.Item_ID, Refill_Invoice.Machine_ID, Refill_Invoice.Quantity, Refill_Invoice.Refill_Date " +
                    "FROM Refill_Invoice, Delivery_Invoice " +
                    "WHERE Refill_Invoice.Technician_ID = ? AND Refill_Invoice.Delivery_ID = Delivery_Invoice.Delivery_ID");
            pstmt.setInt(1, Integer.parseInt(techID));
            ResultSet rset = pstmt.executeQuery();
            if (!rset.next()) throw new IllegalArgumentException
                    ("Wrong technician ID or no refill invoice.");
            while (rset.next())
            {
                System.out.println(rset.getString(1)
                        + " " + rset.getString(2)
                        + " " + rset.getString(3)
                        + " " + rset.getString(4)
                        + " " + rset.getString(5)
                        + " " + rset.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }

    }

    public void otherQuery(String query)  {
        try {
            pstmt = Conn.prepareStatement(query);
            ResultSet rset = pstmt.executeQuery();
            if (!rset.next()) throw new IllegalArgumentException("NO results.");
            int columnNum = rset.getMetaData().getColumnCount();
            while (rset.next())
            {
                for (int i=1; i<columnNum+1; i++){
                    System.out.print(rset.getString(i)+ " ");
                }
                System.out.print("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createMachine() throws SQLException {
        System.out.println("Please enter new machine's id: ");

        Scanner machine_ID = new Scanner(System.in);
        pstmt = Conn.prepareStatement("SELECT Vending_Machine_ID WHERE Vending_Machine_ID = " + machine_ID + "FROM Vending_Machine");
        // check whether it already exists
        while (pstmt != null){
            System.out.println("ID already exists, please enter another number: ");
            machine_ID = new Scanner(System.in);}

        System.out.println("Please enter new machine's address: ");
        Scanner machine_adress = new Scanner(System.in);
        System.out.println("Please enter new machine's number of slots: ");
        Scanner machine_NumOfS = new Scanner(System.in);

        pstmt = Conn.prepareStatement("SELECT Warehouse_ID FROM  Warehouse");
        ResultSet rset = pstmt.executeQuery();
        System.out.println(rset.getString(1));
        // just id numbers of warehouses
        System.out.println("Please select on of the new machine's warehouse ids above: ");

        Scanner machine_WID = new Scanner(System.in);
        System.out.println("Please enter new machine's status: ");
        //todo its limited number, add choices with names
        Scanner machine_status = new Scanner(System.in);
        try {
            pstmt = Conn.prepareStatement("INSERT INTO Vending_Machine VALUES(" +
                    machine_ID+", "+ machine_adress+ ", "+machine_NumOfS+ ", "+ machine_WID+", "+machine_status+")");
            rset = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void deleteMachine(String machine_ID){
        try {
            pstmt = Conn.prepareStatement("UPDATE Vending_Machine SET chk_Machine_Status  = "
                    + "'Out of Order' WHERE Vending_Machine_ID = " + machine_ID);
            ResultSet rset = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void createItem() throws SQLException {
        System.out.println("Please enter new item's id: ");

        Scanner item_ID = new Scanner(System.in);
        pstmt = Conn.prepareStatement("SELECT Item_ID WHERE Item_ID = " + item_ID + "FROM Item");
        // check whether it already exists
        while (pstmt != null){
            System.out.println("ID already exists, please enter another number: ");
            item_ID = new Scanner(System.in);}

        System.out.println("Please enter new item's name: ");
        Scanner item_name = new Scanner(System.in);
        System.out.println("Please enter new item's supplier id: ");
        //todo its limited number, add choices with names
        Scanner item_SID = new Scanner(System.in);
        System.out.println("Please enter new item's price: ");
        Scanner item_pr = new Scanner(System.in);
        try {
            pstmt = Conn.prepareStatement("INSERT INTO TECHNICIAN VALUES(" +item_ID+", "+ item_name+ ", "+item_SID+ ", "+ item_pr+")");
            ResultSet rset = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void deleteItem(String item_ID){
        //todo only if its not available in machines (quantity == 0)
        try {
            //todo should i delete delivery invoices
            pstmt = Conn.prepareStatement("DELETE FROM Delivery_Invoice WHERE Item_ID= " + item_ID);
            ResultSet rset = pstmt.executeQuery();
            pstmt = Conn.prepareStatement("DELETE FROM Item WHERE Item_ID= " + item_ID);
            ResultSet rset1 = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void createTechnician() throws SQLException {
        System.out.println("Please enter new technician's id: ");

        Scanner technician_ID = new Scanner(System.in);
        pstmt = Conn.prepareStatement("SELECT Technician_ID WHERE Technician_ID = " + technician_ID + "FROM Technician");
        // check whether it already exists
        while (pstmt != null){
            System.out.println("ID already exists, please enter another number: ");
            technician_ID = new Scanner(System.in);}

        System.out.println("Please enter new technician's name: ");
        Scanner technician_name = new Scanner(System.in);
        System.out.println("Please enter new technician's warehouse id: ");
        //todo its limited number, add choices with names
        Scanner technician_WID = new Scanner(System.in);
        try {
            pstmt = Conn.prepareStatement("INSERT INTO Technician VALUES(" +technician_ID+", "+ technician_name+ ", "+technician_WID+")");
            ResultSet rset = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void deleteTechnician(String technician_ID){
        try {
            pstmt = Conn.prepareStatement("DELETE FROM Technician WHERE Technician_ID= " + technician_ID);
            ResultSet rset = pstmt.executeQuery();
            //todo change status of assigned tasks to "To be assigned"
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void createSupplier() throws SQLException {
        System.out.println("Please enter new Supplier's id: ");

        Scanner supplier_ID = new Scanner(System.in);
        pstmt = Conn.prepareStatement("SELECT Supplier_ID WHERE Supplier_ID = " + supplier_ID + "FROM Supplier");
        // check whether it already exists
        while (pstmt != null){
            System.out.println("ID already exists, please enter another number: ");
            supplier_ID = new Scanner(System.in);
        }


        System.out.println("Please enter new Supplier's name: ");
        Scanner supplier_name = new Scanner(System.in);
        try {
            pstmt = Conn.prepareStatement("INSERT INTO Supplier VALUES(" +supplier_ID+", "+ supplier_name+")");
            ResultSet rset = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void deleteSupplier(String supplier_ID){
        try {
            pstmt = Conn.prepareStatement("DELETE FROM Item WHERE Supplier_ID= " + supplier_ID);
            ResultSet rset = pstmt.executeQuery();
            pstmt = Conn.prepareStatement("DELETE FROM Supplier WHERE Supplier_ID= " + supplier_ID);
            ResultSet rset1 = pstmt.executeQuery();
            //todo maybe create separate function to delete items bc it will be used above
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void createJob() throws SQLException {
        System.out.println("Please enter new Job's id: ");

        Scanner job_ID = new Scanner(System.in);
        pstmt = Conn.prepareStatement("SELECT Task_ID WHERE Task_ID = " + job_ID + "FROM Task");
        // check whether it already exists
        while (pstmt != null){
            System.out.println("ID already exists, please enter another number: ");
            job_ID = new Scanner(System.in);
        }

        System.out.println("Please enter new Job's type: ");
        Scanner job_type = new Scanner(System.in);
        System.out.println("Please enter new Job's deadline: ");
        Scanner job_deadline = new Scanner(System.in);
        System.out.println("Please enter new technician's ID assigned to the Job: ");
        //todo check whether exists
        Scanner job_TID = new Scanner(System.in);
        String date=java.time.LocalDate.now().toString();
        try {
            pstmt = Conn.prepareStatement("INSERT INTO Supplier VALUES(" +job_ID+", "+ date + job_type+", "
                    +job_deadline+", "+"'To be assigned'"+", "+job_TID+", "+")");
            ResultSet rset = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }

    public void deleteJob(String job_ID){
        try {
            pstmt = Conn.prepareStatement("UPDATE Task SET Task_Status  = "
                    + "'Canceled' WHERE Task_ID = " + job_ID);
            ResultSet rset = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something is wrong with SQL.");
        }
    }
}
