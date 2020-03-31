package lesson2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConEx {
    public static Connection getMeSQLConnection() throws SQLException, ClassNotFoundException{
        String hostname = "localhost";
        String dbName = "shop";
        String user = "root";
        String password = "root";

        return getMeSQLConnection(hostname, dbName, user, password);
    }

    public static Connection getMeSQLConnection(
            String hostname,
            String dbName,
            String user,
            String password
    ) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionURL = "jdbc:mysql://"+hostname+":3306/" + dbName;
        Connection connection = DriverManager.getConnection(connectionURL, user, password);
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection   = getMeSQLConnection();
            System.out.println("Ready");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
