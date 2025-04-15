/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modelo.entidades.Usuarios;

/**
 *
 * @author alfon
 */
public class ServicioUsuarios {

    private EntityManagerFactory entityManagerFactory;

    public ServicioUsuarios(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Método para crear todas las solicitudes
    public void crearUsuarios(Usuarios usuarios) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuarios);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    // Método para obtener todas las solicitudes
    public List<Usuarios> obtenerUsuarios() {
        EntityManager entityManager = getEntityManager();

        try {
            TypedQuery<Usuarios> query = entityManager.createQuery("SELECT s FROM Usuarios s", Usuarios.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<Usuarios> listarUsuarios() {
        EntityManager entityManager = getEntityManager();

        try {
            return entityManager.createQuery("SELECT e FROM Usuarios e", Usuarios.class)
                    .getResultList();
        } finally {
            entityManager.close();
        }
    }
}
