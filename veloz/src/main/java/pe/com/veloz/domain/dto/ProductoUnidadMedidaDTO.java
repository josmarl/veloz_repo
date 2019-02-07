package pe.com.veloz.domain.dto;

public class ProductoUnidadMedidaDTO {

    private String unidadMedidaNombre;
    private Long unidadMedidaId;
    private String productoNombre;
    private Long productoId;
    private Double precio;

    public ProductoUnidadMedidaDTO() {
    }

    public String getUnidadMedidaNombre() {
        return unidadMedidaNombre;
    }

    public void setUnidadMedidaNombre(String unidadMedidaNombre) {
        this.unidadMedidaNombre = unidadMedidaNombre;
    }

    public Long getUnidadMedidaId() {
        return unidadMedidaId;
    }

    public void setUnidadMedidaId(Long unidadMedidaId) {
        this.unidadMedidaId = unidadMedidaId;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
