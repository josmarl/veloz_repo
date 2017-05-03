/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.veloz.domain.AlmacenDetalle;
import pe.com.veloz.mapper.AlmacenDetalleMapper;

/**
 *
 * @author josmarl
 */
@Service("almacenDetalleService")
public class AlmacenDetalleServiceImpl implements AlmacenDetalleService {

    @Autowired
    public AlmacenDetalleMapper almacenDetalleMapper;

    @Override
    public void saveAlmacenDetalle(AlmacenDetalle almacenDetalle) {
        almacenDetalleMapper.saveAlmacenDetalle(almacenDetalle);
    }

}
