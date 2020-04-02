package myweb2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    String server = "jdbc:mysql://localhost/mydb?useSSL=false";
    String user_name = "root";
    String password = "1234";
    Connection conn = null;
    public void getInstance() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.err.println("!! <JDBC Error> Driver Load : " + e.getMessage());
            e.printStackTrace();
        }
    }
    synchronized public Connection connect(){
        try{
            conn =  DriverManager.getConnection(server, user_name, password);
        }catch(SQLException e){
            System.err.println("!! <Conn Error> : " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}
