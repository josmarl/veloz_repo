/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.veloz.domain.Producto;
import pe.com.veloz.domain.UnidadMedida;
import pe.com.veloz.domain.dto.ProductoMedidasDTO;
import pe.com.veloz.domain.dto.UnidadMedidaPrecioDTO;
import pe.com.veloz.service.ProductoService;
import pe.com.veloz.service.UnidadMedidaService;

/**
 * @author eddy
 */
@RestController
@RequestMapping("/producto")
public class ProductoController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductoService productoService;
    @Autowired
    private UnidadMedidaService unidadMedidaService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Producto> allProductos() {
        return productoService.findAll();
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public void saveProducto(@RequestBody ProductoMedidasDTO data) {
        try {
            productoService.saveProductoMedidas(data);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ProductoController.saveProducto");
        }
    }

    @PutMapping("/edit")
    public void editProducto(@RequestBody ProductoMedidasDTO data) {
        try {
            productoService.updateProductoMedidas(data);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ProductoController.editProducto");
        }
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void removeProducto(@PathVariable Long id) {
        try {
            productoService.removeProductoMedidas(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ProductoController.removeProducto");
        }
    }

    @RequestMapping(value = "/find/{id}", method = {RequestMethod.GET})
    public Producto findProductoId(@PathVariable Long id) {
        return productoService.findProductoById(id);
    }

    @RequestMapping(value = "/find/name/{nombre}/{marca}", method = {RequestMethod.GET})
    public ResponseEntity<Boolean> validarExistsNombreMarcaProducto(@PathVariable String nombre, @PathVariable String marca) {
        boolean exists = false;
        Producto producto = productoService.findProductoByNombreMarca(nombre, marca);
        exists = producto != null;
        return new ResponseEntity<Boolean>(exists, HttpStatus.OK);
    }

    @RequestMapping(value = "/find/code/{code}", method = {RequestMethod.GET})
    public ResponseEntity<Boolean> validarExistsCodeProducto(@PathVariable String code) {
        boolean exists = false;
        Producto producto = productoService.findProductoByCode(code);
        exists = producto != null;
        return new ResponseEntity<Boolean>(exists, HttpStatus.OK);
    }

    @GetMapping("/medida/find/active")
    public List<UnidadMedida> listUnidadMedidaActive() {
        return unidadMedidaService.findUnidadMedidaActive();
    }

    @GetMapping("/medida/find/precio/{productoId}")
    public List<UnidadMedidaPrecioDTO> listUnidadMedidaPrecio(@PathVariable Long productoId) {
        return unidadMedidaService.findUnidadMedidaPrecio(productoId);
    }

}
