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

public class insertInsData extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String ID, FNAME, LNAME, DOB, SEX, ADDRESS, EMAIL, PHONE, DEPID, PASSWORD;
        ID = request.getParameter("insid");
        FNAME = request.getParameter("insfname");
        LNAME = request.getParameter("inslname");
        DOB = request.getParameter("insdob");
        SEX = request.getParameter("inssex");
        ADDRESS = request.getParameter("insaddress");
        EMAIL = request.getParameter("insemail");
        DEPID = request.getParameter("insdepid");
        PASSWORD = request.getParameter("inspassword");
        PHONE = request.getParameter("insphone");
        Connection con = methods.connectDB();

        Boolean isvalid = method.insertInsData(con, ID, FNAME, LNAME, DOB, SEX, ADDRESS, EMAIL, PHONE, DEPID, PASSWORD);

        if (isvalid) {
            out.println("hiii from insertins");

            response.sendRedirect("adminController?action=showallinstructor");
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
