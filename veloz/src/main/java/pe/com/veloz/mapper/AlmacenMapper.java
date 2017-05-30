/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pe.com.veloz.domain.Almacen;
import pe.com.veloz.domain.Cliente;

/**
 *
 * @author josmarl
 */
@Mapper
public interface AlmacenMapper {

    @Select("select id,nro_doc as nroDoc,usuario,cliente,fecha_reg as fechaReg from almacen")
    @Results(value = {
        @Result(property = "clienteObj", column = "cliente", one = @One(select = "findClienteById")),})
    List<Almacen> findAllAlmacen();

    @Select("select id,razon_social as razonSocial from cliente where id=#{id}")
    Cliente findClienteById(Long id);

    @Insert("insert into almacen(nro_doc,usuario,cliente,fecha_reg) values("
            + "#{almacen.nroDoc},"
            + "#{almacen.usuario},"
            + "#{almacen.cliente},"
            + "#{almacen.fechaReg})")
    @Options(useGeneratedKeys = true, keyProperty = "almacen.id", keyColumn = "id")
    void saveAlmacen(@Param("almacen") Almacen almacen);

    @Delete("delete from almacen where id = #{id}")
    void removeAlmacen(@Param("id") Long id);

    @Update("update almacen set nro_doc = #{almacen.nroDoc},cliente=#{almacen.cliente} where id = #{almacen.id}")
    void updateAlmacen(@Param("almacen") Almacen almacen);

    @Select("select id,nro_doc as nroDoc,cliente,usuario,fecha_reg as fechaReg from almacen where id=#{id}")
    Almacen findAlmacenById(@Param("id") Long id);

}
