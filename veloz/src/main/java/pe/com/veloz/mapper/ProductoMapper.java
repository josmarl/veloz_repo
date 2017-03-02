/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pe.com.veloz.domain.Producto;

/**
 *
 * @author eddy
 */

@Mapper
public interface ProductoMapper {
    
    @Select("select id, nombre, descripcion, precio_unit as precioUnit, precio_docena as precioDocena, precio_ciento as precioCiento, precio_cincuenta as precioCincuenta, precio_compra as precioCompra, precio_venta as precioVenta, estado, stock from producto")
    List<Producto> findProductos();
    
    
}
