package bank.management.system;


import java.sql.*;
public class connection {
    //there are 5 steps to connect to the database
    // 1. register the driver
    // 2. create connection
    // 3. create statement
    // 4. execute query
    // 5. close connection


    //create a constructor named connection

    Connection c; // global declaration of class Connection and c is the object name of the class
    static Statement s; // global declaration of class Statement and s is the object name of the class


    public connection() {
        try {    //we should do exceptional handling coz MySQL is an external entity so errors will be more

            // to register the driver:
        // the below line is not required coz we added library and java will consider the classpath directly:
            // Class.forName(com.mysql.cj.jdbc.Driver);  // here Class is a class name and forName is a static method

            // to create connection:
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "<type the password of MySQL>");  //mysql by default hosts on port 3306

            // to create statement:
            s = c.createStatement();


        }catch (Exception e) {
            System.out.println(e);
        }


    }


}
