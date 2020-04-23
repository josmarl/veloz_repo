package pe.com.veloz.service;

import pe.com.veloz.domain.UnidadMedida;
import pe.com.veloz.domain.dto.UnidadMedidaPrecioDTO;

import java.util.List;

public interface UnidadMedidaService {

    public List<UnidadMedida> listaUnidadMedida();

    public List<UnidadMedida> findUnidadMedidaActive();

    public List<UnidadMedidaPrecioDTO> findUnidadMedidaPrecio(Long productoId);

    public void saveUnidadMedida(UnidadMedida unidadMedida);

    public UnidadMedida findById(Long id);

    public void updateUnidadMedida(UnidadMedida unidadMedida);

    public void removeUnidadMedida(Long id);

}
