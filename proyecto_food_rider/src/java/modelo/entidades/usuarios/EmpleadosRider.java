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
public class EmpleadosRider implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rider;

    @Column(name = "numero_documento_empleado_rider", length = 100, nullable = false)
    private String numero_documento_empleado_rider;

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

    public Long getId_rider() {
        return id_rider;
    }

    public void setId_rider(Long id_rider) {
        this.id_rider = id_rider;
    }

    public String getNumero_documento_empleado_rider() {
        return numero_documento_empleado_rider;
    }

    public void setNumero_documento_empleado_rider(String numero_documento_empleado_rider) {
        this.numero_documento_empleado_rider = numero_documento_empleado_rider;
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
