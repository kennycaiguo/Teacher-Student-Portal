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
import org.teacherstudentportal.methods.methods;

public class stuCallRecord extends HttpServlet {

    Connection con = methods.connectDB();
    ResultSet rs;
    String id, query;
    Statement stmt;
    List studentdata = new ArrayList();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            id = request.getParameter("id");
            out.println(id);
            stmt = con.createStatement();
            query = "select * from student where stu_id =" + id;
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                studentdata.clear();
                studentdata.add(rs.getString("STU_ID"));
                studentdata.add(rs.getString("STU_FIRST_NAME"));
                studentdata.add(rs.getString("STU_LAST_NAME"));
                studentdata.add(rs.getString("STU_DOB"));
                studentdata.add(rs.getString("STU_SEX"));
                studentdata.add(rs.getString("STU_ADDRESS"));
                studentdata.add(rs.getString("EMAIL"));
                studentdata.add(rs.getString("STU_PHONE"));
                studentdata.add(rs.getString("PASSWORD"));
                studentdata.add(rs.getString("INS_ID"));
                studentdata.add(rs.getString("DEP_ID"));

            }

        } catch (SQLException e) {
            out.println("error from student edit");
        }
        request.setAttribute("callStuData", studentdata);
        RequestDispatcher rd = request.getRequestDispatcher("callStuData.jsp");
        rd.forward(request, response);

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
