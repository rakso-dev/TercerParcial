package DB;

import Entities.Title;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TitleDAO {

    public List<Title> query() throws SQLException {
        Connection conn = Conexion.connect();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM titles");
        List<Title> titles= new ArrayList<>();
        while(rs.next())
            titles.add(new Title(rs.getInt("emp_no"), rs.getString("title"), rs.getDate("from_date"), rs.getDate("to_date")));
        Conexion.close(rs);
        Conexion.close(st);
        Conexion.close(conn);
        return titles;
    }
}
