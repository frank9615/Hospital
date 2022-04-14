package com.example.hospital;

import com.example.dao.PatientDAO;
import com.example.entity.Patient;

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
        Patient p = patientDAO.getPatient(cf);
        if(p == null) {
            p = new Patient(cf, name, surname, birthDateConverted, now);
            patientDAO.addPatient(p);
        }
        // Paziente registrato
        // FAse di triage





    }
}
