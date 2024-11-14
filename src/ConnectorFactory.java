import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorFactory {
    private static String url="jdbc:mysql://localhost:3306/animals_db";
    private static String user="root";
    private static String password="Kiran123@";
    private static Connection con;
     static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

             con= DriverManager.getConnection(url,user,password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
