package game_store.DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Class to connect to the database

public class MySqlConnection {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/game_shop";
    static Connection con;

    public static Connection connect() throws SQLException {
        try{
            //***  Establishing the connection
            con = null;
            Statement s = null;
            Class.forName (JDBC_DRIVER);
        }catch(ClassNotFoundException cnfe){
            System.err.println("Error: "+cnfe.getMessage());
        }
        // in the url we have to tell which account and password to use
        con =  DriverManager.getConnection(DATABASE_URL, "root", "numeletrandafirului2");
        return con;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(con !=null && !con.isClosed())
            return con;
        connect();
        return con;
    }
}
