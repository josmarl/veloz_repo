/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.List;

import pe.com.veloz.domain.Producto;

/**
 * @author eddy
 */
public interface ProductoService {

    List<Producto> findAll();

    void removeProducto(Long id);

    void updateProducto(Producto producto);

    Producto findProductoById(Long id);

    Producto findProductoByNombre(String nombre);

    Producto findProductoByMarca(String marca);

    Producto findProductoByCode(String code);

    Producto findProductoByNombreMarca(String nombre, String marca);

    void saveProducto(Producto producto);
}
