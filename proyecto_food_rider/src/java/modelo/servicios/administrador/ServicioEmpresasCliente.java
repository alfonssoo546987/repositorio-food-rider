/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.servicios.administrador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modelo.entidades.registros.administrador.EmpresasCliente;

/**
 *
 * @author alfon
 */
public class ServicioEmpresasCliente {

    private EntityManagerFactory entityManagerFactory;

    public ServicioEmpresasCliente(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Método para crear todas los registros de empresas cliente
    public void crearEmpresasCliente(EmpresasCliente empresasCliente) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(empresasCliente);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            System.out.println("Se ha ejecutado crearEmpresasCliente");
        }
    }

    // Método para obtener todas las empresas cliente
    public List<EmpresasCliente> obtenerEmpresasCliente() {
        EntityManager entityManager = getEntityManager();

        try {
            TypedQuery<EmpresasCliente> query = entityManager.createQuery("SELECT s FROM EmpresasCliente s", EmpresasCliente.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void eliminarEmpresaCliente(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            EmpresasCliente empresa = entityManager.find(EmpresasCliente.class, id);
            if (empresa != null) {
                entityManager.remove(empresa);

            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
}
