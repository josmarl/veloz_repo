/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.List;
import pe.com.veloz.domain.Venta;

/**
 *
 * @author josmarl
 */
public interface VentaService {

    List<Venta> findAll();

    void saveVenta(Venta venta);

}
