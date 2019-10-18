package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import static org.teacherstudentportal.controller.loginController.checklogin;

public final class instructor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Instructor</title>\n");
      out.write("        <link href=\"CSS.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"http:pure/pure-min.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function editIRecord(id) {\n");
      out.write("                url = \"insCallRecord\";\n");
      out.write("                window.location.href = \"http://localhost:8080/TeacherStudentPortal/\" + url + \"?id=\" + id;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            function showGrade(id) {\n");
      out.write("                url = \"showAllGrade\";\n");
      out.write("                window.location.href = \"http://localhost:8080/TeacherStudentPortal/\" + url + \"?id=\" + id;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <div class=\"top\">\n");
      out.write("            <h1>Teacher Student Portal</h1>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("\n");
      out.write("        <h2 align=\"center\">Hello ");
      out.print(checklogin.getUser());
      out.write("</h2>\n");
      out.write("        <div style=\"float: right\">\n");
      out.write("            ");
      out.print( new java.util.Date());
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"pure-menu pure-menu-open pure-menu-horizontal\">\n");
      out.write("            <ul>\n");
      out.write("                <li><a name=\"edit\" onclick=\"editIRecord(");
      out.print(checklogin.getInsid());
      out.write(");\">Update Profile</a></li>\n");
      out.write("                <li><a name=\"edit\" onclick=\"showGrade(null);\">View Grade</a></li>\n");
      out.write("\n");
      out.write("                <li><a href=\"login.jsp\">Logout</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <hr>\n");
      out.write("        <h2>\n");
      out.write("            Update your Profile<br>\n");
      out.write("            Update Student Grade\n");
      out.write("\n");
      out.write("        </h2>\n");
      out.write("        <hr>\n");
      out.write("        <br>\n");
      out.write("        <h2 style=\"padding-left:40px\">INSERT GRADE</h2>\n");
      out.write("        <br>\n");
      out.write("        <div style=\"position: relative;margin:auto;padding-left:40px\">\n");
      out.write("            <form action=\"insertGradeData\" method=\"post\">\n");
      out.write("                <table>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label>Grade :</label></td>\n");
      out.write("                        <td><input name=\"grade\" type=\"text\" size=\"25\" style=\"height:20px;\" id=\"user_name\" class=\"input\"/></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label>Student ID :</label> </td>          \n");
      out.write("                        <td><input name=\"sid\" type=\"text\"  id=\"user_pass\" class=\"input\" value=\"\" size=\"25\" style=\"height:20px;\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td><label>Class ID :</label> </td>          \n");
      out.write("                        <td><input name=\"cid\" type=\"text\"  id=\"user_pass\" class=\"input\" value=\"\" size=\"25\" style=\"height:20px;\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td><input type=\"reset\" value=\"Reset\"  class=\"pure-button pure-button-primary\"></td>\n");
      out.write("                        <td><input type=\"submit\" value=\"Submit\"  class=\"pure-button pure-button-primary\" onclick=\"validateform()\"></td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
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
