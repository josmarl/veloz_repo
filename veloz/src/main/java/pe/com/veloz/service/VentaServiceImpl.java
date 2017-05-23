/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.veloz.domain.Venta;
import pe.com.veloz.mapper.VentaMapper;

/**
 *
 * @author josmarl
 */
@Service("ventaService")
public class VentaServiceImpl implements VentaService {

    @Autowired
    public VentaMapper ventaMapper;

    @Override
    public void saveVenta(Venta venta) {
        ventaMapper.saveVenta(venta);
    }

    @Override
    public List<Venta> findAll() {
        return ventaMapper.findAll();
    }

}
