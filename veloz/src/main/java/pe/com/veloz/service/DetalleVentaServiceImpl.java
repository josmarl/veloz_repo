/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.veloz.domain.DetalleVenta;
import pe.com.veloz.mapper.DetalleVentaMapper;

/**
 *
 * @author josmarl
 */
@Service("detalleVentaService")
public class DetalleVentaServiceImpl implements DetalleVentaService {

    @Autowired
    public DetalleVentaMapper detalleVentaMapper;

    @Override
    public void saveDetalleVenta(DetalleVenta detalleVenta) {
        detalleVentaMapper.saveDetalleVenta(detalleVenta);
    }

}
