/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package modelo.controladores.inicioSesion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.entidades.Usuarios;
import modelo.servicios.ServicioUsuarios;

/**
 *
 * @author alfon
 */
@WebServlet(name = "ServletInicioSesion", urlPatterns = {"/ServletInicioSesion"})
public class ServletInicioSesion extends HttpServlet {

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
    ServicioUsuarios servicioUsuarios = new ServicioUsuarios(Persistence.createEntityManagerFactory("proyecto_food_riderPU"));

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Creamos objeto de Usuario en base a un determinado e-mail.
            String nick = request.getParameter("nick");
            String contrasenia = request.getParameter("contrasenia");

            Usuarios usuarios = servicioUsuarios.obtenerUsuarioPorNick(nick);

            // Validamos al usuario.
            if (usuarios != null && usuarios.getContrasenia().equals(contrasenia)) {

                // Creamos una sesion e introducimos el usuario creado en ella.
                HttpSession sesion = request.getSession();
                sesion.setAttribute("usuariosAt", usuarios);
                sesion.setAttribute("tipoUsuarioAt", usuarios.getTipo());
                response.sendRedirect("seleccion_idiomas.jsp");

            } else {
                request.setAttribute("error", "El email o la contraseña son incorrectos.");
                response.sendRedirect("/proyecto_food_rider/index.html");
            }

        } catch (Exception exception) {
            request.setAttribute("error", "El inicio de sesión ha fallado: " + exception.getMessage());
            response.sendRedirect("/proyecto_food_rider/index.html");
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
