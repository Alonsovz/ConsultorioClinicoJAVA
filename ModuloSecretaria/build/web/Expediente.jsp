<%-- 
    Document   : Expediente
    Created on : 10/10/2018, 11:09:45 AM
    Author     : User
--%>

<%@page import="com.modelo.DaoCita"%>
<%@page import="com.modelo.DaoPaciente"%>
<%@page import="com.modelo.Paciente"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.Expediente"%>
<%@page import="com.modelo.DaoExpediente"%>
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



        <title>Expediente</title>
    
        <link rel="icon" type="image/png" href="images/expediente.png"/>
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

        <script>
            $(document).ready(function () {
                $("#nuevo").on("click", function () {
                    $("#nuevaPersona").modal({keyboard: false});
                });


                $("#selectpaciente").on("click", function () {
                    $("#pacientes").modal({keyboard: false});
                });
            });
        </script>
        <script Languaje='JavaScript'>
            function cargar(idExp, idPaciente, tipoSangre, numSeguro)
            {
                $('document').ready(function () {
                    $('#nuevaPersona1').modal();
                });
                document.frmExpediente.txtIdExpediente.value = idExp;
                document.frmExpediente.txtIdPaciente.value = idPaciente;
                document.frmExpediente.txtTipoSangre.value = tipoSangre;
                document.frmExpediente.txtNumeroSeguro.value = numSeguro;
            }

            function cargar2(idPaciente)
            {


                document.frmExpedient.txtIdPaciente.value = idPaciente;
                $('#pacientes').modal('hide');



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
        DaoExpediente daoEx = new DaoExpediente();
        DaoPaciente daoP = new DaoPaciente();
    %>
    <style>
        body {width: 99.9%; height: 100%;  position: absolute;}
        body::after {content: ""; background: url('images/fondocli2.jpg'); width: 100%; height: 100%;opacity: 0.4; top: 0; left: 0; bottom: 0; right: 0;display: block; position: absolute; z-index: -1; }
    </style>
    <body class="container-fluid">
        <br>
        <br>

        <!-- Agregue un nav-->
        <nav>
            <!--  Y un div para el boton-->    
            <div class="row container-fluid">
                <br>
                <br>                  
                <!-- Clase para alinear boton a la derecha --><!-- clase para mandar a llamar el css del boton -->

                <div class="col-md-2 t pull-left"><button class="btn btn-primary pull-left" data-pushbar-target="pushbar-menu" style="background-color: #7996c4;">Desplegar Menu &twoheadrightarrow;</button>&nbsp;</div>
                <div class="col-md-6" style="color:  #000;"><h1><b>Gestion de Expedientes</b></h1></div>
            </div>
        </nav>
        <!-- Clearfix para limpiar el area del boton -->
        <div class="clearfix"></div> 
        <!--  termina codigo de boton-->
        <!--nuevaPersona-->
        <div class="modal fade" id="nuevaPersona" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">

                        <h1 style="font-size: 25px"><font color="#b2ecf7"><span class="glyphicon glyphicon-user"></span></font>Registro de Expedientes</h1>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="procesarExpediente" method="post" name="frmExpedient">
                            <h3>CRUD Expediente</h3>

                            <div class="row">

                                <div class="col-md-4">


                                    Paciente: <input type="hidden" name="txtIdExpediente" min="1" class="form-control">
                                    <select name="txtIdPaciente" class="form-control">
                                        <% DaoCita daoCit = new DaoCita();
                                            List<Paciente> lstPv = daoP.mostrarPaciente1();

                                            for (Paciente p : lstPv) {
                                        %>
                                        <option value="<%=p.getIdPaciente()%>"><%=p.getNombre()%></option>
                                        <%
                                            }
                                        %>           
                                    </select> 

                                    <br>
                                </div>
                                <div class="col-md-4">
                                    Tipo de Sangre:
                                    <input type="text" name="txtTipoSangre" class="form-control">
                                </div>
                                <div class="col-md-4">
                                    Numero de Seguro: 
                                    <input type="text" name="txtNumeroSeguro" class="form-control">
                                </div>
                                <div class="col-md-8"></div>
                                <div class="col-md-2">
                                    <input type="submit" name="btnInsertar" value="INSERTAR" class="btn btn-info">
                                </div>
                                <div class="col-md-2"> 
                                    <input type="reset" name="btnLimpiar" value="LIMPIAR" class="btn  btn-success">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <hr>
                        <button class="btn btn-info" id="selectpaciente" style="width: 100px; height: 45px; background-color: #bce8f1; color: black">
                            <img src="Utilidades/Imagenes/Search-Male-User-icon.png"  style="width: 20px; height: 25px;">Buscar
                        </button>
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
                <a href="Menu.jsp"><b> Menu Principal</b></a>
                <a href="cita.jsp"><b>Gestion de citas</b></a>
                <a href="paciente.jsp"><b>Gestion de pacientes</b></a>
                <a href="index.jsp?cerrar=true"><b>Cerrar Sesion</b></a>
                <!--<a href="http://localhost:8080/SistemaFacturacionMini/Factura.jsp"><b>Gestion de facturas</b></a>-->
            </nav>
        </div>        


        <!--nuevaPersona1-->
        <div class="modal fade" id="nuevaPersona1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">

                        <h1 style="font-size: 25px"><font color="#b2ecf7"><span class="glyphicon glyphicon-user"></span></font>Gestión de Expedientes</h1>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div><form action="procesarExpediente" method="post" name="frmExpediente">
                        <div class="modal-body">

                            <h3></h3>
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-4">
                                        Numero de Seguro: 
                                        <input type="text" name="txtNumeroSeguro" class="form-control">
                                    </div>
                                    <div class="col-md-4">
                                        <input type="hidden" name="txtIdPaciente" class="form-control">
                                        <input type="hidden" name="txtIdExpediente" min="1" class="form-control">
                                        <input type="hidden" name="txtTipoSangre" class="form-control">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="submit" name="btnModificar" value="MODIFICAR" class="btn btn-warning">
                            <input type="submit" name="btnEliminar" value="ELIMINAR" class="btn btn-danger">

                        </div>
                    </form>
                </div>
            </div>
        </div>



        <div class="modal fade" id="pacientes" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">

                        <h1 style="font-size: 25px"><font color="#b2ecf7"><span class="glyphicon glyphicon-user"></span></font>Pacientes sin Expediente</h1>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12">
                                <table class="table table-bordered datos">
                                    <thead>
                                        <tr>
                                            <th>Id paciente</th>
                                            <th>Nombre</th>
                                            <th>Domicilio</th>
                                            <th>Telefono</th>
                                            <th>Fecha de nacimiento</th>
                                            <th>Estado</th>


                                            <th>Seleccionar</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            List<Paciente> listaP = daoP.mostrarPaciente1();

                                            for (Paciente pa : listaP) {
                                        %>
                                        <tr>
                                            <td><%=pa.getIdPaciente()%></td>
                                            <td><%=pa.getNombre()%></td>
                                            <td><%=pa.getDomicilio()%></td>
                                            <td><%=pa.getTelefono()%></td>
                                            <td><%=pa.getFechaNac()%></td>
                                            <td><%=pa.getEstado()%></td>


                                            <td><a href="javascript:cargar2(<%=pa.getIdPaciente()%>)"><button class="btn btn-primary res">
                                                        <span class="glyphicon glyphicon-upload"></span>
                                                            Seleccionar</button></a></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>    
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4"></div>
        <div class="col-md-1"></div>
        <div class="col-md-2">
            <button class="btn btn-primary" id="nuevo" style="width: 170px; height: 40px; background-color: #7996c4;">
                <span class="glyphicon glyphicon-list-alt"></span> Nuevo Expediente
            </button> 
        </div>
    </div>

    <br>
    <br>
    <br>
    <div class="container">

        <table class="table table-bordered datos" style="background-color: #7996c4;">
            <thead>
                <tr>
                    <th>Id Expediente</th>
                    <th>Id Paciente</th>
                    <th>Nombre Paciente</th>

                    <th>Tipo de Sangre</th>
                    <th>Numero Seguro</th>
                    <th>Seleccionar</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Expediente> listaE = daoEx.mostrarExpediente();

                    for (Expediente ex : listaE) {
                %>
                <tr style="color: black">
            <b><td><%= ex.getIdExp()%></td>
                    <td><%= ex.getPaciente().getIdPaciente()%></td>
                    <td><%= ex.getPaciente().getNombre()%></td>
                    <td><%= ex.getTipoSangre()%></td>
                    <td><%= ex.getNumSeguro()%></td></b>
                    <td><a href="javascript:cargar(<%=ex.getIdExp()%>,'<%= ex.getPaciente().getIdPaciente()%>','<%=ex.getTipoSangre()%>','<%=ex.getNumSeguro()%>')"> 
                            <button class="btn btn-primary res"  style="background-color: white; color: black">
                                <span class="glyphicon glyphicon-upload">
                                    Seleccionar</button>
                        </a>
                        <%
                            }
                        %>
            </tbody>
        </table>
    </div>
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
