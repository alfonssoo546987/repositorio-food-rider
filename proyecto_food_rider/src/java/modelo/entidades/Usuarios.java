/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades;

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
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(name = "nick", length = 100, nullable = false)
    private String nick;

    @Column(name = "contrasenia", length = 100, nullable = false)
    private String contrasenia;

    @Column(name = "telefono", length = 20, nullable = true)
    private String telefono;

    @Column(name = "email", length = 100, nullable = true)
    private String email;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public String getNick() {
        return nick;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
