/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pe.com.veloz.domain.AlmacenConsolidado;

/**
 *
 * @author josmarl
 */
@Mapper
public interface AlmacenConsolidadoMapper {

    @Select("select id,producto,disponible,vendido from almacen_consolidado")
    List<AlmacenConsolidado> findAll();

    @Insert("insert into almacen_consolidado(producto,disponible,vendido) "
            + "values(#{almacenConsolidado.producto},"
            + "#{almacenConsolidado.disponible},"
            + "#{almacenConsolidado.vendido})")
    void saveAlmacenConsolidado(@Param("almacenConsolidado") AlmacenConsolidado almacenConsolidado);

    @Update("update almacen_consolidado set "
            + "disponible = #{almacenConsolidado.disponible} "
            + "where id = #{almacenConsolidado.id}")
    void updateAlmacenConsolidadoDisponible(@Param("almacenConsolidado") AlmacenConsolidado almacenConsolidado);

}
