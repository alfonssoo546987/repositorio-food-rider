/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modelo.entidades.usuarios.Compradores;

/**
 *
 * @author alfon
 */
public class ServicioCompradores {

    private EntityManagerFactory entityManagerFactory;

    public ServicioCompradores(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Método para crear todas los registros de empresas cliente
    public void crearCompradores(Compradores compradores) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(compradores);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            System.out.println("Se ha ejecutado crearCompradores");
        }
    }

    // Método para obtener todas las empresas cliente
    public List<Compradores> obtenerCompradores() {
        EntityManager entityManager = getEntityManager();

        try {
            TypedQuery<Compradores> query = entityManager.createQuery("SELECT s FROM Compradores s", Compradores.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void eliminarCompradores(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Compradores comprador = entityManager.find(Compradores.class, id);
            if (comprador != null) {
                entityManager.remove(comprador);

            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
