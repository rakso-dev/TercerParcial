package web;

import DB.DepartamentoDAO;
import Entities.Department;
import Entities.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DepartmentsServlet", urlPatterns = {"/Departments"})
public class DepartmentServlet extends HttpServlet {

    private final int num = 50;

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartamentoDAO dao = new DepartamentoDAO();
        String index = request.getParameter("page");
        int page = 1;
        if(index != null)
            page = Integer.parseInt(index);
        String nextp = "<a href=\"/TercerParcial/Departments?page=" + (page + 1) + "\">next</a>";
        try {
            List<Department> departments = dao.query();
            int top = page * num - 1;
            if(top > departments.size()) {
                top = departments.size();
                nextp = null;
            }
            List<Department> pagdep = departments.subList(num * (page - 1), top);
            request.setAttribute("departments", pagdep);
            request.setAttribute("nextp", nextp);
            request.getRequestDispatcher("/Departments.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
