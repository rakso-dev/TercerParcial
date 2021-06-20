<%@ page import="Entities.Department" %>
<%@ page import="Entities.Dept_employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: oskarbeltranmagana
  Date: 19/06/21
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Departments</title>
</head>
<body>
<% List<Department> departments = (List<Department>) request.getAttribute("departments");
  String next = (String) request.getAttribute("nextp");
  for (Department d : departments){
    out.println("<a href=\"FullDepartment?id=" + d.getDept_no() + "\">" + d.getDept_no() + "," + d.getDept_name() + "</a> <br>");
  }
  if(next != null)
    out.println(next);
%>
  <form method="get" action="/TercerParcial/FullDepartment">
    Employee number <input type="text" name="id" placeholder="A123">
    <input type="submit" value="Submit">
</form>
</body>
</html>
