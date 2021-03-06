/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.List;

import pe.com.veloz.domain.Producto;
import pe.com.veloz.domain.dto.ProductoMedidasDTO;

/**
 * @author eddy
 */
public interface ProductoService {

    List<Producto> findAll();

    void removeProductoMedidas(Long id);

    void updateProductoMedidas(ProductoMedidasDTO productoMedidasDTO);

    Producto findProductoById(Long id);

    Producto findProductoByNombre(String nombre);

    Producto findProductoByMarca(String marca);

    Producto findProductoByCode(String code);

    Producto findProductoByNombreMarca(String nombre, String marca);

    void saveProductoMedidas(ProductoMedidasDTO productoMedidasDTO);
}
