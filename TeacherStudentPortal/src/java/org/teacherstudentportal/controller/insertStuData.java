package org.teacherstudentportal.controller;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.teacherstudentportal.controller.loginController.method;
import org.teacherstudentportal.methods.methods;

public class insertStuData extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String SID, FNAME, LNAME, DOB, SEX, ADDRESS, EMAIL, PHONE, INSID, DEPID, PASSWORD;
        SID = request.getParameter("sid");
        INSID = request.getParameter("insid");
        FNAME = request.getParameter("insfname");
        LNAME = request.getParameter("inslname");
        DOB = request.getParameter("insdob");
        SEX = request.getParameter("inssex");
        ADDRESS = request.getParameter("insaddress");
        EMAIL = request.getParameter("insemail");
        PHONE = request.getParameter("insphone");
        DEPID = request.getParameter("insdepid");
        PASSWORD = request.getParameter("inspassword");

        Connection con = methods.connectDB();
        Boolean isvalid = method.insertStuData(con, SID, FNAME, LNAME, DOB, SEX, ADDRESS, EMAIL, PHONE, INSID, DEPID, PASSWORD);

        if (isvalid) {
            out.println("hiii from insertstu");
            response.sendRedirect("adminController?action=showallstudent");
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
