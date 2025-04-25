/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.servicios.tienda;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modelo.entidades.UsuariosNoAceptado;
import modelo.entidades.tienda.Productos;

/**
 *
 * @author alfon
 */
public class ServicioProductos {

    private EntityManagerFactory entityManagerFactory;

    public ServicioProductos(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public List<Productos> obtenerProductos() {
        EntityManager entityManager = getEntityManager();

        try {
            TypedQuery<Productos> query = entityManager.createQuery("SELECT s FROM Productos s", Productos.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
}
