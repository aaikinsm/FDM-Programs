/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.26
 * Generated at: 2017-06-01 21:48:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createExam_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"\r\n");
      out.write("\tintegrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"\r\n");
      out.write("\tcrossorigin=\"anonymous\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\tfunction checkQInput(){\r\n");
      out.write("\t\tvar val = $(\"#question\").val()\r\n");
      out.write("\t\tif(val == \"\"){\r\n");
      out.write("\t\t\t$(\"#finalSubmit\").show()\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$(\"#finalSubmit\").hide()\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\tcheckQInput()\r\n");
      out.write("\t})\r\n");
      out.write("</script>\r\n");
      out.write("<title>Create Exam</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container well\" >\r\n");
      out.write("\r\n");
      out.write("\t\t\t<h3>Enter the exam information below</h3>\r\n");
      out.write("\t\t\t\t<h4 class=\"error\" id=\"eMsg\" style=\"color:red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorMsg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h4>\r\n");
      out.write("\t\t\t<form action=\"create\" method=\"post\" class=\"well\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"question\" name=\"question\" class=\"form-control\" placeholder=\"Question\" \r\n");
      out.write("\t\t\t\t\tonchange=\"checkQInput()\" onkeyup=\"checkQInput()\" onpaste=\"checkQInput()\" oninput=\"checkQInput()\" required />\r\n");
      out.write("\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"ansA\" class=\"form-control\" placeholder=\"Answer (a)\" required/>\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"ansB\" class=\"form-control\" placeholder=\"Answer (b)\" required/> \r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"ansC\" class=\"form-control\" placeholder=\"Answer (c)\" /> \r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"ansD\" class=\"form-control\" placeholder=\"Answer (d)\" /> \r\n");
      out.write("\t\t\t\tThe Correct Answer is: \r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"correct\" value=\"a\" checked> <strong>A</strong> &nbsp &nbsp\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"correct\" value=\"b\"> <strong>B</strong> &nbsp &nbsp\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"correct\" value=\"c\"> <strong>C</strong> &nbsp &nbsp\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"correct\" value=\"d\"> <strong>D</strong>  \r\n");
      out.write("\t\t\t\t<br/><br>\t\t\t\t\r\n");
      out.write("\t\t\t\t<center><button class=\"btn btn-primary\" type=\"submit\">Add Question</button></center>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<br/><br/>\r\n");
      out.write("\t\t\t<form action=\"create\" method=\"post\" id=\"finalSubmit\">\t\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"title\" class=\"form-control\" placeholder=\"Exam Title\" required/> \r\n");
      out.write("\t\t\t\t<input type=\"number\" min=\"1\" max=\"1000\" name=\"duration\" placeholder=\"Duration in minutes\" required/>\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"randomize\" value=\"true\"> Randomize Questions\t\r\n");
      out.write("\t\t\t\t<br/> <br/>\t\t\t\t\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\">Done</button>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}