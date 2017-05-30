/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.veloz.domain.AlmacenConsolidado;
import pe.com.veloz.mapper.AlmacenConsolidadoMapper;

/**
 *
 * @author josmarl
 */
@Service("almacenConsolidadoService")
public class AlmacenConsolidadoServiceImpl implements AlmacenConsolidadoService {

    @Autowired
    public AlmacenConsolidadoMapper almacenConsolidadoMapper;

    @Override
    public void saveAlmacenConsolidado(AlmacenConsolidado almacenConsolidado) {
        almacenConsolidadoMapper.saveAlmacenConsolidado(almacenConsolidado);
    }

    @Override
    public void updateAlmacenConsolidadoDisponible(AlmacenConsolidado almacenConsolidado) {
        almacenConsolidadoMapper.updateAlmacenConsolidadoDisponible(almacenConsolidado);
    }

    @Override
    public List<AlmacenConsolidado> findAll() {
        return almacenConsolidadoMapper.findAll();
    }

    @Override
    public AlmacenConsolidado findByProducto(Long id) {
        return almacenConsolidadoMapper.findByProducto(id);
    }

    @Override
    public void updateAlmacenConsolidadoStock(AlmacenConsolidado almacenConsolidado) {
        almacenConsolidadoMapper.updateAlmacenConsolidadoStock(almacenConsolidado);
    }

}
