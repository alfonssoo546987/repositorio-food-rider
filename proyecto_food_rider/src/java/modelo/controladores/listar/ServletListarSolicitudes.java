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
import modelo.entidades.UsuariosNoAceptado;
import modelo.entidades.registros.EmpresasClienteNoAceptado;
import modelo.servicios.registros.ServicioEmpresasClienteNoAceptado;
import modelo.servicios.registros.ServicioUsuariosNoAceptado;

/**
 *
 * @author alfon
 */
@WebServlet(name = "ServletListarSolicitudes", urlPatterns = {"/ServletListarSolicitudes"})
public class ServletListarSolicitudes extends HttpServlet {

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto_food_riderPU");
        try {
            // Creamos una lista de solicitudes totales.
            ServicioUsuariosNoAceptado servicioUsuariosNoAceptado = new ServicioUsuariosNoAceptado(entityManagerFactory);
            List<UsuariosNoAceptado> usuariosNoAceptado = servicioUsuariosNoAceptado.obtenerUsuariosNoAceptado();
            request.setAttribute("usuariosNoAceptadoAt", usuariosNoAceptado);

            ServicioEmpresasClienteNoAceptado servicioEmpresasClienteNoAceptado = new ServicioEmpresasClienteNoAceptado(entityManagerFactory);
            List<EmpresasClienteNoAceptado> empresasClienteNoAceptado = servicioEmpresasClienteNoAceptado.obtenerEmpresasClienteNoAceptado();
            request.setAttribute("empresasClienteNoAceptadoAt", empresasClienteNoAceptado);
            getServletContext().getRequestDispatcher("/solicitudes.jsp").forward(request, response);
        } catch (Exception exception) {
            request.setAttribute("error", "Algo no ha salido bien: " + exception);
        } finally {
            entityManagerFactory.close();
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
