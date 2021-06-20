package DB;

import Entities.Dept_employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dept_employeeDAO {

    public List<Dept_employee> query() throws SQLException {
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM dept_emp");
        List<Dept_employee> de = new ArrayList<>();
        while (rs.next())
            de.add(new Dept_employee(rs.getInt("emp_no"), rs.getString("dept_no"), rs.getDate("from_date"), rs.getDate("to_date")));
        Conexion.close(rs);
        Conexion.close(st);
        Conexion.close(conn);
        return de;
    }
}
