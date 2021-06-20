package DB;
import Entities.Employee;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeDAO {

    /*public void execute (List<Employee> e) {
        e.parallelStream().forEach( item -> System.out.println(item.toString()));
        try {
            Thread.sleep(200);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }*/

    public List<Employee> query () throws SQLException {
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employees");
        ArrayList<Employee> employees = new ArrayList<>();
        while (rs.next()){
            employees.add(new Employee(rs.getInt("emp_no"), rs.getDate("birth_date"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender").charAt(0), rs.getDate("hire_date")));
        }

        Conexion.close(rs);
        Conexion.close(st);
        Conexion.close(conn);

        return employees;
    }
}
