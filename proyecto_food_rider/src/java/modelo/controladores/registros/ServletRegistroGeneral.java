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
import modelo.entidades.tienda.EmpresasProveedora;
import modelo.servicios.ServicioUsuarios;
import modelo.servicios.tienda.ServicioEmpresasProveedora;

/**
 *
 * @author alfon
 */
@WebServlet(name = "ServletRegistroGeneral", urlPatterns = {"/ServletRegistroGeneral"})
public class ServletRegistroGeneral extends HttpServlet {

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
        response.sendRedirect("pagina_principal.jsp");
    }

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
    ServicioEmpresasProveedora servicioEmpresasProveedora = new ServicioEmpresasProveedora(entityManagerFactory);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("-1ccccccccccccccccc");

        // Recoger datos del formulario
        String nick = request.getParameter("nick");
        String contrasenia = request.getParameter("contrasenia");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String nombre_empresa = request.getParameter("nombre_empresa_cliente");
        String cif = request.getParameter("cif");
        String direccion = request.getParameter("direccion");
        String especialidad = request.getParameter("especialidad");
        String dni = request.getParameter("dni");
        String nss = request.getParameter("nss");
        String nombre = request.getParameter("nombre");
        String primer_apellido = request.getParameter("primer_apellido");
        String segundo_apellido = request.getParameter("segundo_apellido");
        System.out.println("-2");

        // Insertamos valores en variable de entidades mediante setters
        Usuarios usuarios = new Usuarios();
        usuarios.setNick(nick);
        usuarios.setContrasenia(contrasenia);
        usuarios.setTelefono(telefono);
        usuarios.setEmail(email);
        usuarios.setTipo("Camaron");
        usuarios.setActivo(false);

        EmpresasProveedora empresas_proveedora = new EmpresasProveedora();
        empresas_proveedora.setNombre_empresa_proveedora(nombre_empresa);
        empresas_proveedora.setCif(cif);
        empresas_proveedora.setDireccion(direccion);
        empresas_proveedora.setEspecialidad(especialidad);
        empresas_proveedora.setTelefono(telefono);
        empresas_proveedora.setEmail(email);

        System.out.println("-3");

        servicioEmpresasProveedora.crearEmpresasProveedora(empresas_proveedora);



// Creamos el registro en la tabla usuarionoaceptado, con la ayuda de su servicio.
                //servicioUsuarios.crearUsuarios(usuarios);
                // Asignamos el usuario con ID ya generado 
                //empresas_proveedora.se
                // Creamos el registro en la tabla empresaclientenoaceptado, con la ayuda de su servicio.
                //servicioEmpresasClienteNoAceptado.crearEmpresasClienteNoAceptado(empresasClienteNoAceptado);
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
