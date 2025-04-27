/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package modelo.controladores.administrador;

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
import modelo.entidades.UsuariosNoAceptado;
import modelo.entidades.registros.Email;
import modelo.entidades.registros.administrador.EmpresasCliente;
import modelo.servicios.ServicioUsuarios;
import modelo.servicios.administrador.ServicioEmpresasCliente;
import modelo.servicios.registros.ServicioEmpresasClienteNoAceptado;
import modelo.servicios.registros.ServicioUsuariosNoAceptado;
import modelo.utilidades.Utilidades;

/**
 *
 * @author alfon
 */
@WebServlet(name = "ServletAceptaORechazaSolicitud", urlPatterns = {"/ServletAceptaORechazaSolicitud"})
public class ServletAceptaORechazaSolicitud extends HttpServlet {

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
    private final String eMailRemitente = "alfonsoisman@gmail.com";
    private final String emailDestinatario = "manzano.rodriguez.alfonso.ismael@iescamas.es";
    private final String asunto = "Prueba de envío de e:mail";
    private final String textoAceptacion = "¡Bienvenido!. Nos alegra muchísimo su exitoso registro en nuestra aplicación, no lamentará adquirir nuestros exclusivos servicios.";
    private final String textoRechazo = "Lamentamos comunicarle que su empresa no cumple las condiciones requeridas para solicitar nuestros servicios, por lo que nos vemos obligados a rechazar su registro en nuestra aplicación. En caso de dudas puede contactar con nosotros mediante el formulario de contacto de nuestra web.";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idUsuarioStr = request.getParameter("id_usuario");
        Long idUsuario = Long.parseLong(idUsuarioStr);
        String accion = request.getParameter("accion");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto_food_riderPU");
        ServicioUsuariosNoAceptado servicioUsuarioNoAceptado = new ServicioUsuariosNoAceptado(entityManagerFactory);
        ServicioUsuarios servicioUsuario = new ServicioUsuarios(entityManagerFactory);
        Usuarios usuarios = new Usuarios();
        UsuariosNoAceptado usuariosNoAceptado = new UsuariosNoAceptado();
        ServicioEmpresasClienteNoAceptado servicioEmpresaClienteNoAceptado = new ServicioEmpresasClienteNoAceptado(entityManagerFactory);
        ServicioEmpresasCliente servicioEmpresaCliente = new ServicioEmpresasCliente(entityManagerFactory);
        EmpresasCliente empresasCliente = new EmpresasCliente();

        if (idUsuarioStr != null) {
            try {
                if ("aceptar".equals(accion)) {
                    // Añadimos el registro de la tabla UsuariosNoAceptado a la tabla Usuarios
                    usuarios.setNick(servicioUsuarioNoAceptado.obtenerUsuariosNoAceptadoPorId(idUsuario).getNick());
                    usuarios.setContrasenia(servicioUsuarioNoAceptado.obtenerUsuariosNoAceptadoPorId(idUsuario).getContrasenia());
                    usuarios.setTelefono(servicioUsuarioNoAceptado.obtenerUsuariosNoAceptadoPorId(idUsuario).getTelefono());
                    usuarios.setEmail(servicioUsuarioNoAceptado.obtenerUsuariosNoAceptadoPorId(idUsuario).getEmail());
                    usuarios.setTipo("Empresa Cliente");
                    servicioUsuario.crearUsuarios(usuarios);

                    // Añadimos el registro de la tabla EmpresasClienteNoAceptado a la tabla EmpresasCliente
                    empresasCliente.setNombre_empresa_cliente(servicioEmpresaClienteNoAceptado.obtenerEmpresasClienteNoAceptadoPorId(idUsuario).getNombre_empresa_cliente());
                    empresasCliente.setCif(servicioEmpresaClienteNoAceptado.obtenerEmpresasClienteNoAceptadoPorId(idUsuario).getCif());
                    empresasCliente.setDireccion(servicioEmpresaClienteNoAceptado.obtenerEmpresasClienteNoAceptadoPorId(idUsuario).getDireccion());
                    empresasCliente.setUsuario(usuarios);

                    servicioEmpresaCliente.crearEmpresasCliente(empresasCliente);

                    // Eliminamos los registros inútiles de las tabla UsuarioNoAceptado y EmpresasClienteNoAceptado
                    servicioEmpresaClienteNoAceptado.eliminarEmpresaClienteNoAceptado(idUsuario);
                    servicioUsuarioNoAceptado.eliminarUsuarioNoAceptado(idUsuario);
                    // Enviamos el email de aceptación
                    Email emailAceptar = new Email(eMailRemitente, emailDestinatario, asunto, textoAceptacion);

                    Utilidades utilidadesAceptar = new Utilidades();
                    utilidadesAceptar.setEnviarEmail(emailAceptar);

                    // Redirige a pagina_principal.jsp
                    response.sendRedirect("pagina_principal.jsp");

                } else if ("rechazar".equals(accion)) {
                    // Eliminamos los registros inútiles de las tabla UsuarioNoAceptado y EmpresasClienteNoAceptado
                    servicioEmpresaClienteNoAceptado.eliminarEmpresaClienteNoAceptado(idUsuario);
                    servicioUsuarioNoAceptado.eliminarUsuarioNoAceptado(idUsuario);

                    // Enviamos el email de aceptación
                    Email emailRechazar = new Email(eMailRemitente, emailDestinatario, asunto, textoRechazo);
                    Utilidades utilidadesRechazar = new Utilidades();
                    utilidadesRechazar.setEnviarEmail(emailRechazar);
                    
                    // Redirige a pagina_principal.jsp
                    response.sendRedirect("pagina_principal.jsp");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de usuario no válido.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el parámetro id_usuario.");
        }
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
