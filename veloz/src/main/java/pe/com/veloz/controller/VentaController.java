/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.veloz.controller.constants.Constants;
import pe.com.veloz.domain.*;
import pe.com.veloz.domain.dto.*;
import pe.com.veloz.enums.TipoComprobanteEnum;
import pe.com.veloz.service.*;
import pe.com.veloz.utils.AppUtils;

/**
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
    private AlmacenConsolidadoService almacenConsolidadoService;

    @Autowired
    private CorrelativoService correlativoService;

    @Autowired
    private ProductoUnidadMedidaService productoUnidadMedidaService;

    @Autowired
    private UnidadMedidaService unidadMedidaService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/stock", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseDTO validarStockProducto(@RequestBody DetalleProductoDTO data) {

        ProductoVentaDTO productoVentaDTO = data.getDetalles().get(0);
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            AlmacenConsolidado almacenConsolidado = almacenConsolidadoService.findByProducto(productoVentaDTO.getProducto().getId());
            UnidadMedida unidadMedida = unidadMedidaService.findById(productoVentaDTO.getUnidadMedidadId());
            int cantidad = productoVentaDTO.getCantidad() * unidadMedida.getCantidad();
            if (cantidad > almacenConsolidado.getDisponible()) {
                Long cantidadExceso = cantidad - almacenConsolidado.getDisponible();
                Long cantidadDisponible = Math.abs(cantidadExceso - cantidad);
                responseDTO.setMsg(Constants.MSG_FAILED_STOCK
                        + "\n" + " Sólo quedan "
                        + cantidadDisponible + " unidades del producto : \n"
                        + productoVentaDTO.getProducto().getNombre());
                responseDTO.setObject(false);
            } else {
                responseDTO.setObject(true);
            }
        } catch (Exception e) {
            logger.error(e);
        }

        return responseDTO;
    }

    @GetMapping("/prodUnidadMed/find/{productoId}")
    public List<ProductoUnidadMedidaDTO> findProductoUnidadMedida(@PathVariable Long productoId) {
        return productoUnidadMedidaService.findProductoUnidadMedidaByProd(productoId);
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public VentaDTO addCarrito(@RequestBody DetalleProductoDTO data) {

        VentaDTO ventaDTO = new VentaDTO();
        List<ProductoVentaDTO> detalles = new ArrayList<>();
        double total = 0;

        for (ProductoVentaDTO detalle : data.getDetalles()) {
            List<ProductoUnidadMedidaDTO> productoUnidadMedidas = productoUnidadMedidaService.findProductoUnidadMedidaByProdAndMed(detalle.getProducto().getId(), detalle.getUnidadMedidadId());
            if (productoUnidadMedidas.size() > 0) {
                detalle.setImporte(detalle.getCantidad() * productoUnidadMedidas.get(0).getPrecio());
                detalle.setPrecioUnitario(productoUnidadMedidas.get(0).getPrecio());
                detalle.setUnidadMedidaNombre(productoUnidadMedidas.get(0).getUnidadMedidaNombre());
            }
            detalles.add(detalle);
            total = total + detalle.getImporte();
        }

        ventaDTO.setDetalles(detalles);
        ventaDTO.setTotal(total);

        return ventaDTO;
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
                baseImponible = total / 1.18;
                igv = total - baseImponible;
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
        Correlativo correlativo = correlativoService.findActive();
        Venta venta = new Venta();

        /**
         * Aqui se valida la existencia del cliente,y si no existe, se registra
         * un nuevo cliente.
         */
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

        /**
         * Se actualiza el correlativo.
         */
        correlativo.setCorrelativo(correlativo.getCorrelativo() + 1);
        correlativoService.updateCorrelativo(correlativo);

        /**
         * Aqui se guarda la venta.
         */
        venta.setUsuario(userDetails.getId());
        venta.setBaseImponible(data.getBaseImponible());
        venta.setIgv(data.getIgv());
        venta.setTotal(data.getTotal());
        venta.setUsuario(userDetails.getId());
        venta.setNroDoc(correlativo.getSerie() + "-" + correlativo.getCorrelativo());
        venta.setFechaReg(new Date());
        ventaService.saveVenta(venta);

        /**
         * Aqui se guarda los detalles de venta.
         */
        for (ProductoVentaDTO detalle : data.getDetalles()) {
            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setCantidad(detalle.getCantidad());
            detalleVenta.setImporte(detalle.getImporte());
            detalleVenta.setProducto(detalle.getProducto().getId());
            detalleVenta.setVenta(venta.getId());
            detalleVentaService.saveDetalleVenta(detalleVenta);

            /**
             * Actualizacion del almacen consolidado.
             */
            AlmacenConsolidado almacenConsolidado = almacenConsolidadoService.findByProducto(detalle.getProducto().getId());
            almacenConsolidado.setDisponible(Math.abs(almacenConsolidado.getDisponible() - detalle.getCantidad()));
            almacenConsolidado.setVendido(Math.abs(almacenConsolidado.getVendido() + detalle.getCantidad()));
            almacenConsolidadoService.updateAlmacenConsolidadoStock(almacenConsolidado);
        }
    }

}
