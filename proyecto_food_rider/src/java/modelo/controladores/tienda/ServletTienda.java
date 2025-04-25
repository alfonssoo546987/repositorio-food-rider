/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package modelo.controladores.tienda;

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
import modelo.entidades.tienda.Productos;
import modelo.servicios.tienda.ServicioProductos;

/**
 *
 * @author alfon
 */
@WebServlet(name = "ServletTienda", urlPatterns = {"/ServletTienda"})
public class ServletTienda extends HttpServlet {

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
        System.out.println("estas en servlet tienda");
        try {
            System.out.println("1");
            // Creamos una lista de productos disponibles.
            ServicioProductos servicioProductos = new ServicioProductos(entityManagerFactory);
            System.out.println("2");
            List<Productos> productos = servicioProductos.obtenerProductos();
            System.out.println("3");
            request.setAttribute("productosAt", productos);
            System.out.println("4");
            getServletContext().getRequestDispatcher("/tienda.jsp").forward(request, response);
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
