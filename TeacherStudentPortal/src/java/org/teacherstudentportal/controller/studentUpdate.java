package org.teacherstudentportal.controller;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.teacherstudentportal.controller.loginController.method;
import org.teacherstudentportal.methods.methods;

public class studentUpdate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ID, FNAME, LNAME, DOB, SEX, ADDRESS, EMAIL, PHONE, insid, depid, password;
        ID = request.getParameter("id");
        FNAME = request.getParameter("fname");
        LNAME = request.getParameter("lname");
        DOB = request.getParameter("dob");
        SEX = request.getParameter("sex");
        ADDRESS = request.getParameter("address");
        EMAIL = request.getParameter("email");
        PHONE = request.getParameter("phone");
        insid = request.getParameter("insid");
        depid = request.getParameter("depid");
        password = request.getParameter("password");

        Connection con = methods.connectDB();

        Boolean isvalid = method.studentUpdData(con, ID, FNAME, LNAME, DOB, SEX, ADDRESS, EMAIL, PHONE, insid, depid, password);

        if (isvalid) {

            RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("loginError.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
