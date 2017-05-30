/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.enums;

/**
 *
 * @author josmarl
 */
public enum ReporteEnum {

    R_ALMACEN_CONSOLIDADO(1, "Consolidado del Almacén", 1),
    R_VENTAS(2, "Ventas", 2);

    private int id;
    private String nombre;
    private int orden;

    private ReporteEnum(int id, String nombre, int orden) {
        this.id = id;
        this.nombre = nombre;
        this.orden = orden;
    }

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

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

}
