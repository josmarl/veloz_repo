package pe.com.veloz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.veloz.domain.UnidadMedida;
import pe.com.veloz.service.UnidadMedidaService;

import java.util.List;

@RestController
@RequestMapping("/medida")
public class UnidadMedidaController {

    @Autowired
    private UnidadMedidaService unidadMedidaService;

    @GetMapping("/all")
    public List<UnidadMedida> listaUnidadMedida() {
        return unidadMedidaService.listaUnidadMedida();
    }

}
