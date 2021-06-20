<%--
  Created by IntelliJ IDEA.
  User: oskarbeltranmagana
  Date: 19/06/21
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, Entities.Employee"  %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
  <% List<Employee> employees = (List<Employee>) request.getAttribute("employees");
      String next = (String) request.getAttribute("nextp");
      for (Employee e : employees){
        out.println("<a href=\"FullEmployee?id=" + e.getEmp_no() + "\">" + e.getEmp_no() + "," + e.getLast_name() + "," + e.getFirst_name() + "</a> <br>");
      }
      if(next != null)
          out.println(next);
  %>
    <form method="get" action="/TercerParcial/FullEmployee">
        Employee number <input type="text" name="id" placeholder="123">
        <input type="submit" value="Submit">
    </form>
</body>
</html>
