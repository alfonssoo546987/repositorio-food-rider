/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.servicios.tienda;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modelo.entidades.tienda.EmpresasProveedora;

/**
 *
 * @author alfon
 */
public class ServicioEmpresasProveedora {

    private final EntityManagerFactory entityManagerFactory;

    public ServicioEmpresasProveedora(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Método para crear todas los registros de administradores
    public void crearEmpresasProveedora(EmpresasProveedora empresasProveedora) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(empresasProveedora);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            System.out.println("Se ha ejecutado crearEmpresasProveedora");
        }
    }

    // Método para obtener todas las empresas cliente
    public List<EmpresasProveedora> obtenerEmpresasProveedora() {
        EntityManager entityManager = getEntityManager();
        try {
            TypedQuery<EmpresasProveedora> query = entityManager.createQuery("SELECT s FROM EmpresasProveedora s", EmpresasProveedora.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void eliminarEmpresasProveedora(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            EmpresasProveedora empresa = entityManager.find(EmpresasProveedora.class, id);
            if (empresa != null) {
                entityManager.remove(empresa);

            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
