package com.controlador;

import com.modelo.Cita;
import com.modelo.DaoCita;
import com.modelo.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Emerson Sibrian
 */
public class ProcesarCita extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = null;
        Cita cit = new Cita();
        Paciente pac = new Paciente();
        DaoCita daoCit = new DaoCita();
        String msj = null;
        String diass = null;
        Calendar cal = Calendar.getInstance();
        try {

            pac.setIdPaciente(Integer.parseInt(request.getParameter("selectPaciente")));
            cit.setPaciente(pac);
            cit.setFecha(request.getParameter("txtFecha"));
            cit.setHora(request.getParameter("txtHora"));

            String fec = request.getParameter("txtFecha");
            String ho = request.getParameter("txtHora");
            String hora = "";
            String minutos = "";
            String suma30Minutos = "";
            String resta30Minutos = "";
            int restaMinutos = 0;
            int validarRestaMi = 0;
            int restaHora = 0;
            int sumaMinutos = 0;
            int validarSumaMi = 0;
            int sumaHora = 0;
            int insertar = 2;
            int insertarS = 2;

            cit.setEstado("Pendiente");
            cit.setComentarios("Pendiente");

            if (request.getParameter("btn") != null) {
                cit.setIdCita(Integer.parseInt(request.getParameter("txtIdCita")));
                daoCit.eliminarCita(cit);
                msj = "Eli";
            }
            //esto para validar la fecha de ingreso
            Calendar c1 = Calendar.getInstance();
            int dia = c1.get(Calendar.DATE);
            int mess = 11;
            int annio = c1.get(Calendar.YEAR);
            String fecha = annio + "-" + mess + "-" + dia;
            int AnioEntrada = Integer.parseInt(fec.substring(0, 4));
            int mesEntrada = Integer.parseInt(fec.substring(5, 7));
            int diaEntrada = Integer.parseInt(fec.substring(8, 10));
            String validarFechassss = "";
            if (AnioEntrada < annio) {
                validarFechassss = "aca estas ingresando un o dias antes de la  fecha requerida";
                msj = "errorDate";
            } else { //if (AnioEntrada >= annio && mesEntrada >= mess || diaEntrada > dia)

                if (AnioEntrada > 2019 && mesEntrada < mess) {
                    msj = "errorDate";
                    validarFechassss = " AnioEntrada < annio || mesEntrada < mess ";
                } else {

                    if (mesEntrada <= mess && diaEntrada < dia && AnioEntrada <= annio ){
   

                        msj = "errorDate";
                        validarFechassss = " mesEntrada < mess && diaEntrada < dia ";

                    } else {

                        
                            //<editor-fold defaultstate="collapsed" desc="Insertar">
                            if (request.getParameter("btnInsertar") != null) {
                                hora = ho.substring(0, 2);
                                minutos = ho.substring(3, 5);

                                if (Integer.parseInt(hora) >= 8 && Integer.parseInt(hora) <= 17) {
                                    //para ver si ya hay una cita

                                    // para la hora de antes en 29 minutos 
                                    sumaMinutos = Integer.parseInt(minutos) - 29;
                                    if (sumaMinutos < 0) {

                                        validarSumaMi = sumaMinutos + 59;
                                        //validamos para saber si el hora es mayor a 10
                                        if (Integer.parseInt(ho.substring(0, 2)) >= 10) {
                                            sumaHora = Integer.parseInt(ho.substring(0, 2)) - 1;
                                        } else {
                                            sumaHora = Integer.parseInt(ho.substring(1, 2)) - 1;
                                        }
                                        suma30Minutos = "0" + Integer.toString(sumaHora) + ":" + validarSumaMi;

                                        if (daoCit.fechVal(fec, ho, suma30Minutos) != 0) {
                                            msj = "Repetida";
                                            insertarS = 2;
                                        } else {
                                            insertarS = 1;

                                        }
                                    } else {
                                        suma30Minutos = hora + ":" + sumaMinutos;
                                        if (daoCit.fechVal(fec, ho, suma30Minutos) != 0) {
                                            msj = "Repetida";
                                            insertarS = 2;
                                        } else {
                                            insertarS = 1;

                                        }
                                    }
                                    //paradespues de 29 minutos
                                    restaMinutos = Integer.parseInt(minutos) + 29;

                                    if (restaMinutos >= 60) {
                                        validarRestaMi = restaMinutos - 59;

                                        if (Integer.parseInt(ho.substring(0, 2)) >= 10) {
                                            restaHora = Integer.parseInt(ho.substring(0, 2)) + 1;
                                        } else {
                                            restaHora = Integer.parseInt(ho.substring(1, 2)) + 1;
                                        }
                                        resta30Minutos = Integer.toString(restaHora) + ":" + validarRestaMi;

                                        if (daoCit.fechVal2(fec, ho, resta30Minutos) != 0) {
                                            insertar = 2;
                                            msj = "Repetidas";
                                        } else {
                                            insertar = 1;

                                        }
                                    } else {
                                        resta30Minutos = hora + ":" + restaMinutos;
                                        if (daoCit.fechVal2(fec, ho, resta30Minutos) != 0) {
                                            msj = "Repetida";
                                            insertar = 2;
                                        } else {
                                            insertar = 1;

                                        }
                                    }
                                    /*
                    //para ver si ya hay una cita
                    if (daoCit.fechVal3(fec, ho) != 0) {
                            msj = "Repetida" ;
                            insertar = 2;
                        } else {
                            insertar=1;
                            
                        }
                                     */

                                    if (insertar == 1 && insertarS == 1) {
                                       daoCit.insertarCita(cit);
                                        msj = "Ingresado";
                                    }

                                } else {
                                    msj = "Incorrecto";
                                }

                            }
                            //</editor-fold>
                            //<editor-fold defaultstate="collapsed" desc="Modificar">
                            if (request.getParameter("btnModificar") != null) {
                                cit.setIdCita(Integer.parseInt(request.getParameter("txtIdCita")));
                                daoCit.modificarCita(cit);
                                msj = "Modi";
                            }
                            //</editor-fold>
                            validarFechassss = "aca es unos dias despues ";

                            //msj = "";
                       
                        

                    }

                }
            }

            rd = request.getRequestDispatcher("cita.jsp");
            request.setAttribute("msj", msj);

            request.setAttribute("msjs", daoCit.fechVal(fec, ho, suma30Minutos));
            request.setAttribute("msjjs", daoCit.fechVal2(fec, ho, resta30Minutos));
            request.setAttribute("msjss", "a;o: " + AnioEntrada + " mess: " + mesEntrada + " dia :" + validarFechassss);
            //request.setAttribute("msjs", ho);
        } catch (Exception e) {
            request.setAttribute("error", e.toString());
        }
        rd.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
