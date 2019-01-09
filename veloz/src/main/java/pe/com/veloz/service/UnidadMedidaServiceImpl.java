package pe.com.veloz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.veloz.domain.UnidadMedida;
import pe.com.veloz.domain.dto.UnidadMedidaPrecioDTO;
import pe.com.veloz.mapper.UnidadMedidaMapper;

import java.util.ArrayList;
import java.util.List;

@Service("unidadMedidaService")
public class UnidadMedidaServiceImpl implements UnidadMedidaService {

    @Autowired
    private UnidadMedidaMapper unidadMedidaMapper;

    @Override
    public List<UnidadMedida> listaUnidadMedida() {
        return unidadMedidaMapper.findAllUnidadesMedida();
    }

    @Override
    public List<UnidadMedida> findUnidadMedidaActive() {
        return unidadMedidaMapper.findUnidadMedidaActive();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UnidadMedidaPrecioDTO> findUnidadMedidaPrecio(Long productoId) {
        List<UnidadMedidaPrecioDTO> medidas = new ArrayList<>();
        for (UnidadMedidaPrecioDTO unidadMedida : unidadMedidaMapper.findUnidadMedidaPrecio(productoId)) {
            if (unidadMedida.getPrecio() == null) {
                unidadMedida.setEstadoCheckbox(false);
            } else {
                unidadMedida.setEstadoCheckbox(true);
            }
            medidas.add(unidadMedida);
        }
        return medidas;
    }

    @Override
    public void saveUnidadMedida(UnidadMedida unidadMedida) {
        unidadMedidaMapper.saveUnidadMedida(unidadMedida);
    }

    @Override
    public UnidadMedida findById(Long id) {
        return unidadMedidaMapper.findById(id);
    }

    @Override
    public void updateUnidadMedida(UnidadMedida unidadMedida) {
        unidadMedidaMapper.updateUnidadMedida(unidadMedida);
    }

    @Override
    public void removeUnidadMedida(Long id) {
        unidadMedidaMapper.removeUnidadMedida(id);
    }
}
