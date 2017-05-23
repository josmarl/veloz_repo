/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pe.com.veloz.domain.AlmacenConsolidado;
import pe.com.veloz.domain.Producto;

/**
 *
 * @author josmarl
 */
@Mapper
public interface AlmacenConsolidadoMapper {

    @Select("select id,producto,disponible,vendido from almacen_consolidado")
    @Results(value = {
        @Result(property = "productoObj", column = "producto", one = @One(select = "findProductoById")),})
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

    @Update("update almacen_consolidado set "
            + "disponible = #{almacenConsolidado.disponible}, "
            + "vendido = #{almacenConsolidado.vendido} "
            + "where id = #{almacenConsolidado.id}")
    void updateAlmacenConsolidadoStock(@Param("almacenConsolidado") AlmacenConsolidado almacenConsolidado);

    @Select("select id,producto,disponible,vendido from almacen_consolidado where producto = #{id}")
    AlmacenConsolidado findByProducto(@Param("id") Long id);

    @Select("select id,nombre,descripcion,marca from producto where id=#{id}")
    Producto findProductoById(@Param("id") Long id);

}
