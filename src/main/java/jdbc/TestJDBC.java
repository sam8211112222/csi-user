package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.Util;

public class TestJDBC {

    public static void main(String[] args) {
        Connection con = null;

        try {
            System.out.println(Util.MySQLURL);
            con = DriverManager.getConnection(Util.MySQLURL, Util.MySQLUSER, Util.MySQLPASSWORD);
            System.out.println("Connecting to database successfully! (連線成功！)");
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException se) {
                    System.err.println(se.getMessage());
                }
            }
        }
    }

}
