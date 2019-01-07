package pe.com.veloz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.veloz.domain.UnidadMedida;
import pe.com.veloz.mapper.UnidadMedidaMapper;

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
    public void saveUnidadMedida(UnidadMedida unidadMedida) {
        unidadMedidaMapper.saveUnidadMedida(unidadMedida);
    }
}
