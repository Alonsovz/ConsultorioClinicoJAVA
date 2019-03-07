/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.DaoPaciente;
import com.modelo.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fabio
 */
public class ProcesarPaciente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        RequestDispatcher rd = null;
        DaoPaciente daoPa = new DaoPaciente();
        Paciente pa = new Paciente();
        String msj = null;
        
        try
        {
            
            pa.setNombre(request.getParameter("txtNombre"));
            pa.setDomicilio(request.getParameter("txtDomicilio"));
            pa.setTelefono(request.getParameter("txtTelefono"));
            pa.setFechaNac(request.getParameter("txtFechanach"));
            pa.setEstado(request.getParameter("txtEstado"));
            pa.setUsuario(request.getParameter("txtUsuario"));
            pa.setContra(request.getParameter("txtContra"));
            
            if(request.getParameter("btnInsertar")!=null)
            {
                daoPa.insertarPaciente(pa);
                msj="PACIENTE INSERTADO CORRECTAMENTE";
            }else if(request.getParameter("btnModificar")!=null)
            {
                pa.setIdPaciente(Integer.parseInt(request.getParameter("txtIdpaciente")));
                daoPa.modificarPaciente(pa);
                msj="PACIENTE MODIFICADO CORRECTAMENTE";
            }else if(request.getParameter("btnEliminar")!=null)
            {
                pa.setIdPaciente(Integer.parseInt(request.getParameter("txtIdpaciente")));
                daoPa.eliminarPaciente(pa);
                msj="PACIENTE ELIMINADO CORRECTAMENTE";
            }
            
            rd=request.getRequestDispatcher("paciente.jsp");
            request.setAttribute("msj", msj);
            
        } catch (Exception e)
        {
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
