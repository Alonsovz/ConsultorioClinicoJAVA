<%-- 
    Document   : cita
    Created on : 10-09-2018, 10:05:06 PM
    Author     : Emerson Sibrian
--%>

<%@page import="java.util.Calendar"%>
<%@page import="com.modelo.Cita"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.Paciente"%>
<%@page import="com.modelo.Paciente"%>
<%@page import="com.modelo.DaoCita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CITA</title>
        <link rel="icon" type="image/png" href="images/citas.png"/>
        <script src="PushBar/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="Utilidades/Jquery/jquery-3.3.1.js" type="text/javascript"></script>
        <!--<script src="js/jquery-3.3.1.js" type="text/javascript"></script>-->
        <!-- Agregue la una fuente css para el tipo de letra-->
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400" rel="stylesheet">
        <!--  -->

        <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700' rel='stylesheet' type='text/css'>

        <script src="https://cdn.datatables.net/colreorder/1.4.1/js/dataTables.colReorder.min.js"></script>
        <script src="https://cdn.datatables.net/responsive/2.2.0/js/dataTables.responsive.min.js"></script>
        <script src="https://cdn.datatables.net/responsive/2.2.0/js/responsive.bootstrap4.min.js"></script>
        <script src="Utilidades/Boostrap/dataTables.bootstrap4.js" type="text/javascript"></script>
        <link href="Utilidades/Boostrap/dataTables.bootstrap4.css" rel="stylesheet" type="text/css"/>
        <script src="Utilidades/Boostrap/datatables.js" type="text/javascript"></script>



        <script src="Utilidades/Boostrap/bootstrap.js" type="text/javascript"></script>
        <script src="Utilidades/Boostrap/script.js" type="text/javascript"></script>
        <link href="Utilidades/Boostrap/bootstrap.css" rel="stylesheet" type="text/css"/>

        <script src="Utilidades/Alertas/js/sweetalert.min.js" type="text/javascript"></script>
        <link href="Utilidades/Alertas/css/sweetalert.css" rel="stylesheet" type="text/css"/>

        <link href="PushBar/css/pushbar.css" rel="stylesheet" type="text/css"/>
        <link href="PushBar/css/estilos.css" rel="stylesheet" type="text/css"/>
        <script>
            $(document).ready(function () {
                $("#nuevo").on("click", function () {
                    $("#nuevaPersona").modal({keyboard: false});
                });


                $("#paciente").on("click", function () {
                    $("#nuevaPersona1").modal({keyboard: false});
                });
            });
        </script>

        <script lang="JavaScript">
            function cargar(idCita, paciente, fecha, hora, estado, comentarios)
            {
                $('document').ready(function () {
                    $('#nuevaPersona1').modal();
                });
                document.frmCita.txtIdCita.value = idCita;
                document.frmCita.selectPaciente.value = paciente;
                document.frmCita.txtFecha.value = fecha;
                document.frmCita.txtHora.value = hora;


            }
        </script>
        <%            //out.print(fecha);
            if (request.getAttribute("msj") != null) {
                //out.print(request.getAttribute("msjs"));

                //out.print(request.getAttribute("msjss"));
                //out.print(request.getAttribute("msjjs"));
                if (request.getAttribute("msj").equals("errorDate")) {
                    out.print("<script>");
                    out.print("$(document).ready(function() {");
                    out.print("swal('Error en la Fechas!','Fecha de la cita invalida','warning');");
                    out.print("});");
                    out.print("</script>");

                }
                if (request.getAttribute("msj").equals("Repetida")) {
                    out.print("<script>");
                    out.print("$(document).ready(function() {");
                    out.print("swal('Lo sentimos!','Ya hay una cita en esta hora','warning');");
                    out.print("});");
                    out.print("</script>");

                }
                if (request.getAttribute("msj").equals("Repetidas")) {
                    out.print("<script>");
                    out.print("$(document).ready(function() {");
                    out.print("swal('Lo sentimos!','Ya hay citas programadas en ese lapso','warning');");
                    out.print("});");
                    out.print("</script>");

                }
                if (request.getAttribute("msj").equals("Incorrecto")) {
                    out.print("<script>");
                    out.print("$(document).ready(function() {");
                    out.print("swal('Hora invalida!','Ingrese una hora Valida','warning');");
                    out.print("});");
                    out.print("</script>");

                }
                if (request.getAttribute("msj").equals("Modi")) {
                    out.print("<script>");
                    out.print("$(document).ready(function() {");
                    out.print("swal('Realizado!','Datos Modificados!','success');");
                    out.print("});");
                    out.print("</script>");

                }
                if (request.getAttribute("msj").equals("Eli")) {
                    out.print("<script>");
                    out.print("$(document).ready(function() {");
                    out.print("swal('Realizado!','Datos Eliminados!','success');");
                    out.print("});");
                    out.print("</script>");
                }

                if (request.getAttribute("msj").equals("Ingresado")) {
                    out.print("<script>");
                    out.print("$(document).ready(function() {");
                    out.print("swal('Realizado!','Ingresado correctamente','success');");
                    out.print("});");
                    out.print("</script>");

                }

                /*out.print("<script>");
                         out.print("$(document).ready(function() {");
                         out.print("swal('Lo sentimos!','" +request.getAttribute("msj")+"','success');");
                         out.print("});");
                         out.print("</script>");*/
            }
            //out.print("<script lang='JavaScript'>swal('Acciones Realizadas!');</script>");
            //'Acciones Realizadas!','+" <%= request.getAttribute('msj') + "','success'

        %>

        <style>
            body {width: 99.9%; height: 100%;  position: absolute;}
            body::after {content: ""; background: url('images/fondocli2.jpg'); width: 100%; height: 100%;opacity: 0.6; top: 0; left: 0; bottom: 0; right: 0;display: block; position: absolute; z-index: -1; }
        </style>
    </head>
    <%
        DaoCita daoCit = new DaoCita();
    %>
</head>
<body class="container-fluid"><!--background-image: url('images/bg-01.jpg');-->

<center>
    <br>
    <!-- Agregue un nav-->
    <nav>
        <!--  Y un div para el boton-->    
        <div class="row container-fluid">
            <br>
            <br>                  
            <!-- Clase para alinear boton a la derecha --><!-- clase para mandar a llamar el css del boton -->

            <div class="col-md-2 pull-left"><button class="btn btn-primary pull-left" data-pushbar-target="pushbar-menu">Desplegar Menu &twoheadrightarrow;</button>&nbsp;</div>
            <div class="col-md-6 pull-right" style="color: #000;"><h1><b>Gestión de Citas</b></h1></div>
        </div>
        <br>
    </nav>
    <!-- Clearfix para limpiar el area del boton -->
    <div class="clearfix"></div> 
    <!--  termina codigo de boton-->
    <div class="modal fade" id="nuevaPersona" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">

                    <h1 style="font-size: 25px"><font color="#b2ecf7"><span class="glyphicon glyphicon-user"></span></font>Registro de Citas</h1>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <form action="procesarCita" name="frmCit" method="post">

                            <div class="row">

                                <input type="hidden" name="txtIdCita" min="1" class="form-control">

                                <div class="col-md-4">
                                    Paciente:

                                    <select name="selectPaciente" class="form-control">
                                        <%                                List<Paciente> lstPv = daoCit.listarPacientes();

                                            for (Paciente p : lstPv) {
                                        %>
                                        <option value="<%=p.getIdPaciente()%>"><%=p.getNombre()%></option>
                                        <%
                                            }
                                        %>           
                                    </select> 
                                </div>
                                <div class="col-md-4">
                                    Fecha:

                                    <input type="date" name="txtFecha" class="form-control">
                                </div>
                                <div class="col-md-4">
                                    Hora:

                                    <input type="time" name="txtHora" class="form-control">
                                </div>
                            </div>



                            <BR>             
                            <input type="submit" value="INSERTAR" name="btnInsertar" class="btn btn-success">


                            <input type="reset" value="LIMPIAR" name="btnLimpiar" class="btn btn-info">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<div class="modal fade" id="nuevaPersona1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">

                <h1 style="font-size: 25px"><font color="#b2ecf7"><span class="glyphicon glyphicon-user"></span></font>Registro de Expedientes</h1>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

                <form action="procesarCita" name="frmCita" method="post">
                    <div class="container">
                        <div class="row">

                            <input type="hidden" name="txtIdCita"  class="form-control">

                            <div class="col-md-4">
                                Paciente:

                                <select name="selectPaciente" class="form-control">
                                    <%
                                        List<Paciente> lstP = daoCit.listarPacientes();

                                        for (Paciente p : lstP) {
                                    %>
                                    <option value="<%=p.getIdPaciente()%>"><%=p.getNombre()%></option>
                                    <%
                                        }
                                    %>           
                                </select> 
                            </div>
                            <div class="col-md-4">
                                Fecha:

                                <input type="date" name="txtFecha" class="form-control">
                            </div>
                            <div class="col-md-4">
                                Hora:

                                <input type="time" name="txtHora" class="form-control">
                            </div>
                        </div>



                        <BR>             

                        <input type="submit" value="MODIFICAR" name="btnModificar" onclick="return confirm('Desea Modificar a la persona?')" class="btn btn-warning">
                        <input type="submit" value="ELIMINAR" name="btn" onclick="return confirm('Desea Eliminar a la persona?')" class="btn btn-danger">
                        <input type="reset" value="LIMPIAR" name="btnLimpiar" class="btn btn-info">
                        </form>
                    </div>
            </div>
        </div>
    </div>
</div>

<!--  A este div se le asigna un ID "pushbar-menu" y se crea una una ID para llamar al css "pushbar from_left" otro ID css -> pushbar-menu" -->     
<div data-pushbar-id="pushbar-menu" class="pushbar from_left pushbar-menu">
    <!-- Css para el boton de cerrar del pushbar-->
    <div class="btn-cerrar izquierda">
        <!-- Boton con evanto cerrar -->        
        <button data-pushbar-close><i class="fas fa-times"></i></button>
    </div> 
    <!--El menu con nav para llamar las tablas -->
    <nav class="menu">
        <a href="Menu.jsp"><b>Menu Principal</b></a>
        <a href="Expediente.jsp"><b>Gestion de Expedientes</b></a>
        <a href="paciente.jsp"><b>Gestion de Pacientes</b></a>
        <a href="index.jsp?cerrar=true"><b>Cerrar Sesion</b></a>
        <!--<a href="http://localhost:8080/SistemaFacturacionMini/Factura.jsp"><b>Gestion de facturas</b></a>-->
    </nav>
</div>                                

<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4"></div>
    <div class="col-md-1"></div>

    <div class="col-md-2">
        <button class="btn btn-primary" id="nuevo" style="width: 170px; height: 40px;">
            <span class="glyphicon glyphicon-list-alt"></span> Nuevo Cita
        </button>  
    </div>


</div>



<br>
<div class="container">
    <table class=" table  table-bordered datos" style="background-color: #7996c4;">
        <thead>
            <tr>
                <th>Id cita</th>
                <th>id Paciente</th>
                <td>Nombre</td>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Estado</th>
                <th>Comentarios</th>
                <th>Seleccionar</th>
            </tr>
        </thead>
        <tbody>    
            <%
                List<Cita> lst = daoCit.mostrarCita();
                for (Cita cit : lst) {
            %>
            <tr>
                <td><%=cit.getIdCita()%></td>
                <td><%=cit.getPaciente().getIdPaciente()%></td>
                <td><%=cit.getPaciente().getNombre()%></td>

                <td><%=cit.getFecha()%></td>
                <td><%=cit.getHora()%></td>
                <td><%=cit.getEstado()%></td>
                <td><%=cit.getComentarios()%></td>


                <td><a href="javascript:cargar(<%=cit.getIdCita()%>,<%=cit.getPaciente().getIdPaciente()%>,'<%=cit.getFecha()%>','<%=cit.getHora()%>')">
                        <button class="btn btn-primary res" style="background-color: white; color: black">
                            <span class="glyphicon glyphicon-upload">
                                Seleccionar</button>
            </tr>    
            <%
                }
            %>
        </tbody>
    </table>
    <!-- Tibreria para estilos de boton-->        
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>      
    <!-- Llamamos libreria pushbar.js que creamos en carpeta PushBar-->
    <script src="PushBar/js/pushbar.js" type="text/javascript"></script>
    <!-- Inicializamos el ID pushbar para que todo funcione con un evento -->
    <script>
                            var pushbar = new Pushbar({
                                blur: true,
                                overlay: true
                                  });
    </script>
    </body>
    </html>
