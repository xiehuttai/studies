package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = DbUtil.getConnection();
        Statement statement = connection.createStatement();

        for (int i=3;i<=10000;i++ ){
            String sql="insert into ti_test values ("+i+")";
            statement.execute(sql);
        }
    }


}
