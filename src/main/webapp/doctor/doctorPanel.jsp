<%@ page import="com.example.entity.User" %>
<%@ page import="com.example.model.Role" %>
<%@ page import="com.example.entity.Doctor" %>
<%@ page import="com.example.entity.Triage" %>
<%@ page import="com.example.entity.Patient" %>
<%@ page import="com.example.dao.UserDAO" %>
<%@ page import="org.hibernate.Hibernate" %>
<%@ page import="com.example.dao.TriageDAO" %>
<%@ page import="java.util.List" %>
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
        UserDAO userDAO = new UserDAO();
        Doctor doctor = userDAO.getDoctor(user.getId());

    %>
</head>
<body>

    <h1>Doctor Panel</h1>
    <h2>Welcome <%= doctor.getName() %> <%= doctor.getSurname() %></h2>
    <h3>Your ID: <%= doctor.getId() %></h3>
    <a href="/logout.jsp">Logout</a>

    <h3>Your Patients</h3>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Compleanno</th>
            <th>Triage Colore</th>
            <th>Triage Data</th>
            <th>Note dell'operatore</th>
        </tr>
        <%
            TriageDAO triageDAO = new TriageDAO();
            for(Triage triageRef : doctor.getTriages()) {
               Triage triage = triageDAO.getTriage(triageRef.getId());
               Patient patient = triage.getPatient();


        %>
        <tr>

            <td><%= patient.getId() %></td>
            <td><%= patient.getName() %></td>
            <td><%= patient.getSurname() %></td>

            <td><%= patient.getBirthday() %></td>
            <td><%= triage.getTriageDate() %></td>
            <td><%= triage.getTriageColor() %></td>
            <td><%= triage.getNotes() %></td>


        <tr>
        <%
            }
        %>
    </table>


</body>
</html>
