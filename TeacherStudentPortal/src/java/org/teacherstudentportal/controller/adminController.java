package org.teacherstudentportal.controller;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.teacherstudentportal.controller.loginController.method;
import org.teacherstudentportal.methods.methods;

public class adminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("showallstudent")) {
            Connection con = methods.connectDB();
            ResultSet stu;
            List studentdata = new ArrayList();
            try {
                Statement stmt = con.createStatement();
                String mySQL = "select * from student";
                stu = stmt.executeQuery(mySQL);
                while (stu.next()) {
                    studentdata.add(stu.getString("STU_ID"));
                    studentdata.add(stu.getString("STU_FIRST_NAME"));
                    studentdata.add(stu.getString("STU_LAST_NAME"));
                    studentdata.add(stu.getString("STU_DOB"));
                    studentdata.add(stu.getString("STU_SEX"));
                    studentdata.add(stu.getString("STU_ADDRESS"));
                    studentdata.add(stu.getString("EMAIL"));
                    studentdata.add(stu.getString("STU_PHONE"));
                    studentdata.add(stu.getString("INS_ID"));
                    studentdata.add(stu.getString("DEP_id"));

                }

            } catch (SQLException e) {
                out.println("error from if");

            }

            request.setAttribute("data", studentdata);
            RequestDispatcher rd = request.getRequestDispatcher("admindata.jsp");
            rd.forward(request, response);
        }

        if (action.equalsIgnoreCase("showdept")) {
            ResultSet ins;
            List instructordata = new ArrayList();
            Connection con1 = methods.connectDB();
            try {
                Statement inssmt = con1.createStatement();
                String mySQL = "select * from DEPARTMENT";
                ins = inssmt.executeQuery(mySQL);
                while (ins.next()) {

                    instructordata.add(ins.getString("DEP_ID"));
                    instructordata.add(ins.getString("DEP_NAME"));
                    out.println("ok1");
                }

            } catch (SQLException e) {

                out.println("error from if");

            }
            request.setAttribute("depdata", instructordata);
            RequestDispatcher rd = request.getRequestDispatcher("adminDepData.jsp");
            rd.forward(request, response);

        }

        if (action.equalsIgnoreCase("showallinstructor")) {
            ResultSet ins;
            List instructordata = new ArrayList();
            Connection con1 = method.connectDB();
            try {
                Statement inssmt = con1.createStatement();
                String mySQL = "select * from instructor";
                ins = inssmt.executeQuery(mySQL);
                while (ins.next()) {

                    instructordata.add(ins.getString("INS_ID"));
                    instructordata.add(ins.getString("INS_FIRST_NAME"));
                    instructordata.add(ins.getString("INS_LAST_NAME"));
                    instructordata.add(ins.getString("INS_DOB"));
                    instructordata.add(ins.getString("INS_SEX"));
                    instructordata.add(ins.getString("INS_ADDRESS"));
                    instructordata.add(ins.getString("EMAIL"));
                    instructordata.add(ins.getString("INS_PHONE"));
                    instructordata.add(ins.getString("DEP_ID"));
                    out.println("ok1");
                }

            } catch (SQLException e) {

                out.println("error from if");

            }
            request.setAttribute("insdata", instructordata);
            RequestDispatcher rd = request.getRequestDispatcher("adminInsData.jsp");
            rd.forward(request, response);

        }

        if (action.equalsIgnoreCase("showcourse")) {
            ResultSet ins;
            List instructordata = new ArrayList();
            Connection con1 = methods.connectDB();
            try {
                Statement inssmt = con1.createStatement();
                String mySQL = "select * from course";
                ins = inssmt.executeQuery(mySQL);
                while (ins.next()) {

                    instructordata.add(ins.getString("COU_ID"));
                    instructordata.add(ins.getString("COU_TITLE"));
                    instructordata.add(ins.getString("COU_DESC"));
                    instructordata.add(ins.getString("COU_CREDIT"));

                    out.println("ok1");
                }

            } catch (SQLException e) {

                out.println("error from if");

            }
            request.setAttribute("coudata", instructordata);
            RequestDispatcher rd = request.getRequestDispatcher("adminCouData.jsp");
            rd.forward(request, response);

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
