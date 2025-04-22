/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.servicios.registros;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import modelo.entidades.registros.EmpresasClienteNoAceptado;

/**
 *
 * @author alfon
 */
public class ServicioEmpresasClienteNoAceptado {

    private EntityManagerFactory entityManagerFactory;

    public ServicioEmpresasClienteNoAceptado(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    // Método para crear todas las solicitudes
    public void crearEmpresasClienteNoAceptado(EmpresasClienteNoAceptado empresasClienteNoAceptado) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(empresasClienteNoAceptado);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            System.out.println("Se ha ejecutado crearEmpresasClienteNoAceptado");
        }
    }

    // Método para obtener todas las solicitudes
    public List<EmpresasClienteNoAceptado> obtenerEmpresasClienteNoAceptado() {
        EntityManager entityManager = getEntityManager();

        try {
            TypedQuery<EmpresasClienteNoAceptado> query = entityManager.createQuery("SELECT s FROM EmpresasClienteNoAceptado s", EmpresasClienteNoAceptado.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
    
    public EmpresasClienteNoAceptado obtenerEmpresasClienteNoAceptadoPorId(Long id) {
    EntityManager em = getEntityManager();
    try {
        TypedQuery<EmpresasClienteNoAceptado> query = em.createQuery(
            "SELECT e FROM EmpresasClienteNoAceptado e WHERE e.usuarioNoAceptado.id_usuario_no_aceptado = :id",
            EmpresasClienteNoAceptado.class
        );
        query.setParameter("id", id);
        return query.getSingleResult();
    } finally {
        em.close();
    }
}


    public void eliminarEmpresaClienteNoAceptado(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            EmpresasClienteNoAceptado empresa = entityManager.find(EmpresasClienteNoAceptado.class, id);
            if (empresa != null) {
                entityManager.remove(empresa);
                
            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            System.out.println("Se ha ejecutado eliminarEmpresaClienteNoAceptado");
        }
    }
    
    
    public EmpresasClienteNoAceptado obtenerEmpresaClienteNoAceptadoPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EmpresasClienteNoAceptado.class, id);
        } finally {
            em.close();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
}


