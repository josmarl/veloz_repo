package pe.com.veloz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.veloz.domain.dto.ProductoUnidadMedidaDTO;
import pe.com.veloz.mapper.ProductoUnidadMedidaMapper;

import java.util.List;

@Service("productoUnidadMedidaService")
public class ProductoUnidadMedidaServiceImpl implements ProductoUnidadMedidaService {

    @Autowired
    private ProductoUnidadMedidaMapper productoUnidadMedidaMapper;

    public List<ProductoUnidadMedidaDTO> findProductoUnidadMedidaByProd(Long productoId) {
        return productoUnidadMedidaMapper.findByProductoId(productoId);
    }

    public List<ProductoUnidadMedidaDTO> findProductoUnidadMedidaByProdAndMed(Long productoId, Long unidadMedidaId) {
        return productoUnidadMedidaMapper.findByProductoAndMedida(productoId, unidadMedidaId);
    }

}
