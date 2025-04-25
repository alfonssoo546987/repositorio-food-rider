/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades.usuarios;

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
public class Compradores implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_comprador;

    @Column(name = "numero_documento_comprador", length = 100, nullable = false)
    private String numero_documento_comprador;

    @Column(name = "nss", length = 100, nullable = false)
    private String nss;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "apellido_principal", length = 100, nullable = false)
    private String apellido_principal;

    @Column(name = "apellido_secundario", length = 100, nullable = true)
    private String apellido_secundario;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false, unique = true)
    private Usuarios usuario;

    public Long getId_comprador() {
        return id_comprador;
    }

    public void setId_comprador(Long id_comprador) {
        this.id_comprador = id_comprador;
    }

    public String getNumero_documento_comprador() {
        return numero_documento_comprador;
    }

    public void setNumero_documento_comprador(String numero_documento_comprador) {
        this.numero_documento_comprador = numero_documento_comprador;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_principal() {
        return apellido_principal;
    }

    public void setApellido_principal(String apellido_principal) {
        this.apellido_principal = apellido_principal;
    }

    public String getApellido_secundario() {
        return apellido_secundario;
    }

    public void setApellido_secundario(String apellido_secundario) {
        this.apellido_secundario = apellido_secundario;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
