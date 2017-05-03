/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain;

import java.io.Serializable;
import pe.com.veloz.utils.AppUtils;

/**
 *
 * @author eddy
 */
public class Producto implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String descripcion;
    private double precioUnit;
    private double precioDocena;
    private double precioCiento;
    private double precioCincuenta;
    private double precioCompra;
    private double precioVenta;
    private Long estado;
    private boolean estadoBoolean;
    private int stock;
    private String marca;
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public double getPrecioDocena() {
        return precioDocena;
    }

    public void setPrecioDocena(double precioDocena) {
        this.precioDocena = precioDocena;
    }

    public double getPrecioCiento() {
        return precioCiento;
    }

    public void setPrecioCiento(double precioCiento) {
        this.precioCiento = precioCiento;
    }

    public double getPrecioCincuenta() {
        return precioCincuenta;
    }

    public void setPrecioCincuenta(double precioCincuenta) {
        this.precioCincuenta = precioCincuenta;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isEstadoBoolean() {
        return estadoBoolean;
    }

    public void setEstadoBoolean(boolean estadoBoolean) {
        this.estadoBoolean = estadoBoolean;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioUnit=" + precioUnit + ", precioDocena=" + precioDocena + ", precioCiento=" + precioCiento + ", precioCincuenta=" + precioCincuenta + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", estado=" + estado + ", estadoBoolean=" + estadoBoolean + ", stock=" + stock + ", marca=" + marca + ", code=" + code + '}';
    }

}
