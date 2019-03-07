/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.modelo.DaoExpediente;
import com.modelo.DaoPaciente;
import com.modelo.Expediente;
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
public class ProcesarExpediente extends HttpServlet {

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
        DaoExpediente daoEx = new DaoExpediente();
        DaoPaciente daoP = new DaoPaciente();
        Expediente ex = new Expediente();
        Paciente pac = new Paciente();
        String msj = null;
        
        try 
        {
            
            pac.setIdPaciente(Integer.parseInt(request.getParameter("txtIdPaciente")));
            ex.setPaciente(pac);
            ex.setTipoSangre(request.getParameter("txtTipoSangre"));
            ex.setNumSeguro(request.getParameter("txtNumeroSeguro"));
            
            if(request.getParameter("btnInsertar")!=null)
            {
                daoEx.insertarExpediente(ex);
                daoP.modificarPacienteEstado(pac);
                msj="Expediente Insertado";
            }else if(request.getParameter("btnModificar")!=null)
            {
                ex.setIdExp(Integer.parseInt(request.getParameter("txtIdExpediente")));
                daoEx.modificarExpediente(ex);
                msj="Expediente Modificado";
            }else if(request.getParameter("btnEliminar")!=null)
            {
                ex.setIdExp(Integer.parseInt(request.getParameter("txtIdExpediente")));
                daoEx.eliminarExpediente(ex);
                msj="Expediente eliminado";
            }
            
            rd=request.getRequestDispatcher("Expediente.jsp");
            request.setAttribute("msj", msj);
        } 
        catch (Exception e) 
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
