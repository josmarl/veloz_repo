/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.veloz.domain.Producto;
import pe.com.veloz.domain.ProductoUnidadMedida;
import pe.com.veloz.domain.UnidadMedida;
import pe.com.veloz.domain.dto.ProductoMedidasDTO;
import pe.com.veloz.domain.dto.UnidadMedidaPrecioDTO;
import pe.com.veloz.mapper.ProductoMapper;
import pe.com.veloz.mapper.ProductoUnidadMedidaMapper;
import pe.com.veloz.mapper.UnidadMedidaMapper;

/**
 * @author eddy
 */
@Service("productoService")
public class ProductoServicioImpl implements ProductoService {

    @Autowired
    private ProductoMapper productoMapper;
    @Autowired
    private UnidadMedidaMapper unidadMedidaMapper;
    @Autowired
    private ProductoUnidadMedidaMapper productoUnidadMedidaMapper;

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
    @Transactional
    public void saveProductoMedidas(ProductoMedidasDTO productoMedidasDTO) {
        Producto producto = productoMedidasDTO.getProducto();
        productoMapper.saveProducto(producto);
        List<UnidadMedidaPrecioDTO> medidas = productoMedidasDTO.getMedidas();
        for (UnidadMedidaPrecioDTO unidadMedida : medidas) {
            if (unidadMedida.getPrecio() != null) {
                ProductoUnidadMedida productoUnidadMedida = new ProductoUnidadMedida();
                productoUnidadMedida.setProducto(producto.getId());
                productoUnidadMedida.setUnidadMedida(unidadMedida.getId());
                productoUnidadMedida.setPrecio(unidadMedida.getPrecio());
                productoUnidadMedidaMapper.saveProductoUnidadMedida(productoUnidadMedida);
            }
        }
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
