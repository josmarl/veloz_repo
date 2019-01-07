package pe.com.veloz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/add")
    public ResponseEntity<UnidadMedida> saveUnidadMedida(@RequestBody UnidadMedida unidadMedida) {
        unidadMedidaService.saveUnidadMedida(unidadMedida);
        return new ResponseEntity<UnidadMedida>(unidadMedida, HttpStatus.OK);
    }

}
