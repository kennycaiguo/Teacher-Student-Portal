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

public class showAllGrade extends HttpServlet {

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
            stmt = con.createStatement();
            query = "select * from grade";
            rs = stmt.executeQuery(query);
            insdata.clear();
            while (rs.next()) {

                insdata.add(rs.getString("GRADE"));
                insdata.add(rs.getString("STU_ID"));
                insdata.add(rs.getString("CLA_ID"));

            }

        } catch (SQLException e) {
            out.println("error from student edit");
        }
        request.setAttribute("showgrade", insdata);
        RequestDispatcher rd = request.getRequestDispatcher("showAllGrade.jsp");
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
