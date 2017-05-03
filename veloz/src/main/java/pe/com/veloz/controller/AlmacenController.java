/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.veloz.domain.Almacen;
import pe.com.veloz.domain.AlmacenDetalle;
import pe.com.veloz.domain.Cliente;
import pe.com.veloz.domain.Usuario;
import pe.com.veloz.domain.dto.AlmacenDTO;
import pe.com.veloz.domain.dto.ProductoAlmacenDTO;
import pe.com.veloz.domain.dto.ProductoVentaDTO;
import pe.com.veloz.service.AlmacenDetalleService;
import pe.com.veloz.service.AlmacenService;
import pe.com.veloz.service.ClienteService;

/**
 *
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
    private HttpServletRequest request;

    @RequestMapping(value = "/all", method = {RequestMethod.GET, RequestMethod.POST})
    public List<Almacen> findAllAlmacen() {
        return almacenService.findAllAlmacen();
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public void saveAlmacen(@RequestBody AlmacenDTO data) {

        System.out.println("juan " + data.toString());

        Usuario userDetails = (Usuario) request.getSession().getAttribute("userDetails");
        Almacen almacen = new Almacen();

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

        almacen.setNroDoc(data.getNroDoc());
        almacen.setUsuario(userDetails.getId());
        almacenService.saveAlmacen(almacen);

        for (ProductoAlmacenDTO detalle : data.getDetalles()) {
            AlmacenDetalle almacenDetalle = new AlmacenDetalle();
            almacenDetalle.setAlmacen(almacen.getId());
            almacenDetalle.setCantidad(detalle.getCantidad());
            almacenDetalle.setProducto(detalle.getProducto().getId());
            almacenDetalleService.saveAlmacenDetalle(almacenDetalle);
        }

    }
}
