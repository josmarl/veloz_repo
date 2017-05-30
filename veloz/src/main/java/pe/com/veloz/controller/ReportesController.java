/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.veloz.domain.dto.ReporteDTO;
import pe.com.veloz.domain.dto.ResponseDTO;
import pe.com.veloz.enums.ReporteEnum;
import pe.com.veloz.service.AlmacenConsolidadoService;
import pe.com.veloz.service.VentaService;

/**
 *
 * @author josmarl
 */
@RestController
@RequestMapping("/reportes")
public class ReportesController {

    @Autowired
    private AlmacenConsolidadoService almacenConsolidadoService;

    @Autowired
    private VentaService ventaService;

    @RequestMapping(value = "/nreportes", method = RequestMethod.GET)
    public List<ReporteDTO> getReportes() {

        List<ReporteDTO> listReportes = new ArrayList<>();

        ReporteDTO aconsolidado = new ReporteDTO();
        aconsolidado.setId(ReporteEnum.R_ALMACEN_CONSOLIDADO.getId());
        aconsolidado.setNombre(ReporteEnum.R_ALMACEN_CONSOLIDADO.getNombre());

        ReporteDTO ventas = new ReporteDTO();
        ventas.setId(ReporteEnum.R_VENTAS.getId());
        ventas.setNombre(ReporteEnum.R_VENTAS.getNombre());

        listReportes.add(aconsolidado);
        listReportes.add(ventas);

        return listReportes;
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public ResponseDTO findReport(@PathVariable int id) {

        ResponseDTO responseDTO = new ResponseDTO();

        if (ReporteEnum.R_ALMACEN_CONSOLIDADO.getId() == id) {
            responseDTO.setObject(almacenConsolidadoService.findAll());
        }
        if (ReporteEnum.R_VENTAS.getId() == id) {
            responseDTO.setObject(ventaService.findAll());
        }

        return responseDTO;
    }

}
