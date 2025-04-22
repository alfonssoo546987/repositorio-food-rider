/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.servicios.registros;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modelo.entidades.UsuariosNoAceptado;

/**
 *
 * @author alfon
 */
public class ServicioUsuariosNoAceptado {

    private EntityManagerFactory entityManagerFactory;

    public ServicioUsuariosNoAceptado(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Método para crear todas las solicitudes
    public void crearUsuariosNoAceptado(UsuariosNoAceptado usuariosNoAceptado) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuariosNoAceptado);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            System.out.println("SE ha ejecutado crearUsuariosNoAceptado");
        }
    }

    // Método para obtener todas las solicitudes
    public List<UsuariosNoAceptado> obtenerUsuariosNoAceptado() {
        EntityManager entityManager = getEntityManager();

        try {
            TypedQuery<UsuariosNoAceptado> query = entityManager.createQuery("SELECT s FROM UsuariosNoAceptado s", UsuariosNoAceptado.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void eliminarUsuarioNoAceptado(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            UsuariosNoAceptado usuario = entityManager.find(UsuariosNoAceptado.class, id);
            if (usuario != null) {
                entityManager.remove(usuario);
            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            System.out.println("Se ha ejecutado eliminarUsuarioNoAceptado");
        }
    }

    public UsuariosNoAceptado obtenerUsuariosNoAceptadoPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuariosNoAceptado.class, id);
        } finally {
            em.close();
        }
    }
}
