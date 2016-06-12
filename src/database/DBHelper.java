package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Dewes on 11/06/2016.
 */
public class DBHelper {
    private static final String IP_ADDRESS = "localhost";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String DB_NAME = "flowidea_db";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    public static Connection CONN = null;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            if (CONN==null || CONN.isClosed()){
                CONN = DriverManager.getConnection("jdbc:mysql://"+ IP_ADDRESS +"/"+ DB_NAME +"?useSSL=false", USER, PASS);
                System.out.println("Conexão aberta.");
            }
            return CONN;
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (SQLException e) {
            closeConnection();
            throw new RuntimeException(e);
        }
    }

    private static void closeConnection(){
        try{
            if(CONN!=null && !CONN.isClosed()){
                CONN.close();
                System.out.println("Conexão fechada. ");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("conexao: "+getConnection());
        System.out.println("conexao: "+getConnection());
        System.out.println("conexao: "+getConnection());
    }

}
