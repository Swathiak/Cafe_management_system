package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Util.Db;

public class Connect {
    protected static Connection conn;
    protected static Statement stmt;
    public static synchronized Connection getConnection() throws SQLException{
        conn=DriverManager.getConnection(Db.databaseURL, Db.databaseUser, Db.databasePassword);
        stmt=conn.createStatement();
        return conn;
    }
}