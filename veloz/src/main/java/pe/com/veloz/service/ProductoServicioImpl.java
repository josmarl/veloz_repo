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
import pe.com.veloz.domain.dto.ProductoMedidasDTO;
import pe.com.veloz.domain.dto.UnidadMedidaPrecioDTO;
import pe.com.veloz.mapper.ProductoMapper;
import pe.com.veloz.mapper.ProductoUnidadMedidaMapper;

/**
 * @author eddy
 */
@Service("productoService")
public class ProductoServicioImpl implements ProductoService {

    @Autowired
    private ProductoMapper productoMapper;
    @Autowired
    private ProductoUnidadMedidaMapper productoUnidadMedidaMapper;

    @Override
    public List<Producto> findAll() {
        return productoMapper.findAll();
    }

    @Override
    @Transactional
    public void removeProductoMedidas(Long id) {
        productoUnidadMedidaMapper.removeProductoUnidadMedida(id);
        productoMapper.removeProducto(id);
    }

    @Override
    @Transactional
    public void updateProductoMedidas(ProductoMedidasDTO productoMedidasDTO) {
        productoMapper.updateProducto(productoMedidasDTO.getProducto());
        productoUnidadMedidaMapper.removeProductoUnidadMedida(productoMedidasDTO.getProducto().getId());
        List<UnidadMedidaPrecioDTO> medidas = productoMedidasDTO.getMedidas();
        for (UnidadMedidaPrecioDTO unidadMedida : medidas) {
            if (unidadMedida.getPrecio() != null && unidadMedida.isEstadoCheckbox()) {
                ProductoUnidadMedida productoUnidadMedida = new ProductoUnidadMedida();
                productoUnidadMedida.setProducto(productoMedidasDTO.getProducto().getId());
                productoUnidadMedida.setUnidadMedida(unidadMedida.getId());
                productoUnidadMedida.setPrecio(unidadMedida.getPrecio());
                productoUnidadMedidaMapper.saveProductoUnidadMedida(productoUnidadMedida);
            }
        }
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
            if (unidadMedida.getPrecio() != null && unidadMedida.isEstadoCheckbox()) {
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
