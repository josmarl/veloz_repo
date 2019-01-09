package pe.com.veloz.domain.dto;

import pe.com.veloz.domain.Producto;

import java.util.List;

public class ProductoMedidasDTO {
    private Producto producto;
    private List<UnidadMedidaPrecioDTO> medidas;

    public ProductoMedidasDTO() {
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<UnidadMedidaPrecioDTO> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<UnidadMedidaPrecioDTO> medidas) {
        this.medidas = medidas;
    }
}
