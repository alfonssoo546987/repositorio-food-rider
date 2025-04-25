/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modelo.entidades.usuarios.Administradores;

/**
 *
 * @author alfon
 */
public class ServicioAdministradores {

    private EntityManagerFactory entityManagerFactory;

    public ServicioAdministradores(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Método para crear todas los registros de administradores
    public void crearAdministradores(Administradores administradores) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(administradores);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            System.out.println("Se ha ejecutado crearAdministradores");
        }
    }

    // Método para obtener todas las empresas cliente
    public List<Administradores> obtenerAdministradores() {
        EntityManager entityManager = getEntityManager();

        try {
            TypedQuery<Administradores> query = entityManager.createQuery("SELECT s FROM Administradores s", Administradores.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void eliminarEmpresaCliente(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Administradores administrador = entityManager.find(Administradores.class, id);
            if (administrador != null) {
                entityManager.remove(administrador);

            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
