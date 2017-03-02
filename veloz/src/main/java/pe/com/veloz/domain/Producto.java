/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.domain;

/**
 *
 * @author eddy
 */
public class Producto {
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
    private String estado;
    private int stock;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
}
