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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.veloz.domain.Almacen;
import pe.com.veloz.domain.AlmacenConsolidado;
import pe.com.veloz.domain.AlmacenDetalle;
import pe.com.veloz.domain.Cliente;
import pe.com.veloz.domain.Usuario;
import pe.com.veloz.domain.dto.AlmacenDTO;
import pe.com.veloz.domain.dto.ProductoAlmacenDTO;
import pe.com.veloz.service.AlmacenConsolidadoService;
import pe.com.veloz.service.AlmacenDetalleService;
import pe.com.veloz.service.AlmacenService;
import pe.com.veloz.service.ClienteService;

/**
 * @author josmarl
 */
@RestController
@RequestMapping("/almacen")
public class AlmacenController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private AlmacenService almacenService;

    @Autowired
    private AlmacenDetalleService almacenDetalleService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AlmacenConsolidadoService almacenConsolidadoService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/all", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Almacen> findAllAlmacen() {
        return almacenService.findAllAlmacen();
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public void saveAlmacen(@RequestBody AlmacenDTO data) {

        List<AlmacenConsolidado> listAlmacenConsolidado = almacenConsolidadoService.findAll();
        List<ProductoAlmacenDTO> listaAlmacenTemp = data.getDetalles();
        List<ProductoAlmacenDTO> listAlmacenToDelete = new ArrayList<>();
        Usuario userDetails = (Usuario) request.getSession().getAttribute("userDetails");
        Almacen almacen = new Almacen();

        /**
         * Se valida si el cliente existe Si no existe se crea el cliente.
         */
        if (data.getCliente().getId() != null) {
            almacen.setCliente(data.getCliente().getId());
        } else {
            Cliente cliente = new Cliente();
            cliente.setDireccion("");
            cliente.setDni(0l);
            cliente.setRuc(0l);
            cliente.setRazonSocial(data.getCliente().getRazonSocial());
            clienteService.saveCliente(cliente);
            almacen.setCliente(cliente.getId());
        }

        /**
         * Se crea la cabecera del almacen.
         */
        almacen.setNroDoc(data.getNroDoc());
        almacen.setUsuario(userDetails.getId());
        almacen.setFechaReg(new Date());
        almacenService.saveAlmacen(almacen);

        /**
         * Se inserta el detalle del almacen.
         */
        for (ProductoAlmacenDTO detalle : data.getDetalles()) {
            AlmacenDetalle almacenDetalle = new AlmacenDetalle();
            almacenDetalle.setAlmacen(almacen.getId());
            almacenDetalle.setCantidad(detalle.getCantidad());
            almacenDetalle.setProducto(detalle.getProducto().getId());
            almacenDetalle.setImporte(detalle.getImporte());
            almacenDetalleService.saveAlmacenDetalle(almacenDetalle);
        }

        /**
         * Se valida si existe datos en la tabla Almacen consolidado.
         */
        if (listAlmacenConsolidado.size() > 0) {
            for (ProductoAlmacenDTO almacenDTO : data.getDetalles()) {
                for (AlmacenConsolidado almacenConsolidado : listAlmacenConsolidado) {
                    if (almacenConsolidado.getProductoObj().getId().equals(almacenDTO.getProducto().getId())) {
                        AlmacenConsolidado almToUpdate = new AlmacenConsolidado();
                        almToUpdate.setId(almacenConsolidado.getId());
                        almToUpdate.setDisponible(almacenConsolidado.getDisponible() + almacenDTO.getCantidad());
                        almacenConsolidadoService.updateAlmacenConsolidadoDisponible(almToUpdate);
                        listAlmacenToDelete.add(data.getDetalles().get(data.getDetalles().indexOf(almacenDTO)));
                    }
                }
            }

            /**
             * Se elimina los productos que existen en el almacen consolidado,
             * quedando así sólo los productos nuevos que no están en el la
             * tabla almacen consolidado.
             */
            if (listAlmacenToDelete.size() > 0) {
                for (ProductoAlmacenDTO index : listAlmacenToDelete) {
                    listaAlmacenTemp.remove(index);
                }

                /**
                 * Si hay algún producto nuevo ingresando al almacen consolidad,
                 * entonces se inserta el registro.
                 */
                for (ProductoAlmacenDTO almacenTemp : listaAlmacenTemp) {
                    AlmacenConsolidado almToSave = new AlmacenConsolidado();
                    almToSave.setProducto(almacenTemp.getProducto().getId());
                    almToSave.setVendido(0l);
                    almToSave.setDisponible(almacenTemp.getCantidad());
                    almacenConsolidadoService.saveAlmacenConsolidado(almToSave);
                }
            }

        } else {
            /**
             * Si no existen datos en la tabla de almacen consolidado, entonces
             * se insertan los datos del almacen detalle por primera vez.
             */
            for (ProductoAlmacenDTO detalle : data.getDetalles()) {
                AlmacenConsolidado almacenConsolidado = new AlmacenConsolidado();
                almacenConsolidado.setProducto(detalle.getProducto().getId());
                almacenConsolidado.setDisponible(detalle.getCantidad());
                almacenConsolidado.setVendido(0l);
                almacenConsolidadoService.saveAlmacenConsolidado(almacenConsolidado);
            }
        }

    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void removeAlmacen(@PathVariable Long id) {
        almacenService.removeAlmacen(id);
    }

    @RequestMapping(value = "/find/{id}")
    public Almacen findAlmacenById(@PathVariable Long id) {
        return almacenService.findAlmacenById(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void updateAlmacen(@RequestBody Almacen data) {
        almacenService.updateAlmacen(data);
    }
}
