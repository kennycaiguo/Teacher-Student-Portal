package org.teacherstudentportal.controller;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.teacherstudentportal.controller.loginController.checklogin;
import static org.teacherstudentportal.controller.loginController.method;
import org.teacherstudentportal.methods.methods;

public class studentContoller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("showgrades")) {
            Connection con = methods.connectDB();
            Boolean isvalid = method.checkGrade(con, checklogin.getStuid());
            if (isvalid == false) {
                response.sendRedirect("grade.jsp");
            }

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
