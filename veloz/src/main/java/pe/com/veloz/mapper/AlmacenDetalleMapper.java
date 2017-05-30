/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pe.com.veloz.domain.AlmacenDetalle;

/**
 * @author josmarl
 */
@Mapper
public interface AlmacenDetalleMapper {

    @Insert("insert into almacen_detalle(producto,cantidad,almacen,importe) values("
            + "#{almacenDetalle.producto},"
            + "#{almacenDetalle.cantidad},"
            + "#{almacenDetalle.almacen}," +
            "#{almacenDetalle.importe})")
    void saveAlmacenDetalle(@Param("almacenDetalle") AlmacenDetalle almacenDetalle);

}
