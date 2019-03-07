<%-- 
    Document   : Menu
    Created on : 08-nov-2018, 8:07:07
    Author     : Geo-Garcia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



        <title>Menu Principal</title>
        <link rel="icon" type="image/png" href="images/home.png"/>
        <script src="PushBar/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="Utilidades/Jquery/jquery-3.3.1.js" type="text/javascript"></script>

        <link href="Utilidades/css/reset.css" rel="stylesheet" type="text/css"/>
        <link href="Utilidades/css/style.css" rel="stylesheet" type="text/css"/>

        <script src="Utilidades/Boostrap/bootstrap.js" type="text/javascript"></script>
        <script src="Utilidades/Boostrap/script.js" type="text/javascript"></script>
        <link href="Utilidades/Boostrap/bootstrap.css" rel="stylesheet" type="text/css"/>



    </head>
    <!-- font-family: monospace !important;-->
    <%
        HttpSession sesion = request.getSession();
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma", "no-cache");

        if (sesion.getAttribute("nivel") == null) {
            response.sendRedirect("index.jsp");
        } else {
            String nivel = sesion.getAttribute("nivel").toString();
            if (!nivel.equals("2")) {
                response.sendRedirect("index.jsp");
            }
            request.setAttribute("nombre", sesion.getAttribute("nombre"));

        }

    %>
    <style>


        body {width: 99.9%; height: 100%;  position: absolute;}
        body::after {content: ""; background: url('images/fondocli.jpg'); width: 100%; height: 100%;opacity: 0.7; top: 0; left: 0; bottom: 0; right: 0;display: block; position: absolute; z-index: -1; }

        .contene {width: 100%; height: 100%; }
        .contene::after {content: "";  width: 100%;border-radius: 10px; height: 100%;background: url('images/fondocli1.jpg');opacity: 0.8; top: 0; left: 0; bottom: 0; right: 0;display: block; position: absolute; z-index: -1; }
        .h1,h2,h3,h4{color: black !important;}
    </style>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-2 ">    

                </div>
                <div class="col-md-6 ">    
                    <h1>Bienvenido al Sistema Clinico</h1>
                </div>
                <div class="col-md-2"></div>

                <div class="col-md-1">
                    <h5 class="pull-right">
                        <%= request.getAttribute("nombre")%>
                    </h5> 
                    
                </div>
                <div class="col-md-1">
                    <a href="index.jsp?cerrar=true">
                        <button class="btn btn-primary res">
                            <span class="glyphicon glyphicon-upload">
                                Cerrar Cessión
                        </button>
                    </a>
                </div>
            </div>

            <br><br><br><br><br><br>    
            <div class="row">
                <div class="col-md-3 contene">
                    <center>

                        <h2 class="parrafo">
                            Registrar <br> Citas!
                        </h2>

                        Ingresa Citas en el sistema para los pacientes que ya estan registrados previamente. Cada cita tendra 30 minutos.
                        <br><br>
                        <a href="cita.jsp">
                            <button class="btn btn-outline-primary res">
                                <span class="glyphicon glyphicon-upload">
                                    Citas
                            </button>
                        </a>
                        <br><br>
                    </center>
                </div>
                <div class="col-md-1 "></div>
                <div class="col-md-3 contene">
                    <center>

                        <h2 class="parrafo">
                            Registrar Expedientes!
                        </h2>
                        Para ingresar un expediente debes de tener un paciente sin documentación.

                        <br><br><br>
                        <a href="Expediente.jsp">
                            <button class="btn btn-outline-primary res">
                                <span class="glyphicon glyphicon-upload">
                                    Expediente
                            </button>
                        </a>
                        <br><br>
                    </center>
                </div>
                <div class="col-md-1 "></div>
                <div class="col-md-3 contene">
                    <center>

                        <h2 class="parrafo">
                            Registrar Pacientes!
                        </h2>
                        Podras ingresar pacientes pero luego tendras que asignarle un expediente.

                        <br><br><br>
                        <a href="paciente.jsp">
                            <button class="btn btn-outline-primary res">
                                <span class="glyphicon glyphicon-upload">
                                    Paciente
                            </button>
                        </a>
                        <br><br>
                    </center>
                </div>
                <br><br><br>
            </div>
        </div>
    </body>

</html>
