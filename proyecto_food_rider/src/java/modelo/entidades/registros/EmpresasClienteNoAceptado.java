/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades.registros;

import modelo.entidades.UsuariosNoAceptado;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author alfon
 */
@Entity
public class EmpresasClienteNoAceptado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empresa_cliente_no_aceptada;

    @Column(name = "nombre_empresa_cliente", length = 255, nullable = false)
    private String nombre_empresa_cliente;

    @Column(name = "cif", length = 100, nullable = true)
    private String cif;

    @Column(name = "direccion", length = 255, nullable = false)
    private String direccion;

    @OneToOne
    @JoinColumn(name = "id_usuario_no_aceptado", referencedColumnName = "id_usuario_no_aceptado", nullable = false, unique = true)
    private UsuariosNoAceptado usuarioNoAceptado;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId_empresa_cliente_no_aceptada() {
        return id_empresa_cliente_no_aceptada;
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

    public UsuariosNoAceptado getUsuarioNoAceptado() {
        return usuarioNoAceptado;
    }

    public void setId_empresa_cliente_no_aceptada(Long id_empresa_cliente_no_aceptada) {
        this.id_empresa_cliente_no_aceptada = id_empresa_cliente_no_aceptada;
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

    public void setUsuarioNoAceptado(UsuariosNoAceptado usuarioNoAceptado) {
        this.usuarioNoAceptado = usuarioNoAceptado;
    }
}
