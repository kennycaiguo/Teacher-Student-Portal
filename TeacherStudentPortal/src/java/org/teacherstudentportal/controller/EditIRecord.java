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

public class EditIRecord extends HttpServlet {

    Connection con = methods.connectDB();
    ResultSet rs;
    String id, query;
    Statement stmt;
    List insdata = new ArrayList();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            id = request.getParameter("id");
            out.println(id);
            stmt = con.createStatement();
            query = "select * from instructor where INS_ID =" + id;
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                insdata.clear();
                insdata.add(rs.getString("INS_ID"));
                insdata.add(rs.getString("INS_FIRST_NAME"));
                insdata.add(rs.getString("INS_LAST_NAME"));
                insdata.add(rs.getString("INS_DOB"));
                insdata.add(rs.getString("INS_SEX"));
                insdata.add(rs.getString("INS_ADDRESS"));
                insdata.add(rs.getString("EMAIL"));
                insdata.add(rs.getString("INS_PHONE"));
                insdata.add(rs.getString("DEP_ID"));
            }

        } catch (SQLException e) {
            out.println("error from student edit");
        }
        request.setAttribute("EditIData", insdata);
        RequestDispatcher rd = request.getRequestDispatcher("editInsData.jsp");
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
