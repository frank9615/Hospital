package com.example.auth;

import com.example.dao.UserDAO;
import com.example.entity.User;
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
                switch(user.getRole()) {
                    case ADMIN:
                        response.sendRedirect("admin/adminPanel.jsp");
                        break;
                    case DOCTOR:
                        response.sendRedirect("doctor/doctorPanel.jsp");
                        break;
                    case OPERATOR:
                        response.sendRedirect("operator/operatorPanel.jsp");
                        break;
                    default:
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                        break;
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
