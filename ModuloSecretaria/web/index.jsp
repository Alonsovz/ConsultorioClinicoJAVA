<%-- 
    Document   : index
    Created on : 10-16-2018, 01:54:13 PM
    Author     : AndresL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="icon" type="image/png" href="images/home.png"/>
        <script src="PushBar/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="Utilidades/Alertas/js/sweetalert.min.js" type="text/javascript"></script>
        <link href="Utilidades/Alertas/css/sweetalert.css" rel="stylesheet" type="text/css"/>
        <link href="Utilidades/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="Utilidades/fonts/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="Utilidades/fonts/iconic/css/material-design-iconic-font.min.css" rel="stylesheet" type="text/css"/>
        <link href="Utilidades/css/util.css" rel="stylesheet" type="text/css"/>
        <link href="Utilidades/css/main.css" rel="stylesheet" type="text/css"/>
        
     
    </head>
    
    
	<div class="limiter">

		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100">
				<center><h1><font color="white"><B>Clinica general</B></font></h1></center><br>
                                <form class="login100-form validate-form" action="procesarLoguin" method="POST">
					<span class="login100-form-logo">

						<i class="zmdi zmdi-landsc"><img src="images/loginIcon.png" width="80px" height="80px"></i>
					</span>

					<span class="login100-form-title p-b-34 p-t-27">
						Inicie Sesión
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Enter username">
						<input class="input100" type="text" name="txtUsuario" placeholder="Usuario">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input class="input100" type="password" name="txtContra" placeholder="Contraseña">
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>

					<div class="contact100-form-checkbox">
						<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
						
					</div>

					<div class="container-login100-form-btn">
						<button type="submit" name="btnIngresar" class="login100-form-btn">
							Inicio
						</button>
					</div>

					
						
					
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
       
        
        


</body>
</html>

<%
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
%>