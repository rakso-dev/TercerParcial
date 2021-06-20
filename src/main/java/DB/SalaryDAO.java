package DB;

import Entities.Salary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAO {
    public List<Salary> query() throws SQLException {
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM salaries");
        List<Salary> salaries = new ArrayList<>();
        while (rs.next())
            salaries.add(new Salary(rs.getInt("emp_no"), rs.getInt("salary"), rs.getDate("from_date"), rs.getDate("to_date")));
        Conexion.close(rs);
        Conexion.close(st);
        Conexion.close(conn);
        return salaries;
    }
}
