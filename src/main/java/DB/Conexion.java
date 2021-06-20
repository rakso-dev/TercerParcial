package DB;
import java.sql.*;

public class Conexion {
    private static String user = "root";
    private static String pass = "sqlserver";
    private static String db = "employees";
    private static String server = "jdbc:mysql://localhost:3306/" + db;
    private static String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection connect() throws SQLException{
        try{
            Class.forName(driver).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return DriverManager.getConnection(server, user, pass);
    }

    public static void close (Connection con) throws SQLException {
        con.close();
    }

    public static void close (ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close (Statement st) throws SQLException {
        st.close();
    }

    public static ResultSet getQuery (Connection conn, String query) throws SQLException {
        Statement statement = conn.createStatement();
        return statement.executeQuery(query);
    }

}
