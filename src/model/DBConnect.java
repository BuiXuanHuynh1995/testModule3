package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static Connection getConnection(){
        String url ="jdbc:mysql://localhost:3306/united?useSSL=false";
        String user ="root";
        String pass="sa1234$";

        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(url,user,pass);
            System.out.println("Connection Successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connection "+e);
        }
        return connection;
    }

    public static void main(String[] args) {
        DBConnect.getConnection();
    }
}
