package com.example.hospital;

import com.example.dao.PatientDAO;
import com.example.dao.TriageDAO;
import com.example.dao.UserDAO;
import com.example.entity.*;
import com.example.model.TriageColor;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TriageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date now = new Date(); // current date
        // Patient data
        String cf = request.getParameter("taxId");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String birthday = request.getParameter("birthday");
        Date birthDateConverted = null;
        try {
            birthDateConverted = new SimpleDateFormat("yyyy-mm-dd").parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PatientDAO patientDAO = new PatientDAO();
        Patient patient = patientDAO.getPatient(cf);
        if(patient == null) {
            patient = new Patient(cf, name, surname, birthDateConverted, now);
            patientDAO.addPatient(patient);
        }

        String triageColor = request.getParameter("triageColor");
        String notes = request.getParameter("notes");
        String doctorId = request.getParameter("doctor");
        UserDAO userDAO = new UserDAO();
        Doctor doctor = (Doctor) userDAO.getUser(Long.parseLong(doctorId));
        HttpSession session = request.getSession();
        Operator operator = (Operator) session.getAttribute("user");
        Triage t = new Triage(patient, TriageColor.valueOf(triageColor), notes, now, doctor, operator);
        TriageDAO triageDAO = new TriageDAO();
        triageDAO.addTriage(t);





    }
}
