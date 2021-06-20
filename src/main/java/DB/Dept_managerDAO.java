package DB;

import Entities.Dept_manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dept_managerDAO {
    public List<Dept_manager> query() throws SQLException {
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM dept_manager");
        List<Dept_manager> dm = new ArrayList<>();
        while (rs.next())
            dm.add(new Dept_manager(rs.getInt("emp_no"), rs.getString("dept_no"), rs.getDate("from_date"), rs.getDate("to_date")));
        Conexion.close(rs);
        Conexion.close(st);
        Conexion.close(conn);
        return dm;
    }
}
