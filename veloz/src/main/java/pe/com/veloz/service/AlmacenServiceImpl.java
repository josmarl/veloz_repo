/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.veloz.domain.Almacen;
import pe.com.veloz.mapper.AlmacenMapper;

/**
 *
 * @author josmarl
 */
@Service("almacenService")
public class AlmacenServiceImpl implements AlmacenService {

    @Autowired
    public AlmacenMapper almacenMapper;

    @Override
    public List<Almacen> findAllAlmacen() {
        return almacenMapper.findAllAlmacen();
    }

    @Override
    public void saveAlmacen(Almacen almacen) {
        almacenMapper.saveAlmacen(almacen);
    }

}
