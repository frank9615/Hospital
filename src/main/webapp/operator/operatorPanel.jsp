<%@ page import="com.example.entity.User" %>
<%@ page import="com.example.model.Role" %>
<%@ page import="com.example.dao.UserDAO" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: SI2001
  Date: 13/04/2022
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Operator Panel</title>
    <%
        User user = (User) session.getAttribute("user");
        if(user == null || user.getRole() != Role.OPERATOR) {
            response.sendRedirect("/login.jsp");
        }
    %>
</head>
<body>
<h1>Operator Panel</h1>
    <h2>Welcome <%= user.getName() %></h2>
    <a href="/logout.jsp">Logout</a>

    <h3>Triage</h3>
<form action="<%= request.getContextPath() %>/TriageServlet" method="post">
    <table>
        <tr>
            <td>Codice Fiscale:</td>
            <td><input type="text" name="taxId" pattern="^[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$" required="required"></td>
        </tr>
        <tr>
            <td>Nome:</td>
            <td><input type="text" name="name" required="required"/></td>
        </tr>
        <tr>
            <td>Cognome:</td>
            <td><input type="text" name="surname" required="required"/></td>
        </tr>
        <tr>
            <td>Data di nascita :</td>
            <td><input type="date" name="birthday" required="required"/></td>
        </tr>
        <tr>
            <td>Codice colore :</td>
            <td>
                <select name="triageColor">
                    <option value="RED">Rosso</option>
                    <option value="YELLOW">Giallo</option>
                    <option value="GREEN">Verde</option>
                    <option value="WHITE">Bianco</option>
                    <option value="BLACK">Nero</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Assegna a :</td>
        <td>
            <select name="doctor">
                <%  UserDAO userDAO = new UserDAO();
                    List<User> doctors = userDAO.getDoctors();
                    for(User doctor : doctors) { %>
                        <option value="<%= doctor.getId() %>"><%= doctor.getName() %> <%= doctor.getSurname() %></option>
                    <% } %>
            </select>
        </td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Conferma"/></td>
        </tr>
    </table>
</form>





</body>
</html>
