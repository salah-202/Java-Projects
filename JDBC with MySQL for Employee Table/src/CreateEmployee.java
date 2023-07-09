import java.sql.*;
import java.util.Scanner;

public class CreateEmployee {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sales","root","123456789");

            createTable(connection);
            updateTable(connection);


            Statement showStmt = connection.createStatement();
            ResultSet resultSet = showStmt.executeQuery("SELECT * FROM Employee");

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "
                        +resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getInt(5)
                        +" "+resultSet.getString(6)+" "+resultSet.getInt(7)+" "+resultSet.getInt(8));
            }

            resultSet.close();
            showStmt.close();
            connection.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void createTable(Connection conn){
        Scanner sc = new Scanner(System.in);
        try{
            String sql = "CREATE TABLE Employee(" +
                    "id int NOT NULL AUTO_INCREMENT," +
                    "F_Name varchar(32) NOT NULL,"+
                    "L_Name varchar(32) NOT NULL,"+
                    "Sex varchar(6) NOT NULL,"+
                    "Age int NOT NULL,"+
                    "Address varchar(128) NOT NULL,"+
                    "Phone_Number int NOT NULL,"+
                    "Vacation_Balance int NOT NULL DEFAULT 30,"+
                    "PRIMARY KEY ( id ))";

            Statement createStmt = conn.createStatement();
            createStmt.executeUpdate(sql);

            PreparedStatement insertValues = conn.prepareStatement("INSERT INTO Employee " +
                    "(F_Name,L_Name,Sex,Age,Address,Phone_Number) VALUES(?,?,?,?,?,?);");

            for (int i = 0; i < 5; i++) {

                System.out.println("Enter Employee "+ (i+1) +" data \n");

                System.out.println("Enter First Name");
                insertValues.setString(1,sc.next());

                System.out.println("Enter Last Name");
                insertValues.setString(2,sc.next());

                System.out.println("Enter Sex");
                insertValues.setString(3,sc.next());

                System.out.println("Enter Age");
                insertValues.setInt(4,sc.nextInt());

                System.out.println("Enter Address");
                insertValues.setString(5,sc.next());

                System.out.println("Enter Phone Number");
                insertValues.setInt(6,sc.nextInt());

                insertValues.executeUpdate();
            }



        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public static void updateTable(Connection conn){

        try {
            PreparedStatement updateStmt = conn.prepareStatement(
                    "UPDATE Employee SET Vacation_Balance = 45 ,F_Name = CONCAT(?,F_Name) " +
                            "WHERE Age > 45 AND Sex = ?;");

            updateStmt.setString(1,"Mr.");
            updateStmt.setString(2,"male");
            updateStmt.addBatch();

            updateStmt.setString(1,"Mrs.");
            updateStmt.setString(2,"female");
            updateStmt.addBatch();

            updateStmt.executeBatch();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}