/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.entidades.tienda;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 *
 * @author alfon
 */
@Entity
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreProducto;
    private String marca;
    private int peso;
    private int volumen;

    @Lob
    private String descripcion;

    private String rutaImagen;

    @ManyToOne
    @JoinColumn(name = "id_tipo_producto")
    private TiposProducto tipoProducto;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getMarca() {
        return marca;
    }

    public int getPeso() {
        return peso;
    }

    public int getVolumen() {
        return volumen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public TiposProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public void setTipoProducto(TiposProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
