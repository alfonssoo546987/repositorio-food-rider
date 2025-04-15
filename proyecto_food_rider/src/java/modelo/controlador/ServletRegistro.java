package modelo.controlador;

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
import modelo.servicios.ServicioUsuarios;

@WebServlet(name = "ServletRegistro", urlPatterns = {"/ServletRegistro"})
public class ServletRegistro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recoger datos del formulario
        String nick = request.getParameter("nick");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String contrasenia = request.getParameter("contrasenia");
        
        // Crear objeto Usuario y asignar los valores
        Usuarios usuarios = new Usuarios();
        usuarios.setNick(nick);
        usuarios.setEmail(email);
        usuarios.setTelefono(telefono);
        usuarios.setContrasenia(contrasenia);
        
        // Introducir el registro creado
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto_food_riderPU");

        ServicioUsuarios servicioUsuarios = new ServicioUsuarios(entityManagerFactory);

        servicioUsuarios.crearUsuarios(usuarios); // Introducimos el Objeto creado

        System.out.println(usuarios.getNick());
        System.out.println(usuarios.getEmail());
        System.out.println(usuarios.getTelefono());
        System.out.println(usuarios.getContrasenia());
        // Ir por Get al servlet que maneja el mostraje de la tabla solicitud
        response.sendRedirect("ServletListado");

    }
}
