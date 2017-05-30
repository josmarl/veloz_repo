/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import pe.com.veloz.domain.Correlativo;

/**
 *
 * @author josmarl
 */
public interface CorrelativoService {

    Correlativo findActive();
    
     void updateCorrelativo(Correlativo correlativo);
}
