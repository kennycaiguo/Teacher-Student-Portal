package org.teacherstudentportal.controller;

import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.teacherstudentportal.entities.common;
import org.teacherstudentportal.methods.methods;

public class loginController extends HttpServlet {

    public static common checklogin = new common();
    public static methods method = new methods();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Connection con = methods.connectDB();
        
        checklogin.setEmail(request.getParameter("email"));
        checklogin.setPassword(request.getParameter("password"));
        checklogin.setRole(request.getParameter("role"));
        
        out.println(checklogin.getEmail());
        out.println(checklogin.getRole());
        out.println(checklogin.getPassword());
        
        String role = checklogin.getRole();
        
        String admin = "ADMINISTRATOR";
        String student = "student";
        String instructor = "instructor";

        Boolean isvalid = method.checkLogin(con, checklogin.getEmail(), checklogin.getPassword(), checklogin.getRole());

        if (isvalid) {

            if (admin.equals(role)) {
                try {
                    out.println("check");
                    response.sendRedirect("admin.jsp");
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (student.equals(role)) {
                try {
                    response.sendRedirect("student.jsp");
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (instructor.equals(role)) {
                try {
                    response.sendRedirect("instructor.jsp");
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            try {
                response.sendRedirect("loginError.jsp");
            } catch (IOException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
