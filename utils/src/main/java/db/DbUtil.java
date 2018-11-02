package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static final String url = "jdbc:mysql://10.60.41.71:4000/test?user=root&useUnicode=true&characterEncoding=UTF8&verifyServerCertificate=false";
    private static Connection connection=null;

    public static Connection getConnection() {
        if (connection==null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
