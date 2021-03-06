package org.teacherstudentportal.controller;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.teacherstudentportal.controller.loginController.method;
import org.teacherstudentportal.methods.methods;

public class insertCouData extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String cid, ctitle, cdesc, ccredit, depid;
        cid = request.getParameter("cid");
        ctitle = request.getParameter("ctitle");
        cdesc = request.getParameter("cdesc");
        ccredit = request.getParameter("ccredit");
        depid = request.getParameter("depid");
        Connection con = methods.connectDB();
        Boolean isvalid = method.insertCouData(con, cid, ctitle, cdesc, ccredit, depid);

        if (isvalid) {
            response.sendRedirect("adminController?action=showcourse");
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
