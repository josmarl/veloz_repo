/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.veloz.domain.Producto;
import pe.com.veloz.mapper.ProductoMapper;

/**
 * @author eddy
 */
@Service("productoService")
public class ProductoServicioImpl implements ProductoService {

    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public List<Producto> findAll() {
        return productoMapper.findAll();
    }

    @Override
    public void removeProducto(Long id) {
        productoMapper.removeProducto(id);
    }

    @Override
    public void updateProducto(Producto producto) {
        productoMapper.updateProducto(producto);
    }

    @Override
    public Producto findProductoById(Long id) {
        return productoMapper.findProductoById(id);
    }

    @Override
    public Producto findProductoByNombre(String nombre) {
        return productoMapper.findProductoByNombre(nombre);
    }

    @Override
    public void saveProducto(Producto producto) {
        productoMapper.saveProducto(producto);
    }

    @Override
    public Producto findProductoByMarca(String marca) {
        return productoMapper.findProductoByMarca(marca);
    }

    @Override
    public Producto findProductoByCode(String code) {
        return productoMapper.findProductoByCode(code);
    }

    @Override
    public Producto findProductoByNombreMarca(String nombre, String marca) {
        return productoMapper.findProductoByNombreMarca(nombre, marca);
    }

}
