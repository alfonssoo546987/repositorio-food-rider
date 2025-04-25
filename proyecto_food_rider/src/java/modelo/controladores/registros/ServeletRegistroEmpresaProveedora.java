/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package modelo.controladores.registros;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.entidades.tienda.EmpresasProveedora;
import modelo.servicios.tienda.ServicioEmpresasProveedora;

/**
 *
 * @author alfon
 */
@WebServlet(name = "ServeletRegistroEmpresaProveedora", urlPatterns = {"/ServeletRegistroEmpresaProveedora"})
public class ServeletRegistroEmpresaProveedora extends HttpServlet {

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
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto_food_riderPU");
    ServicioEmpresasProveedora servicioEmpresasProveedora = new ServicioEmpresasProveedora(entityManagerFactory);
    EmpresasProveedora empresasProveedora = new EmpresasProveedora();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recoger datos del formulario
        String nombre_empresa = request.getParameter("nombre_empresa_proveedora");
        String cif = request.getParameter("cif");
        String direccion = request.getParameter("direccion");
        String especialidad = request.getParameter("especialidad");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");

        // Hacemos los setters en la entidad
        empresasProveedora.setNombre_empresa_proveedora(nombre_empresa);
        empresasProveedora.setCif(cif);
        empresasProveedora.setDireccion(direccion);
        empresasProveedora.setEspecialidad(especialidad);
        empresasProveedora.setTelefono(telefono);
        empresasProveedora.setEmail(email);

        // Pasamos los valores antes setteados a un registro de la tabla EmpresaProveedora, con la ayuda de un método del servicio
        servicioEmpresasProveedora.crearEmpresasProveedora(empresasProveedora);

        response.sendRedirect("ServletIdiomas");
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
