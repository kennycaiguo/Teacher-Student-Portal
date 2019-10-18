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

public class updateStuData extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String ID, FNAME, LNAME, DOB, SEX, ADDRESS, EMAIL, PHONE, insid, depid;
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

            Connection con = methods.connectDB();

            Boolean isvalid = method.updateStuData(con, ID, FNAME, LNAME, DOB, SEX, ADDRESS, EMAIL, PHONE, insid, depid);

            if (isvalid) {
                response.sendRedirect("adminController?action=showallstudent");
            } else {
                response.sendRedirect("loginError.jsp");
            }

        } catch (IOException e) {
            out.println("error from updateStuData servelet");

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
