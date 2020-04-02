package myweb1;

import java.sql.*;
public class Connector {
    public static void main(String[] args) {
        String server = "jdbc:mysql://localhost/mydb?useSSL=false";
        String user_name = "root";
        String password = "1234";
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.err.println("!! <JDBC Error> Driver Load : " + e.getMessage());
            e.printStackTrace();
        }
        try{
            conn =  DriverManager.getConnection(server, user_name, password);
        }catch(SQLException e){
            System.err.println("!! <Conn Error> : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
