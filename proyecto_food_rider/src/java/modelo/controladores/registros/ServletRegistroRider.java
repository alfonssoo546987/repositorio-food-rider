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
import modelo.entidades.Usuarios;
import modelo.entidades.usuarios.EmpleadosRider;
import modelo.servicios.ServicioEmpleadosRider;
import modelo.servicios.ServicioUsuarios;

/**
 *
 * @author alfon
 */
@WebServlet(name = "ServletRegistroRider", urlPatterns = {"/ServletRegistroRider"})
public class ServletRegistroRider extends HttpServlet {

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
    ServicioUsuarios servicioUsuarios = new ServicioUsuarios(entityManagerFactory);
    Usuarios usuarios = new Usuarios();
    ServicioEmpleadosRider servicioEmpleadosRider = new ServicioEmpleadosRider(entityManagerFactory);
    EmpleadosRider empleadosRider = new EmpleadosRider();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recoger datos del formulario
        String nick = request.getParameter("nick");
        String contrasenia = request.getParameter("contrasenia");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String dni = request.getParameter("dni");
        String nss = request.getParameter("nss");
        String nombre = request.getParameter("nombre");
        String primer_apellido = request.getParameter("primer_apellido");
        String segundo_apellido = request.getParameter("segundo_apellido");

        // Hacemos los setters en la entidad Usuarios
        usuarios.setNick(nick);
        usuarios.setContrasenia(contrasenia);
        usuarios.setTelefono(telefono);
        usuarios.setEmail(email);
        usuarios.setTipo("Rider");
        usuarios.setActivo(true);

        /*
        Pasamos los valores antes setteados a un registro de la tabla Usuarios, con la ayuda de un método del servicio. Esto se debe hacer para poder tener un objeto que sera una propiedad en la siguinete tabla
         */
        servicioUsuarios.crearUsuarios(usuarios);

        // Hacemos los setters en la entidad EmpleadosRider
        empleadosRider.setNumero_documento_empleado_rider(dni);
        empleadosRider.setNss(nss);
        empleadosRider.setNombre(nombre);
        empleadosRider.setApellido_principal(primer_apellido);
        empleadosRider.setApellido_secundario(segundo_apellido);
        empleadosRider.setUsuario(usuarios);

        // Pasamos los valores antes setteados a un registro de la tabla EmpleadosRider, con la ayuda de un método del servicio
        servicioEmpleadosRider.crearEmpleadosRider(empleadosRider);

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
