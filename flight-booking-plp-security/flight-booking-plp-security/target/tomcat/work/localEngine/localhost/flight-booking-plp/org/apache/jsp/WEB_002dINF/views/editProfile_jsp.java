package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(5);
    _jspx_dependants.add("/WEB-INF/tags/jquery.tag");
    _jspx_dependants.add("/WEB-INF/tags/style.tag");
    _jspx_dependants.add("/WEB-INF/tags/bootstrap.tag");
    _jspx_dependants.add("/WEB-INF/tags/menu.tag");
    _jspx_dependants.add("/WEB-INF/tags/footer.tag");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      if (_jspx_meth_mytags_005fjquery_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_mytags_005fstyle_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("  ");
      if (_jspx_meth_mytags_005fbootstrap_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write(" <div class=\"navbar navbar-inverse navbar-expand\">\r\n");
      out.write("            ");
      if (_jspx_meth_mytags_005fmenu_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("    <h4>Edit Profile</h4>\r\n");
      out.write("    <form method=\"post\" action=\"editProfile.htm\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col col-sm-1\">\r\n");
      out.write("                <label for=\"name\">Name:</label>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col col-sm-1\">\r\n");
      out.write("                <input type=\"hidden\" name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"  />\r\n");
      out.write("                <input disabled type=\"text\" name=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"  />\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col col-sm-1\">\r\n");
      out.write("                 <label for=\"age\">Age:</label>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col col-sm-1\">\r\n");
      out.write("                <input type=\"hidden\" max=\"100\" min=\"0\" name=\"age\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.age}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("                <input disabled type=\"number\" max=\"100\" min=\"0\" name=\"age\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.age}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col col-sm-1\">\r\n");
      out.write("                 <label for=\"emailId\">Email Id:</label>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col col-sm-1\">\r\n");
      out.write("                <input type=\"hidden\" name=\"emailId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.emailId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"  />\r\n");
      out.write("                <input type=\"hidden\" name=\"password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.password}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"  />\r\n");
      out.write("                <input disabled type=\"email\" name=\"emailId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.emailId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"  />\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col col-sm-1\">\r\n");
      out.write("                 <label for=\"address\">Address:</label>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col col-sm-1\">\r\n");
      out.write("                <input type=\"text\" name=\"personDetails.address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${person.personDetails.address}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" required />\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row m-2\">\r\n");
      out.write("            <div class=\"col col-sm-1\">\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col col-sm-1\">\r\n");
      out.write("                <input class=\"btn btn-primary\" type=\"submit\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col col-sm-1\">\r\n");
      out.write("                <input class=\"btn  btn-primary\" type=\"reset\" />\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("    <footer class=\"page-footer font-small blue pt-4\" style=\"margin-left:60px\">\r\n");
      out.write("    ");
      if (_jspx_meth_mytags_005ffooter_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    </footer>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_mytags_005fjquery_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mytags:jquery
    org.apache.jsp.tag.web.jquery_tag _jspx_th_mytags_005fjquery_005f0 = new org.apache.jsp.tag.web.jquery_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_mytags_005fjquery_005f0);
    _jspx_th_mytags_005fjquery_005f0.setJspContext(_jspx_page_context);
    _jspx_th_mytags_005fjquery_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_mytags_005fjquery_005f0);
    return false;
  }

  private boolean _jspx_meth_mytags_005fstyle_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mytags:style
    org.apache.jsp.tag.web.style_tag _jspx_th_mytags_005fstyle_005f0 = new org.apache.jsp.tag.web.style_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_mytags_005fstyle_005f0);
    _jspx_th_mytags_005fstyle_005f0.setJspContext(_jspx_page_context);
    _jspx_th_mytags_005fstyle_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_mytags_005fstyle_005f0);
    return false;
  }

  private boolean _jspx_meth_mytags_005fbootstrap_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mytags:bootstrap
    org.apache.jsp.tag.web.bootstrap_tag _jspx_th_mytags_005fbootstrap_005f0 = new org.apache.jsp.tag.web.bootstrap_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_mytags_005fbootstrap_005f0);
    _jspx_th_mytags_005fbootstrap_005f0.setJspContext(_jspx_page_context);
    _jspx_th_mytags_005fbootstrap_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_mytags_005fbootstrap_005f0);
    return false;
  }

  private boolean _jspx_meth_mytags_005fmenu_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mytags:menu
    org.apache.jsp.tag.web.menu_tag _jspx_th_mytags_005fmenu_005f0 = new org.apache.jsp.tag.web.menu_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_mytags_005fmenu_005f0);
    _jspx_th_mytags_005fmenu_005f0.setJspContext(_jspx_page_context);
    _jspx_th_mytags_005fmenu_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_mytags_005fmenu_005f0);
    return false;
  }

  private boolean _jspx_meth_mytags_005ffooter_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mytags:footer
    org.apache.jsp.tag.web.footer_tag _jspx_th_mytags_005ffooter_005f0 = new org.apache.jsp.tag.web.footer_tag();
    org.apache.jasper.runtime.AnnotationHelper.postConstruct(_jsp_annotationprocessor, _jspx_th_mytags_005ffooter_005f0);
    _jspx_th_mytags_005ffooter_005f0.setJspContext(_jspx_page_context);
    _jspx_th_mytags_005ffooter_005f0.doTag();
    org.apache.jasper.runtime.AnnotationHelper.preDestroy(_jsp_annotationprocessor, _jspx_th_mytags_005ffooter_005f0);
    return false;
  }
}
