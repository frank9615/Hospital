<%@ page import="com.example.entity.User" %>
<%@ page import="com.example.model.Role" %>
<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 13/04/2022
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctor Panel</title>
    <%
        User user = (User) session.getAttribute("user");
        if(user == null || user.getRole() != Role.DOCTOR) {
            response.sendRedirect("/login.jsp");
        }
    %>
</head>
<body>

</body>
</html>
