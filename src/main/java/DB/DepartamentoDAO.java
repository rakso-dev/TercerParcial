package DB;

import Entities.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {

    /*public void execute (ArrayList<Department> e) {
        e.parallelStream().forEach( item -> System.out.println(item.toString()));
        try {
            Thread.sleep(200);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }*/

    public ArrayList<Department> query () throws SQLException {
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM departments");
        ArrayList<Department> depto = new ArrayList<>();
        while (rs.next()){
            depto.add(new Department(rs.getString("dept_no"),rs.getString("dept_name")));
        }

        Conexion.close(rs);
        Conexion.close(st);
        Conexion.close(conn);

        return depto;
    }

}
