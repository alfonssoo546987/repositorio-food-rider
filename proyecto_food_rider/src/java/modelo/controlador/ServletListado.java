package modelo.controlador;

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
import modelo.entidades.Usuarios;
import modelo.servicios.ServicioUsuarios;

@WebServlet(name = "ServletListado", urlPatterns = {"/ServletListado"})
public class ServletListado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("proyecto_food_riderPU");

        try {
            
            // Creamos una lista de solicitudes totales.
            ServicioUsuarios servicioUsuarios = new ServicioUsuarios(entityManagerFactory);

            List<Usuarios> usuarios = servicioUsuarios.listarUsuarios();

            request.setAttribute("usuariosAt", usuarios);

            getServletContext().getRequestDispatcher("/registro.jsp").forward(request, response);
        } catch (Exception exception) {
            request.setAttribute("error", "Algo no ha salido bien: " + exception);
        } finally {
            entityManagerFactory.close();
        }
    }
}
