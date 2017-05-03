/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.veloz.controller.constants.Constants;
import pe.com.veloz.domain.Cliente;
import pe.com.veloz.domain.DetalleVenta;
import pe.com.veloz.domain.Usuario;
import pe.com.veloz.domain.Venta;
import pe.com.veloz.domain.dto.DetalleProductoDTO;
import pe.com.veloz.domain.dto.ProductoVentaDTO;
import pe.com.veloz.domain.dto.VentaDTO;
import pe.com.veloz.enums.TipoComprobanteEnum;
import pe.com.veloz.service.ClienteService;
import pe.com.veloz.service.DetalleVentaService;
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

    @Autowired
    private DetalleVentaService detalleVentaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private HttpServletRequest request;

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

    @RequestMapping(value = "/tipocomp/totales", method = {RequestMethod.GET, RequestMethod.POST})
    public VentaDTO getDatosTipoComprobante(@RequestBody DetalleProductoDTO data) {

        double baseImponible = 0;
        double igv = 0;
        double total = 0;

        if (data.getTipoComprobante() != null) {
            for (ProductoVentaDTO producto : data.getDetalles()) {
                total = total + producto.getImporte();
            }

            if (data.getTipoComprobante().getCodigo().equals(TipoComprobanteEnum.TIPO_FACTURA.getCodigo())) {
                igv = total * Constants.IGV_ACTUAL;
                baseImponible = total - igv;
            }
        }

        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setBaseImponible(AppUtils.redondear(baseImponible));
        ventaDTO.setIgv(AppUtils.redondear(igv));
        ventaDTO.setTotal(AppUtils.redondear(total));

        return ventaDTO;
    }

    @RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
    public void guardarVenta(@RequestBody VentaDTO data) {

        Usuario userDetails = (Usuario) request.getSession().getAttribute("userDetails");
        Venta venta = new Venta();

        if (data.getCliente().getId() != null) {
            venta.setCliente(data.getCliente().getId());

        } else {
            Cliente cliente = new Cliente();
            cliente.setDireccion("");
            cliente.setDni(0l);
            cliente.setRuc(0l);
            cliente.setRazonSocial(data.getCliente().getRazonSocial());
            clienteService.saveCliente(cliente);
            venta.setCliente(cliente.getId());
        }

        venta.setUsuario(userDetails.getId());
        venta.setBaseImponible(data.getBaseImponible());
        venta.setIgv(data.getIgv());
        venta.setTotal(data.getTotal());
        venta.setUsuario(userDetails.getId());
        ventaService.saveVenta(venta);

        for (ProductoVentaDTO detalle : data.getDetalles()) {
            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setCantidad(detalle.getCantidad());
            detalleVenta.setImporte(detalle.getImporte());
            detalleVenta.setProducto(detalle.getProducto().getId());
            detalleVenta.setVenta(venta.getId());
            detalleVentaService.saveDetalleVenta(detalleVenta);
        }
    }

}
