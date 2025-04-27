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
import javax.servlet.http.HttpSession;
import modelo.entidades.registros.EmpresasClienteNoAceptado;
import modelo.entidades.UsuariosNoAceptado;
import modelo.servicios.registros.ServicioEmpresasClienteNoAceptado;
import modelo.servicios.registros.ServicioUsuariosNoAceptado;

/**
 *
 * @author alfon
 */
@WebServlet(name = "ServletRegistroEmpresaCliente", urlPatterns = {"/ServletRegistroEmpresaCliente"})
public class ServletRegistroEmpresaCliente extends HttpServlet {

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

    ServicioUsuariosNoAceptado servicioUsuariosNoAceptado = new ServicioUsuariosNoAceptado(entityManagerFactory);

    UsuariosNoAceptado usuariosNoAceptado = new UsuariosNoAceptado();

    ServicioEmpresasClienteNoAceptado servicioEmpresasClienteNoAceptado = new ServicioEmpresasClienteNoAceptado(entityManagerFactory);

    EmpresasClienteNoAceptado empresasClienteNoAceptado = new EmpresasClienteNoAceptado();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recoger datos del formulario
        String nick = request.getParameter("nick");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String contrasenia = request.getParameter("contrasenia");

        String nombre_empresa = request.getParameter("nombre_empresa_cliente");
        String cif = request.getParameter("cif");
        String direccion = request.getParameter("direccion");

        // Hacemos los setters en la entidad Usuarios
        usuariosNoAceptado.setNick(nick);
        usuariosNoAceptado.setContrasenia(contrasenia);
        usuariosNoAceptado.setTelefono(telefono);
        usuariosNoAceptado.setEmail(email);
        usuariosNoAceptado.setTipo("Empresa cliente");

        /*
        Pasamos los valores antes setteados a un registro de la tabla Usuarios, con la ayuda de un método del servicio. Esto se debe hacer para poder tener un objeto que sera una propiedad en la siguinete tabla
         */
        servicioUsuariosNoAceptado.crearUsuariosNoAceptado(usuariosNoAceptado);

        // Hacemos los setters en la entidad EmpresaClienteNoAceptad
        empresasClienteNoAceptado.setNombre_empresa_cliente(nombre_empresa);
        empresasClienteNoAceptado.setCif(cif);
        empresasClienteNoAceptado.setDireccion(direccion);
        empresasClienteNoAceptado.setUsuarioNoAceptado(usuariosNoAceptado);

        // Hacemos los setters en la entidad Administradores
        servicioEmpresasClienteNoAceptado.crearEmpresasClienteNoAceptado(empresasClienteNoAceptado);

        // Guardar datos en sesión para uso futuro durante la navegación
        //HttpSession session = request.getSession();
        //session.setAttribute("usuarioRegistrado", usuariosNoAceptado);
        //session.setAttribute("empresaRegistrada", empresasClienteNoAceptado);
        // Reenviamos a otra página
        response.sendRedirect("/proyecto_food_rider/");
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
