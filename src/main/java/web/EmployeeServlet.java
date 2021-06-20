package web;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.sql.SQLException;

import Entities.Employee;
import DB.EmployeeDAO;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/Employee"})
public class EmployeeServlet extends HttpServlet {

    private final int num = 50;

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        EmployeeDAO dao = new EmployeeDAO();
        String index = request.getParameter("page");
        int page = 1;
        if(index != null)
            page = Integer.parseInt(index);
        String nextp = "<a href=\"/TercerParcial/Employee?page=" + (page + 1) + "\">next</a>";
        try {
            List<Employee> employees = dao.query();
            int top = page * num - 1;
            if(top > employees.size()) {
                top = employees.size();
                nextp = null;
            }
            List<Employee> pagemp = employees.subList(num * (page - 1), top);
            request.setAttribute("employees", pagemp);
            request.setAttribute("nextp", nextp);
            request.getRequestDispatcher("/Employees.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException{

    }
}
