package com.controlador;

import com.modelo.Validar;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Geo-Garcia
 */
public class ProcesarLoguin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String nombre;
        String contra;
        int nivel=0;
        String data=null;
        RequestDispatcher rd = null;
        
        Validar obj = new Validar();
        
        if (request.getParameter("btnIngresar")!=null) 
        {
            nombre=request.getParameter("txtUsuario");
            contra=request.getParameter("txtContra");
            try {
                nivel=obj.validarUsuario(nombre, contra);
            } catch (Exception ex) {
                Logger.getLogger(ProcesarLoguin.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(nivel != 2){
                data="error";
            }
            request.setAttribute("nivel",nivel);
            request.setAttribute("nombre",nombre);
            
            
            rd=request.getRequestDispatcher("index.jsp");
            request.setAttribute("data",data);
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
