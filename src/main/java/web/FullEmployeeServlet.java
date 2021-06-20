package web;

import DB.*;
import Entities.Dept_employee;
import Entities.FullEmployee;

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
import java.util.stream.Stream;

@WebServlet(name = "FullEmployee", urlPatterns = {"/FullEmployee"})
public class FullEmployeeServlet extends HttpServlet {

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Detalle de departamento</title>");
        out.println("</head>");
        out.println("<body>");

        EmployeeDAO employeeDAO = new EmployeeDAO();
        SalaryDAO salaryDAO = new SalaryDAO();
        TitleDAO titleDAO = new TitleDAO();
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        Dept_employeeDAO deptEmployeeDAO = new Dept_employeeDAO();
        Dept_managerDAO deptManagerDAO = new Dept_managerDAO();

        try {
            FullEmployee femployee = new FullEmployee();
            femployee.setData(employeeDAO.query().parallelStream().filter(e -> e.getEmp_no() == id).collect(Collectors.toList()).get(0));
            femployee.setIncome(salaryDAO.query().parallelStream().filter(s -> s.getEmp_no() == id).collect(Collectors.toList()).get(0));
            femployee.setTitle(titleDAO.query().parallelStream().filter(t -> t.getEmp_no() == id).collect(Collectors.toList()).get(0));
            String depID = deptEmployeeDAO.query().parallelStream().filter(de -> de.getEmp_no() == id).collect(Collectors.toList()).get(0).getDept_no();
            femployee.setDepartment(departamentoDAO.query().parallelStream().filter(d -> d.getDept_no().equals(depID)).collect(Collectors.toList()).get(0));
            int managerID = deptManagerDAO.query().parallelStream().filter(dm -> dm.getDept_no().equals(femployee.getDepartment().getDept_no())).collect(Collectors.toList()).get(0).getEmp_no();
            femployee.setManager(employeeDAO.query().parallelStream().filter(m -> m.getEmp_no() == managerID).collect(Collectors.toList()).get(0));
            out.println(femployee.toString() + "<br>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("</body>");
        out.println("</html>");
    }

}
