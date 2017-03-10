/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pe.com.veloz.domain.DetalleVenta;

/**
 *
 * @author server-itecs
 */
@Mapper
public interface DetalleVentaMapper {

    @Insert("insert into detalle_venta(producto,cantidad,total,base_imponible,igv,venta) "
            + "values (#{detalleVenta.producto},"
            + "#{detalleVenta.cantidad},"
            + "#{detalleVenta.total},"
            + "#{detalleVenta.baseImponible},"
            + "#{detalleVenta.igv},"
            + "#{detalleVenta.venta})")
    void insertDetalleVenta(@Param("detalleVenta") DetalleVenta detalleVenta);

}
