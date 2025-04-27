/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modelo.entidades.usuarios.EmpleadosRider;

/**
 *
 * @author alfon
 */
public class ServicioEmpleadosRider {

    private EntityManagerFactory entityManagerFactory;

    public ServicioEmpleadosRider(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Método para crear todas los registros de empresas cliente
    public void crearEmpleadosRider(EmpleadosRider empleadosRider) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(empleadosRider);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            System.out.println("Se ha ejecutado crearEmpleadosRider");
        }
    }

    // Método para obtener todas las empresas cliente
    public List<EmpleadosRider> obtenerEmpleadosRider() {
        EntityManager entityManager = getEntityManager();
        System.out.println("aaaaaaa");
        try {
            System.out.println("bbbbbb");
            TypedQuery<EmpleadosRider> query = entityManager.createQuery("SELECT s FROM EmpleadosRider s", EmpleadosRider.class);
            System.out.println("cccccccccc");
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void eliminarEmpleadosRider(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            EmpleadosRider rider = entityManager.find(EmpleadosRider.class, id);
            if (rider != null) {
                entityManager.remove(rider);

            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
