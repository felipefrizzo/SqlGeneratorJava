package br.univel.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by felipefrizzo on 4/24/16.
 */
public class ConnectionDB {
    private Connection con;
    private static ConnectionDB inst;
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://192.168.99.100:5432/sqlgen";
    private String username = "postgres";
    private String password = "{root}";

    public ConnectionDB() {

    }

    public static ConnectionDB getInstance() {
        if (inst == null)
            return inst = new ConnectionDB();
        return inst;
    }

    public Connection open() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            return con;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
