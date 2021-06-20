package web;

import DB.DepartamentoDAO;
import DB.Dept_employeeDAO;
import DB.Dept_managerDAO;
import DB.EmployeeDAO;
import Entities.Department;
import Entities.Dept_employee;
import Entities.Dept_manager;
import Entities.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "FullDepartmentServlet", urlPatterns = {"/FullDepartment"})
public class FullDepartmentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Detalle de departamento</title>");
        out.println("</head>");
        out.println("<body>");
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        Dept_employeeDAO deptEmployeeDAO = new Dept_employeeDAO();
        Dept_managerDAO deptManagerDAO = new Dept_managerDAO();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        out.println();

        try {
            Department dept = departamentoDAO.query().parallelStream().filter(d -> d.getDept_no().equals(id)).collect(Collectors.toList()).get(0);
            out.println(dept.getDept_no() + " " + dept.getDept_name());
            List<Dept_employee> depte = deptEmployeeDAO.query().parallelStream().filter(de -> de.getDept_no().equals(dept.getDept_no())).collect(Collectors.toList());
            employeeDAO.query().parallelStream().filter(e -> depte.stream().allMatch(d -> d.getEmp_no() == e.getEmp_no()) ? false : true).forEach((e) -> {
                out.println("<p>" + e.getEmp_no() + " " + e.getFirst_name() + " " + e.getLast_name() + "</p><br>");
            });
            Dept_manager deptManager = deptManagerDAO.query().parallelStream().filter(dm -> dm.getDept_no().equals(dept.getDept_no())).collect(Collectors.toList()).get(0);
            employeeDAO.query().parallelStream().filter(m -> m.getEmp_no() == deptManager.getEmp_no()).forEach(m -> out.println("Manager: " +m.getEmp_no() + " " + m.getFirst_name() + " " + m.getLast_name()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("</body>");
        out.println("</html>");
    }
}
