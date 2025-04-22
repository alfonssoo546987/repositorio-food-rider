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
    ServicioEmpresasClienteNoAceptado servicioEmpresasClienteNoAceptado = new ServicioEmpresasClienteNoAceptado(entityManagerFactory);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("-1");
        // Recoger datos del formulario
        String nick = request.getParameter("nick");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String contrasenia = request.getParameter("contrasenia");
        String nombre_empresa = request.getParameter("nombre_empresa_cliente");
        String cif = request.getParameter("cif");
        String direccion = request.getParameter("direccion");
System.out.println("-2");
        // Insertamos valores en variable de entidades mediante setters
        UsuariosNoAceptado usuariosNoAceptado = new UsuariosNoAceptado();
        usuariosNoAceptado.setNick(nick);
        usuariosNoAceptado.setEmail(email);
        usuariosNoAceptado.setTelefono(telefono);
        usuariosNoAceptado.setContrasenia(contrasenia);
        usuariosNoAceptado.setTipo("Empresa Cliente");
        usuariosNoAceptado.setActivo(false);

        EmpresasClienteNoAceptado empresasClienteNoAceptado = new EmpresasClienteNoAceptado();
        empresasClienteNoAceptado.setNombre_empresa_cliente(nombre_empresa);
        empresasClienteNoAceptado.setCif(cif);
        empresasClienteNoAceptado.setDireccion(direccion);
System.out.println("-3");
        // Creamos el registro en la tabla usuarionoaceptado, con la ayuda de su servicio.
        servicioUsuariosNoAceptado.crearUsuariosNoAceptado(usuariosNoAceptado);

        // Asignamos el usuario con ID ya generado 
        empresasClienteNoAceptado.setUsuarioNoAceptado(usuariosNoAceptado);

        // Creamos el registro en la tabla empresaclientenoaceptado, con la ayuda de su servicio.
        servicioEmpresasClienteNoAceptado.crearEmpresasClienteNoAceptado(empresasClienteNoAceptado);

        // Guardar datos en sesión para uso futuro durante la navegación
        HttpSession session = request.getSession();
        session.setAttribute("usuarioRegistrado", usuariosNoAceptado);
        session.setAttribute("empresaRegistrada", empresasClienteNoAceptado);

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
