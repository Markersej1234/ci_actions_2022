package ci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnector
{
    private static String URL = "jdbc:mysql://157.230.27.154:3306/startcode_test?serverTimezone=Europe/Copenhagen";
    private static String USER = "mark";
    private static String PW = "root";

    private static Connection singleton;

    public static void setConnection(Connection con)
    {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException
    {
        if (singleton == null)
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            singleton = DriverManager.getConnection(URL, USER, PW);
        }
        return singleton;
    }

}
