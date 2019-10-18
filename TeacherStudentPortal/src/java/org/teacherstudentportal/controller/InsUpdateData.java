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


public class InsUpdateData extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String ID,FNAME,LNAME,DOB,SEX,ADDRESS,EMAIL,PHONE,depid,password;
            ID=request.getParameter("id");
            FNAME=request.getParameter("fname");
            LNAME=request.getParameter("lname");
            DOB =request.getParameter("dob");
            SEX=request.getParameter("sex");
            ADDRESS=request.getParameter("address");
            EMAIL=request.getParameter("email");
            PHONE=request.getParameter("phone");
            depid=request.getParameter("depid");
             password=request.getParameter("password");
             Connection con = methods.connectDB();          
           
             Boolean isvalid=method.insUpdateData(con, ID,FNAME,LNAME,DOB,SEX,ADDRESS,EMAIL,PHONE,depid,password);
             
             if(isvalid){
         response.sendRedirect("instructor.jsp");
           }
           else{
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
