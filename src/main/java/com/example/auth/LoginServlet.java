package com.example.auth;

import com.example.dao.UserDAO;
import com.example.entity.User;
import com.example.model.Role;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUser(username, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                if (user.getRole().equals(Role.ADMIN)) {
                    response.sendRedirect("admin/adminPanel.jsp");
                } else if (user.getRole().equals(Role.OPERATOR)) {
                    response.sendRedirect("operator/operatorPanel.jsp");
                } else if (user.getRole().equals(Role.MEDICO)) {
                    response.sendRedirect("doctor/doctorPanel.jsp");
                } else {
                    //Role not set
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login.jsp");
    }
}
