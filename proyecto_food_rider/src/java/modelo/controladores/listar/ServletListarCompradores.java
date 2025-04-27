/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package modelo.controladores.listar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.entidades.Usuarios;
import modelo.entidades.usuarios.Compradores;
import modelo.servicios.ServicioCompradores;
import modelo.servicios.ServicioUsuarios;

/**
 *
 * @author alfon
 */
@WebServlet(name = "ServletListarCompradores", urlPatterns = {"/ServletListarCompradores"})
public class ServletListarCompradores extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto_food_riderPU");
    ServicioUsuarios servicioUsuarios = new ServicioUsuarios(entityManagerFactory);
    ServicioCompradores servicioCompradores = new ServicioCompradores(entityManagerFactory);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Creamos una lista de compradores.
            List<Usuarios> usuarios = servicioUsuarios.obtenerUsuarios();
            request.setAttribute("usuariosAt", usuarios);
            List<Compradores> compradores = servicioCompradores.obtenerCompradores();
            request.setAttribute("compradoresAt", compradores);
            getServletContext().getRequestDispatcher("/compradores.jsp").forward(request, response);
        } catch (Exception exception) {
            request.setAttribute("error", "Algo no ha salido bien: " + exception);
            getServletContext().getRequestDispatcher("/compradores.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
