/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.veloz.domain.Correlativo;
import pe.com.veloz.mapper.CorrelativoMapper;

/**
 *
 * @author josmarl
 */
@Service("correlativoService")
public class CorrelativoServiceImpl implements CorrelativoService {

    @Autowired
    CorrelativoMapper correlativoMapper;

    @Override
    public Correlativo findActive() {
        return correlativoMapper.findActive();
    }

    @Override
    public void updateCorrelativo(Correlativo correlativo) {
        correlativoMapper.updateCorrelativo(correlativo);
    }

}
