/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import pe.com.veloz.domain.Venta;

/**
 *
 * @author josmarl
 */
@Mapper
public interface VentaMapper {

    @Insert("insert into venta(cliente,usuario,base_imponible,igv,total) "
            + "values(#{venta.cliente},"
            + "#{venta.usuario},"
            + "#{venta.baseImponible},"
            + "#{venta.igv},"
            + "#{venta.total})")
    @Options(useGeneratedKeys = true, keyProperty = "venta.id", keyColumn = "id")
    void saveVenta(@Param("venta") Venta venta);
}
