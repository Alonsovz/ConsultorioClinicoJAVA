package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"images/home.png\"/>\n");
      out.write("        <script src=\"PushBar/js/jquery-3.3.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Utilidades/Alertas/js/sweetalert.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"Utilidades/Alertas/css/sweetalert.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Utilidades/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Utilidades/fonts/font-awesome-4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Utilidades/fonts/iconic/css/material-design-iconic-font.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Utilidades/css/util.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Utilidades/css/main.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        \n");
      out.write("     \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("\t<div class=\"limiter\">\n");
      out.write("\n");
      out.write("\t\t<div class=\"container-login100\" style=\"background-image: url('images/bg-01.jpg');\">\n");
      out.write("\t\t\t<div class=\"wrap-login100\">\n");
      out.write("\t\t\t\t<center><h1><font color=\"white\"><B>Clinica general</B></font></h1></center><br>\n");
      out.write("                                <form class=\"login100-form validate-form\" action=\"procesarLoguin\" method=\"POST\">\n");
      out.write("\t\t\t\t\t<span class=\"login100-form-logo\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<i class=\"zmdi zmdi-landsc\"><img src=\"images/loginIcon.png\" width=\"80px\" height=\"80px\"></i>\n");
      out.write("\t\t\t\t\t</span>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<span class=\"login100-form-title p-b-34 p-t-27\">\n");
      out.write("\t\t\t\t\t\tInicie Sesión\n");
      out.write("\t\t\t\t\t</span>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate = \"Enter username\">\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"txtUsuario\" placeholder=\"Usuario\">\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\" data-placeholder=\"&#xf207;\"></span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate=\"Enter password\">\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"password\" name=\"txtContra\" placeholder=\"Contraseña\">\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\" data-placeholder=\"&#xf191;\"></span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"contact100-form-checkbox\">\n");
      out.write("\t\t\t\t\t\t<input class=\"input-checkbox100\" id=\"ckb1\" type=\"checkbox\" name=\"remember-me\">\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"container-login100-form-btn\">\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" name=\"btnIngresar\" class=\"login100-form-btn\">\n");
      out.write("\t\t\t\t\t\t\tInicio\n");
      out.write("\t\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\t<div id=\"dropDownSelect1\"></div>\n");
      out.write("       \n");
      out.write("        \n");
      out.write("        \n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");

    HttpSession sesion=request.getSession();
    int nivel=0;
    if (request.getAttribute("nivel")!=null) 
    {
        nivel=(Integer)request.getAttribute("nivel");
        if (nivel==2) 
        {
            sesion.setAttribute("nombre",request.getAttribute("nombre"));
            sesion.setAttribute("nivel",nivel);
            response.sendRedirect("Menu.jsp");
        }
        if(request.getAttribute("data")!=null) {
                         out.print("<script>");
                         out.print("$(document).ready(function() {");
                         out.print("swal('DATOS ERRONEOS!','Ingresa nombre y contraseña validos','warning');");
                         out.print("});");
                         out.print("</script>");
                         
                          out.print("fdgsdag");
        }
    }
    if (request.getParameter("cerrar")!=null) 
    {
            sesion.invalidate();
            response.sendRedirect("index.jsp");
    }

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
