/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades.tienda;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author alfon
 */
@Entity
public class EmpresasProveedora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empresa_proveedora;

    @Column(nullable = false, unique = true)
    private String nombre_empresa_proveedora;

    @Column(unique = true)
    private String cif;

    @Column(nullable = false, unique = true)
    private String direccion;

    @Column(nullable = false)
    private String especialidad;

    @Column(nullable = false, unique = true)
    private String telefono;

    @Column(unique = true)
    private String email;

    public Long getId_empresa_proveedora() {
        return id_empresa_proveedora;
    }

    public void setId_empresa_proveedora(Long id_empresa_proveedora) {
        this.id_empresa_proveedora = id_empresa_proveedora;
    }

    public String getNombre_empresa_proveedora() {
        return nombre_empresa_proveedora;
    }

    public void setNombre_empresa_proveedora(String nombre_empresa_proveedora) {
        this.nombre_empresa_proveedora = nombre_empresa_proveedora;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
