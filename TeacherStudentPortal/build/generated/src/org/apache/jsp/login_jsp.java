package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Teacher Student Portal</title>\n");
      out.write("        <link href=\"CSS.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"pure/pure-min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function validateform()\n");
      out.write("            {\n");
      out.write("                var name = document.loginform.user_name.value;\n");
      out.write("                var password = document.loginform.user_pass.value;\n");
      out.write("\n");
      out.write("                if (name === = null || \"\") {\n");
      out.write("                    alert(\"Username cannot be left Blank\");\n");
      out.write("                    form.document.focus;\n");
      out.write("                    return false;\n");
      out.write("                } else if (password === null || \"\") {\n");
      out.write("                    alert(\"Please Enter Password\");\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>     \n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"top\"> \n");
      out.write("            <h1>Welcome to Teacher Student Portal</h1>    \n");
      out.write("        </div>\n");
      out.write("        <div id=\"login\">\n");
      out.write("            <div id=\"error\">\n");
      out.write("\n");
      out.write("                <h2>Teacher Student Portal</h2>\n");
      out.write("                <hr>\n");
      out.write("            </div>\n");
      out.write("            <form name=\"loginform\" id=\"login-form\" action=\"loginController\" method=\"post\">\n");
      out.write("                <p>\n");
      out.write("                    <label>Select Role :\n");
      out.write("                        <select name=\"role\">\n");
      out.write("                            <option value=\"ADMINISTRATOR\">Administrator</option>\n");
      out.write("                            <option value=\"instructor\">Instructor</option>\n");
      out.write("                            <option value=\"student\">Student</option>\n");
      out.write("                        </select>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("                <p>\n");
      out.write("                    <label>User Email:\n");
      out.write("                        <input type=\"email\" size=\"25\" style=\"height:20px\" id=\"user_name\" class=\"input\" name=\"email\"/></label>\n");
      out.write("                </p>\n");
      out.write("                <p>\n");
      out.write("                    <label>Password :\n");
      out.write("                        <input type=\"password\" name=\"password\" id=\"user_pass\" class=\"input\" value=\"\" size=\"25\" style=\"height: 20px;\" /></label>\n");
      out.write("                </p>\n");
      out.write("                <p>\n");
      out.write("                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"reset\" value=\"Reset\" class=\"pure-button pure-button-primary\"/> \n");
      out.write("                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"submit\" value=\"Login\" onclick=\"validateform();\"class=\"pure-button pure-button-primary\"/>\n");
      out.write("\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <hr>\n");
      out.write("        <p align=\"center\">&COPY; &nbsp;Teacher Student Portal 2019</p>\n");
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
