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

public class EditCRecord extends HttpServlet {

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
            query = "select * from course where COU_ID =" + id;
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                insdata.clear();
                insdata.add(rs.getString("COU_ID"));
                insdata.add(rs.getString("COU_TITLE"));
                insdata.add(rs.getString("COU_DESC"));
                insdata.add(rs.getString("COU_CREDIT"));

                out.println("from course");
            }

        } catch (SQLException e) {
            out.println("error from student edit");
        }
        request.setAttribute("EditCData", insdata);
        RequestDispatcher rd = request.getRequestDispatcher("editCouData.jsp");
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
