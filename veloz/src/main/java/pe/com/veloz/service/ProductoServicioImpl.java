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
 *
 * @author eddy
 */

@Service("productoService")
public class ProductoServicioImpl implements ProductoService{

    @Autowired
    private ProductoMapper productoMapper;
    
    @Override
    public List<Producto> findProductos() {
        return productoMapper.findProductos();
    }
    
}
