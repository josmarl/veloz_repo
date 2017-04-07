/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.veloz.controller.constants.Constants;
import pe.com.veloz.domain.dto.DetalleProductoDTO;
import pe.com.veloz.domain.dto.ProductoVentaDTO;
import pe.com.veloz.service.VentaService;
import pe.com.veloz.utils.AppUtils;

/**
 *
 * @author josmarl
 */
@RestController
@RequestMapping("/venta")
public class VentaController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private VentaService ventaService;

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public List<ProductoVentaDTO> addCarrito(@RequestBody DetalleProductoDTO data) {

        List<ProductoVentaDTO> detalles = new ArrayList<>();

        for (ProductoVentaDTO detalle : data.getDetalles()) {
            if (detalle.getCantidad() >= Constants.UNITARIO && detalle.getCantidad() < Constants.DOCENA) {
                detalle.setImporte(AppUtils.redondear(detalle.getProducto().getPrecioUnit() * detalle.getCantidad()));
                detalle.setPrecioUnitario(detalle.getProducto().getPrecioUnit());
            }
            if (detalle.getCantidad() >= Constants.DOCENA && detalle.getCantidad() < Constants.CINCUENTA) {
                detalle.setImporte(AppUtils.redondear(detalle.getProducto().getPrecioDocena() * detalle.getCantidad()));
                detalle.setPrecioUnitario(detalle.getProducto().getPrecioDocena());
            }
            if (detalle.getCantidad() >= Constants.CINCUENTA && detalle.getCantidad() < Constants.CIENTO) {
                detalle.setImporte(AppUtils.redondear(detalle.getProducto().getPrecioCincuenta() * detalle.getCantidad()));
                detalle.setPrecioUnitario(detalle.getProducto().getPrecioCincuenta());
            }
            if (detalle.getCantidad() >= Constants.CIENTO) {
                detalle.setImporte(AppUtils.redondear(detalle.getProducto().getPrecioCiento() * detalle.getCantidad()));
                detalle.setPrecioUnitario(detalle.getProducto().getPrecioCiento());
            }
            detalles.add(detalle);
        }

        return detalles;

    }
}
