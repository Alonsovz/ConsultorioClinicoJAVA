<%-- 
    Document   : paciente
    Created on : 10-09-2018, 09:47:30 PM
    Author     : AndresL
--%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.Paciente"%>
<%@page import="com.modelo.DaoPaciente"%>
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
        <title>Paciente</title>
        <link rel="icon" type="image/jpg" href="images/paciente.jpg"/>
        <script src="PushBar/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="Utilidades/Jquery/jquery-3.3.1.js" type="text/javascript"></script>


        <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700' rel='stylesheet' type='text/css'>

        <script src="https://cdn.datatables.net/colreorder/1.4.1/js/dataTables.colReorder.min.js"></script>
        <script src="https://cdn.datatables.net/responsive/2.2.0/js/dataTables.responsive.min.js"></script>
        <script src="https://cdn.datatables.net/responsive/2.2.0/js/responsive.bootstrap4.min.js"></script>
        <script src="Utilidades/Boostrap/dataTables.bootstrap4.js" type="text/javascript"></script>
        <link href="Utilidades/Boostrap/dataTables.bootstrap4.css" rel="stylesheet" type="text/css"/>
        <script src="Utilidades/Boostrap/datatables.js" type="text/javascript"></script>
        <script src="Utilidades/css/modernizr.js" type="text/javascript"></script>
        <link href="Utilidades/css/reset.css" rel="stylesheet" type="text/css"/>
        <link href="Utilidades/css/style.css" rel="stylesheet" type="text/css"/>

        <script src="Utilidades/Boostrap/bootstrap.js" type="text/javascript"></script>
        <script src="Utilidades/Boostrap/script.js" type="text/javascript"></script>
        <link href="Utilidades/Boostrap/bootstrap.css" rel="stylesheet" type="text/css"/>

        <link href="PushBar/css/pushbar.css" rel="stylesheet" type="text/css"/>
        <link href="PushBar/css/estilos.css" rel="stylesheet" type="text/css"/>

        <script Languaje='JavaScript'>
            function cargar(idpac, nombre, domic, tel, fechnac, estado, user, contra)
            {
                $('document').ready(function () {
                    $('#nuevaPersona1').modal();
                });
                document.frmPaciente.txtIdpaciente.value = idpac;
                document.frmPaciente.txtNombre.value = nombre;
                document.frmPaciente.txtDomicilio.value = domic;
                document.frmPaciente.txtTelefono.value = tel;
                document.frmPaciente.txtFechanach.value = fechnac;
                document.frmPaciente.txtEstado.value = estado;
                document.frmPaciente.txtUsuario.value = user;
                document.frmPaciente.txtContra.value = contra;
            }
        </script>

        <%            if (request.getAttribute("msj") != null) {
        %>
        <script type="text/javascript">
            alert('<%=request.getAttribute("msj")%>');
        </script>
        <%
            }
        %>
    </head>
    <%
        DaoPaciente daoPa = new DaoPaciente();
    %>

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

    <style>
        body {width: 99.9%; height: 100%;  position: absolute;}
        body::after {content: ""; background: url('images/fondocli2.jpg'); width: 100%; height: 100%;opacity: 0.6; top: 0; left: 0; bottom: 0; right: 0;display: block; position: absolute; z-index: -1; }
    </style>
    <body class="container-fluid">
        <br>
        <br>
    <center>
        <!-- Agregue un nav-->
        <nav>
            <!--  Y un div para el boton-->    
            <div class="row container-fluid">
                <br>
                <br>                  
                <!-- Clase para alinear boton a la derecha --><!-- clase para mandar a llamar el css del boton -->

                <div class="col-md-2 t pull-left"><button class="btn btn-primary pull-left" data-pushbar-target="pushbar-menu">Desplegar Menu &twoheadrightarrow;</button>&nbsp;</div>
                <div class="col-md-6" style="color: #000;"><h1><b>Gestion de pacientes</b></h1></div>
            </div>
        </nav>
        <!-- Clearfix para limpiar el area del boton -->
        <div class="clearfix"></div> 
        <!--  termina codigo de boton-->
        <div class="clearfix"></div>
        <div class="modal fade" id="nuevaPersona" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">

                        <h1 style="font-size: 25px"><font color="#b2ecf7"><span class="glyphicon glyphicon-user"></span></font>Registro de Pacientes</h1>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="container">

                            <form action="procesarPaciente" method="post" name="frmPacien">

                                <h3>CRUD PACIENTE</h3>

                                <div class="row">
                                    <input type="hidden" name="txtIdpaciente" min="1">
                                    <div class="col-md-4">
                                        Nombre:<input type="text" name="txtNombre" class="form-control">
                                    </div>
                                    <div class="col-md-4">
                                        Domicilio:<input type="text" name="txtDomicilio" class="form-control">
                                    </div>       
                                    <div class="col-md-4">        
                                        Telefono:<input type="text" name="txtTelefono" class="form-control">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        Fecha nacimiento:<input type="text" name="txtFechanach" class="form-control">
                                    </div>

                                    <div class="col-md-4">       
                                        Usuario:<input type="text" name="txtUsuario" class="form-control">
                                    </div>
                                    <div class="col-md-4">        
                                        Contraseña:<input type="text" name="txtContra" class="form-control">
                                    </div>
                                </div>
                                <div class="col-md-10">        
                                    <p>Estado:</p><input type="hidden" name="txtEstado" value="sin" class="form-control"> <p class="text-danger">"SIN EXPEDIENTE"</p>
                                </div>
                                <br>

                                <center>        
                                    <input type="submit" name="btnInsertar" value="INSERTAR" class="btn btn-success">

                                    <input type="reset" name="btnLimpiar" value="LIMPIAR" class="btn btn-info">


                                    </form>

                                    </div>
                                    </div>
                                    </div>
                                    </div>
                                    </div>

                                    <div class="modal fade" id="nuevaPersona1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-lg" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">

                                                    <h1 style="font-size: 25px"><font color="#b2ecf7"><span class="glyphicon glyphicon-user"></span></font>Registro de Pacientes</h1>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="container">

                                                        <form action="procesarPaciente" method="post" name="frmPaciente">

                                                            <h3>CRUD PACIENTE</h3>

                                                            <div class="row">
                                                                <input type="hidden" name="txtIdpaciente" min="1">
                                                                <div class="col-md-4">
                                                                    Nombre:<input type="text" name="txtNombre" class="form-control">
                                                                </div>
                                                                <div class="col-md-4">
                                                                    Domicilio:<input type="text" name="txtDomicilio" class="form-control">
                                                                </div>       
                                                                <div class="col-md-4">        
                                                                    Telefono:<input type="text" name="txtTelefono" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-md-4">
                                                                    Fecha nacimiento:<input type="text" name="txtFechanach" class="form-control">
                                                                </div>

                                                                <div class="col-md-4">       
                                                                    Usuario:<input type="text" name="txtUsuario" class="form-control">
                                                                </div>
                                                                <div class="col-md-4">        
                                                                    Contraseña:<input type="text" name="txtContra" class="form-control">
                                                                </div>
                                                                <div class="col-md-3">        
                                                                    <input type="hidden" name="txtEstado" class="form-control">
                                                                </div>
                                                            </div>

                                                            <br>
                                                            <center>

                                                                <input type="submit" name="btnModificar" value="MODIFICAR" onclick="return confirm('Desea modificar')" class="btn btn-warning">
                                                                <input type="submit" name="btnEliminar"value="ELIMINAR" onclick="return confirm('Desea eliminar')" class="btn btn-danger">
                                                                <input type="reset" name="btnLimpiar" value="LIMPIAR" class="btn btn-info">

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
                                                                        <a href="Menu.jsp"><b>MENU PRINCIPAL</b></a>
                                                                        <a href="Expediente.jsp"><b>Gestion de expedientes</b></a>
                                                                        <a href="cita.jsp"><b>Gestion de citas</b></a>
                                                                        <a href="index.jsp?cerrar=true"><b>Cerrar Sesion</b></a>
                                                                        <!--<a href="http://localhost:8080/SistemaFacturacionMini/Factura.jsp"><b>Gestion de facturas</b></a>-->
                                                                    </nav>
                                                                </div> 
                                                                <br>
                                                                <br>
                                                                <br>
                                                                <div class="row">
                                                                    <div class="col-md-8"></div>
                                                                    <div class="col-md-2">
                                                                        <button class="btn btn-primary" id="nuevo" style="width: 170px; height: 40px;">
                                                                            <span class="glyphicon glyphicon-list-alt"></span> Nuevo Paciente
                                                                        </button>
                                                                    </div>

                                                                </div>

                                                                <br>
                                                                <div class="container">
                                                                    <table border="2" class="table table-bordered datos" style="background-color: #7996c4;">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>Id paciente</th>
                                                                                <th>Nombre</th>
                                                                                <th>Domicilio</th>
                                                                                <th>Telefono</th>
                                                                                <th>Fecha de nacimiento</th>
                                                                                <th>Estado</th>
                                                                                <th>Usuario</th>
                                                                                <th>Contraseña</th>
                                                                                <th>Seleccionar</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <%
                                                                                List<Paciente> listaP = daoPa.mostrarPaciente();

                                                                                for (Paciente pa : listaP) {
                                                                            %>
                                                                            <tr>
                                                                                <td><%=pa.getIdPaciente()%></td>
                                                                                <td><%=pa.getNombre()%></td>
                                                                                <td><%=pa.getDomicilio()%></td>
                                                                                <td><%=pa.getTelefono()%></td>
                                                                                <td><%=pa.getFechaNac()%></td>
                                                                                <td><%=pa.getEstado()%></td>
                                                                                <td><%=pa.getUsuario()%></td>
                                                                                <td><%=pa.getContra()%></td>
                                                                                <td><a href="javascript:cargar(<%=pa.getIdPaciente()%>,'<%=pa.getNombre()%>','<%=pa.getDomicilio()%>','<%=pa.getTelefono()%>','<%=pa.getFechaNac()%>','<%=pa.getEstado()%>','<%=pa.getUsuario()%>','<%=pa.getContra()%>')">
                                                                                        <button class="btn btn-primary res" style="background-color: white; color: black">
                                                                                            <span class="glyphicon glyphicon-upload">
                                                                                                Seleccionar</button>
                                                                            </tr>
                                                                            <%
                                                                                }
                                                                            %>
                                                                        </tbody>
                                                                    </table>

                                                            </center>
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
