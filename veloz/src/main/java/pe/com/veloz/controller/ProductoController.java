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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.com.veloz.domain.Producto;
import pe.com.veloz.service.ProductoService;

/**
 *
 * @author eddy
 */
@RestController
@RequestMapping("/producto")
public class ProductoController {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductoService productoService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Producto> allProductos() {
        return productoService.listProductos();
    }

    @RequestMapping(value = "/edit", method = {RequestMethod.GET, RequestMethod.POST})
    public void editProducto(@RequestBody Producto producto) {
        productoService.updateProducto(producto);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void removeProducto(@PathVariable Long id) {
        productoService.removeProducto(id);
    }

    @RequestMapping(value = "/find{id}", method = {RequestMethod.GET})
    public Producto findProductoId(@PathVariable Long id) {
        productoService.findProductoById(id);
        return productoService.findProductoById(id);
    }

    @RequestMapping(value = "/find{nombre}", method = {RequestMethod.GET})
    public Producto findProductoNombre(@PathVariable String nombre) {
        productoService.findProductoByNombre(nombre);
        return productoService.findProductoByNombre(nombre);
    }

    @RequestMapping(value = "/find{marca}", method = {RequestMethod.GET})
    public Producto findProductoMarca(@PathVariable String marca) {
        productoService.findProductoByMarca(marca);
        return productoService.findProductoByMarca(marca);
    }

    @RequestMapping(value = "/find{code}", method = {RequestMethod.GET})
    public Producto findProductoCode(@PathVariable String code) {
        productoService.findProductoByCode(code);
        return productoService.findProductoByCode(code);
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public void saveProducto(@RequestBody Producto producto) {
        productoService.saveProducto(producto);
    }
}
