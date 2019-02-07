package pe.com.veloz.service;

import pe.com.veloz.domain.dto.ProductoUnidadMedidaDTO;

import java.util.List;

public interface ProductoUnidadMedidaService {

    List<ProductoUnidadMedidaDTO> findProductoUnidadMedidaByProd(Long productoId);

    List<ProductoUnidadMedidaDTO> findProductoUnidadMedidaByProdAndMed(Long productoId, Long unidadMedidaId);
}
