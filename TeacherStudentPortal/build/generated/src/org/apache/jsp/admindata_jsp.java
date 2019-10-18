package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Iterator;
import static org.teacherstudentportal.methods.methods.student;
import java.util.ArrayList;

public final class admindata_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Data</title>\n");
      out.write("        <link href=\"CSS.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"http:pure/pure-min.css\">\n");
      out.write("        \n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function editSRecord(id){\n");
      out.write("                url=\"EditSRecord\";\n");
      out.write("                window.location.href=\"http://localhost:8080/TeacherStudentPortal/\"+url+\"?id=\"+id;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("            function editSDelete(id){\n");
      out.write("                url=\"DeleteSRecord\";\n");
      out.write("                window.location.href=\"http://localhost:8080/TeacherStudentPortal/\"+url+\"?id=\"+id;\n");
      out.write("           \n");
      out.write("    }\n");
      out.write("        </script>\n");
      out.write("        <div class=\"top\">\n");
      out.write("            <h1>Student Details</h1>\n");
      out.write("        </div>\n");
      out.write("        <div style=\"float: right\">\n");
      out.write("        ");
      out.print( new java.util.Date());
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"pure-menu pure-menu-open pure-menu-horizontal\">\n");
      out.write("        <ul>\n");
      out.write("            <li><a href=\"admin.jsp\">Home</a></li>\n");
      out.write("            <li><a href=\"login.jsp\">Logout</a></li>\n");
      out.write("            \n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("        <hr>\n");
      out.write("        <h1>\n");
      out.write("            Table Represent Student Records\n");
      out.write("        </h1><hr>\n");
      out.write("        <table class=\"pure-table pure-table-horizontal\" style=\"font-size: 13px\">\n");
      out.write("            <thead align=\"center\">\n");
      out.write("            <td>ID</td>\n");
      out.write("            <td>FIRST NAME</td>\n");
      out.write("            <td>LAST NAME</td>\n");
      out.write("            <td>DOB</td>\n");
      out.write("            <td>SEX</td>\n");
      out.write("            <td>ADDRESS</td>\n");
      out.write("            <td>EMAIL</td>\n");
      out.write("            <td>Phone</td>\n");
      out.write("            <td>Instructor ID</td>\n");
      out.write("            <td>Department ID</td>\n");
      out.write("           \n");
      out.write("            <td>Edit</td>\n");
      out.write("            <td>delete</td>\n");
      out.write("        </thead>\n");
      out.write("        ");
 Iterator stu;
      out.write("\n");
      out.write("        ");
List studentData = (List) request.getAttribute("data");
        for(stu = studentData.iterator(); stu.hasNext();){
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("        \n");
      out.write("            ");
 String s=(String) stu.next();
      out.write("\n");
      out.write("\n");
      out.write("            \n");
      out.write("            <td>");
      out.print(s);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(stu.next());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(stu.next());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(stu.next());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(stu.next());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(stu.next());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(stu.next());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(stu.next());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(stu.next());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(stu.next());
      out.write("</td>\n");
      out.write("            \n");
      out.write("            <td><input type =\"submit\" value=\"Edit\" name=\"edit\" onclick=\"editSRecord(");
      out.print(s);
      out.write(");\" class=\"pure-button pure-button-primary\"></td>\n");
      out.write("            <td><input type =\"submit\" value=\"Delete\" name=\"delete\" onclick=\"editSDelete(");
      out.print(s);
      out.write(");\" class=\"pure-button pure-button-primary\"></td>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </tr>    \n");
      out.write("    </table>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        \n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
