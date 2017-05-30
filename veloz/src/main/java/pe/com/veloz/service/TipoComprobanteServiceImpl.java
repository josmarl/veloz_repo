/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import pe.com.veloz.domain.TipoComprobante;
import pe.com.veloz.enums.TipoComprobanteEnum;

/**
 *
 * @author josmarl
 */
@Service("tipoComprobanteService")
public class TipoComprobanteServiceImpl implements TipoComprobanteService {

    @Override
    public List<TipoComprobante> findAll() {
        List<TipoComprobante> list = new ArrayList<>();

        TipoComprobante factura = new TipoComprobante();
        factura.setId(TipoComprobanteEnum.TIPO_FACTURA.getId());
        factura.setNombre(TipoComprobanteEnum.TIPO_FACTURA.getNombre());
        factura.setCodigo(TipoComprobanteEnum.TIPO_FACTURA.getCodigo());
        factura.setEstado(TipoComprobanteEnum.TIPO_FACTURA.getEstado());

        TipoComprobante boleta = new TipoComprobante();
        boleta.setId(TipoComprobanteEnum.TIPO_BOLETA.getId());
        boleta.setNombre(TipoComprobanteEnum.TIPO_BOLETA.getNombre());
        boleta.setCodigo(TipoComprobanteEnum.TIPO_BOLETA.getCodigo());
        boleta.setEstado(TipoComprobanteEnum.TIPO_BOLETA.getEstado());

        list.add(factura);
        list.add(boleta);

        return list;
    }

}
