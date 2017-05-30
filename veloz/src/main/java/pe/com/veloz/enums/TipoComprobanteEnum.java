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
public enum TipoComprobanteEnum {

    TIPO_BOLETA(1l, "Boleta", "01", 1l),
    TIPO_FACTURA(2l, "Factura", "02", 1l);

    private Long id;
    private String nombre;
    private String codigo;
    private Long estado;

    private TipoComprobanteEnum(Long id, String nombre, String codigo, Long estado) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

}
