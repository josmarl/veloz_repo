/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.List;
import pe.com.veloz.domain.AlmacenConsolidado;

/**
 *
 * @author josmarl
 */
public interface AlmacenConsolidadoService {

    List<AlmacenConsolidado> findAll();

    void saveAlmacenConsolidado(AlmacenConsolidado almacenConsolidado);

    void updateAlmacenConsolidadoDisponible(AlmacenConsolidado almacenConsolidado);

    void updateAlmacenConsolidadoStock(AlmacenConsolidado almacenConsolidado);

    AlmacenConsolidado findByProducto(Long id);

}
