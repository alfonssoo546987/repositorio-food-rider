/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades.registros.administrador;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import modelo.entidades.Usuarios;

/**
 *
 * @author alfon
 */
@Entity
public class EmpresasCliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empresa;

    @Column(name = "nombre_empresa_cliente", length = 255, nullable = false)
    private String nombre_empresa_cliente;

    @Column(name = "cif", length = 100, nullable = true)
    private String cif;

    @Column(name = "direccion", length = 255, nullable = false)
    private String direccion;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false, unique = true)
    private Usuarios usuario;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId_empresa() {
        return id_empresa;
    }

    public String getNombre_empresa_cliente() {
        return nombre_empresa_cliente;
    }

    public String getCif() {
        return cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public void setNombre_empresa_cliente(String nombre_empresa_cliente) {
        this.nombre_empresa_cliente = nombre_empresa_cliente;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
