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

public class updateCouData extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String ID, title, desc, credit;
            ID = request.getParameter("cid");
            title = request.getParameter("ctitle");
            desc = request.getParameter("cdesc");
            credit = request.getParameter("ccredit");

            Connection con = methods.connectDB();

            Boolean isvalid = method.updateCouData(con, ID, title, desc, credit);

            if (isvalid) {
                response.sendRedirect("adminController?action=showcourse");
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
