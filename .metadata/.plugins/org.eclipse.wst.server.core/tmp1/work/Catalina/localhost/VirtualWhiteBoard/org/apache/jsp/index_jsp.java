/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.26
 * Generated at: 2017-06-09 15:22:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/albert.mensah/JavaEclipseWorkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/VirtualWhiteBoard/WEB-INF/lib/spring-webmvc-4.2.6.RELEASE.jar!/META-INF/spring.tld", Long.valueOf(1462534132000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-4.2.6.RELEASE.jar", Long.valueOf(1486652910383L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody;

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
    _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.release();
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\"/>\n");
      out.write("\t\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/login.css\" />\n");
      out.write("\t\t<style type=\"text/css\">\n");
      out.write("\t\t@media screen and (min-width: 800px) {\n");
      out.write("\t\tbody{\t\t\n");
      out.write("\t\t\tbackground: url(resources/imgs/vw-whiteboard.png) \n");
      out.write("\t\t\tno-repeat;\n");
      out.write("\t\t\tbackground-size: 100%;\n");
      out.write("\t\t\tpadding: 25px;\n");
      out.write("\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t\t.mastfoot{\n");
      out.write("\t\t\tmargin-top: 75px;\n");
      out.write("\t\t}\n");
      out.write("\t\t.inner{\n");
      out.write("\t\t\ttext-align: center;\n");
      out.write("\t\t}\n");
      out.write("\t\t#line{\n");
      out.write("\t\t    animation-name: underlineAnim;\n");
      out.write("\t\t    animation-duration: 2s;\n");
      out.write("\t\t    margin-bottom: 75px;\n");
      out.write("\t\t}\n");
      out.write("\t\t#banner{\n");
      out.write("\t\t\tposition: relative;\n");
      out.write("\t\t    animation-name: bannerAnim;\n");
      out.write("\t\t    animation-duration: 2s;\n");
      out.write("\t\t    top:50px;\n");
      out.write("\t\t    left:10px;\n");
      out.write("\t\t    margin-bottom: 75px;\n");
      out.write("\t\t}\n");
      out.write("\t\t@keyframes bannerAnim {\n");
      out.write("\t\t    0%   {left:-500px; top:50px;}\n");
      out.write("\t\t    100% {left:10px; top:50px;}\n");
      out.write("\t\t}\n");
      out.write("\n");
      out.write("\t\t@keyframes underlineAnim {\n");
      out.write("\t\t    0%   {opacity: 0;}\n");
      out.write("\t\t    100% {opacity: 1}\n");
      out.write("\t\t}\n");
      out.write("\t\t</style>\n");
      out.write("\t\t<title>");
      if (_jspx_meth_s_005fmessage_005f0(_jspx_page_context))
        return;
      out.write("</title>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\n");
      out.write("\t\t<img id=\"banner\" alt=\"banner\" src=\"resources/imgs/vw-banner.png\">\n");
      out.write("\t\t\n");
      out.write("          \n");
      out.write("          <div class=\"inner cover\">\n");
      out.write("            <h1 class=\"cover-heading\">");
      if (_jspx_meth_s_005fmessage_005f1(_jspx_page_context))
        return;
      out.write("</h1>\n");
      out.write("            <p class=\"lead\">");
      if (_jspx_meth_s_005fmessage_005f2(_jspx_page_context))
        return;
      out.write("</p>\n");
      out.write("\t\t<img id=\"line\" alt=\"line\" src=\"resources/imgs/vw-underline1.png\">\n");
      out.write("            <p class=\"lead\">\n");
      out.write("              <a href=\"login\" class=\"btn btn-lg btn-primary\">");
      if (_jspx_meth_s_005fmessage_005f3(_jspx_page_context))
        return;
      out.write(' ');
      out.write('/');
      out.write(' ');
      if (_jspx_meth_s_005fmessage_005f4(_jspx_page_context))
        return;
      out.write("</a>\n");
      out.write("            </p>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("          <div class=\"mastfoot\">\n");
      out.write("            <div class=\"inner\">\n");
      out.write("              ");
      if (_jspx_meth_s_005fmessage_005f5(_jspx_page_context))
        return;
      out.write(": <a href=\"?language=en\">English</a>|<a href=\"?language=fr\">French</a>\n");
      out.write("              <p>");
      if (_jspx_meth_s_005fmessage_005f6(_jspx_page_context))
        return;
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("\t</body>\n");
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

  private boolean _jspx_meth_s_005fmessage_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_s_005fmessage_005f0 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_s_005fmessage_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fmessage_005f0.setParent(null);
    // /index.jsp(49,9) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f0.setCode("general.title");
    int[] _jspx_push_body_count_s_005fmessage_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_s_005fmessage_005f0 = _jspx_th_s_005fmessage_005f0.doStartTag();
      if (_jspx_th_s_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_s_005fmessage_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_s_005fmessage_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_s_005fmessage_005f0.doFinally();
      _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.reuse(_jspx_th_s_005fmessage_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fmessage_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_s_005fmessage_005f1 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_s_005fmessage_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fmessage_005f1.setParent(null);
    // /index.jsp(57,38) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f1.setCode("general.title");
    int[] _jspx_push_body_count_s_005fmessage_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_s_005fmessage_005f1 = _jspx_th_s_005fmessage_005f1.doStartTag();
      if (_jspx_th_s_005fmessage_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_s_005fmessage_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_s_005fmessage_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_s_005fmessage_005f1.doFinally();
      _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.reuse(_jspx_th_s_005fmessage_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fmessage_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_s_005fmessage_005f2 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_s_005fmessage_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005fmessage_005f2.setParent(null);
    // /index.jsp(58,28) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f2.setCode("general.slogan");
    int[] _jspx_push_body_count_s_005fmessage_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_s_005fmessage_005f2 = _jspx_th_s_005fmessage_005f2.doStartTag();
      if (_jspx_th_s_005fmessage_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_s_005fmessage_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_s_005fmessage_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_s_005fmessage_005f2.doFinally();
      _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.reuse(_jspx_th_s_005fmessage_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fmessage_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_s_005fmessage_005f3 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_s_005fmessage_005f3.setPageContext(_jspx_page_context);
    _jspx_th_s_005fmessage_005f3.setParent(null);
    // /index.jsp(61,61) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f3.setCode("login.login");
    int[] _jspx_push_body_count_s_005fmessage_005f3 = new int[] { 0 };
    try {
      int _jspx_eval_s_005fmessage_005f3 = _jspx_th_s_005fmessage_005f3.doStartTag();
      if (_jspx_th_s_005fmessage_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_s_005fmessage_005f3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_s_005fmessage_005f3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_s_005fmessage_005f3.doFinally();
      _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.reuse(_jspx_th_s_005fmessage_005f3);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fmessage_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_s_005fmessage_005f4 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_s_005fmessage_005f4.setPageContext(_jspx_page_context);
    _jspx_th_s_005fmessage_005f4.setParent(null);
    // /index.jsp(61,95) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f4.setCode("login.register");
    int[] _jspx_push_body_count_s_005fmessage_005f4 = new int[] { 0 };
    try {
      int _jspx_eval_s_005fmessage_005f4 = _jspx_th_s_005fmessage_005f4.doStartTag();
      if (_jspx_th_s_005fmessage_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_s_005fmessage_005f4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_s_005fmessage_005f4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_s_005fmessage_005f4.doFinally();
      _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.reuse(_jspx_th_s_005fmessage_005f4);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fmessage_005f5(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_s_005fmessage_005f5 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_s_005fmessage_005f5.setPageContext(_jspx_page_context);
    _jspx_th_s_005fmessage_005f5.setParent(null);
    // /index.jsp(67,14) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f5.setCode("general.changeLanguage");
    int[] _jspx_push_body_count_s_005fmessage_005f5 = new int[] { 0 };
    try {
      int _jspx_eval_s_005fmessage_005f5 = _jspx_th_s_005fmessage_005f5.doStartTag();
      if (_jspx_th_s_005fmessage_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_s_005fmessage_005f5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_s_005fmessage_005f5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_s_005fmessage_005f5.doFinally();
      _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.reuse(_jspx_th_s_005fmessage_005f5);
    }
    return false;
  }

  private boolean _jspx_meth_s_005fmessage_005f6(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_s_005fmessage_005f6 = (org.springframework.web.servlet.tags.MessageTag) _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_s_005fmessage_005f6.setPageContext(_jspx_page_context);
    _jspx_th_s_005fmessage_005f6.setParent(null);
    // /index.jsp(68,17) name = code type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fmessage_005f6.setCode("general.createdBy");
    int[] _jspx_push_body_count_s_005fmessage_005f6 = new int[] { 0 };
    try {
      int _jspx_eval_s_005fmessage_005f6 = _jspx_th_s_005fmessage_005f6.doStartTag();
      if (_jspx_th_s_005fmessage_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_s_005fmessage_005f6[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_s_005fmessage_005f6.doCatch(_jspx_exception);
    } finally {
      _jspx_th_s_005fmessage_005f6.doFinally();
      _005fjspx_005ftagPool_005fs_005fmessage_0026_005fcode_005fnobody.reuse(_jspx_th_s_005fmessage_005f6);
    }
    return false;
  }
}