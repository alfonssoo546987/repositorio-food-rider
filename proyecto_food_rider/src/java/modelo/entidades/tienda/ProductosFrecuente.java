/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades.tienda;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author alfon
 */
@Entity
public class ProductosFrecuente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Productos productos;

    @ManyToOne
    @JoinColumn(name = "id_empresa_proveedora", nullable = false)
    private EmpresasProveedora empresas;

    private BigDecimal precio;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public Productos getProductos() {
        return productos;
    }

    public EmpresasProveedora getEmpresas() {
        return empresas;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public void setEmpresas(EmpresasProveedora empresas) {
        this.empresas = empresas;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
