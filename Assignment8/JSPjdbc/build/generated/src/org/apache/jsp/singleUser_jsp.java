package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import bean.userBean;
import user.userd;

public final class singleUser_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       <form method=\"POST\" action='userHandler' name=\"frmAddUser\">\n");
      out.write("\t\t<input type=\"hidden\" name=\"action\" value=\"show\" />\n");
      out.write("\t\t<p>\n");
      out.write("\t\t\t<b>Find User by Id</b>\n");
      out.write("\t\t</p>\n");
      out.write("\t\t<table>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td>User ID</td>\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"userid\" /></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td></td>\n");
      out.write("\t\t\t\t<td><input type=\"submit\" value=\"Submit\" /></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("                ");

		//UserBean user = new UserBean();
		userd dao = new userd();
		userBean user = dao.getUserById(Integer.parseInt(request.getParameter("4")));
		//Iterator<UserBean> itr = userList.iterator();
	
      out.write("\n");
      out.write("\t<table border=\"1\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<th>Id</th>\n");
      out.write("\t\t\t<th>First Name</th>\n");
      out.write("\t\t\t<th>Last Name</th>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(user.getId());
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(user.getfName());
      out.write("</td>\n");
      out.write("\t\t\t<td>");
      out.print(user.getlName());
      out.write("</td>\n");
      out.write("\t\t\t<td><a\n");
      out.write("\t\t\t\thref=\"userHandler?action=editform&userId=");
      out.print(user.getId());
      out.write("\">Update</a></td>\n");
      out.write("\t\t\t<td><a href=\"userHandler?action=delete&userId=");
      out.print(user.getId());
      out.write("\">Delete</a></td>\n");
      out.write("\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t\n");
      out.write("\t</table>\n");
      out.write("\t<p>\n");
      out.write("\t\t<a href=\"userHandler?action=insert\">Add User</a>\n");
      out.write("\t</p>\n");
      out.write("\t</form>\n");
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
