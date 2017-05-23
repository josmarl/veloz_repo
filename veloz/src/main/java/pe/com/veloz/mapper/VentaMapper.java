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
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pe.com.veloz.domain.Almacen;
import pe.com.veloz.domain.Cliente;
import pe.com.veloz.domain.Venta;

/**
 *
 * @author josmarl
 */
@Mapper
public interface VentaMapper {

    @Select("select id,cliente,usuario,base_imponible as baseImponible,igv,total,nro_doc as nroDoc from venta")
    @Results(value = {
        @Result(property = "clienteObj", column = "cliente", one = @One(select = "findClienteById")),})
    List<Venta> findAll();

    @Insert("insert into venta(cliente,usuario,base_imponible,igv,total,nro_doc) "
            + "values(#{venta.cliente},"
            + "#{venta.usuario},"
            + "#{venta.baseImponible},"
            + "#{venta.igv},"
            + "#{venta.total},"
            + "#{venta.nroDoc})")
    @Options(useGeneratedKeys = true, keyProperty = "venta.id", keyColumn = "id")
    void saveVenta(@Param("venta") Venta venta);

    @Select("select id,razon_social as razonSocial from cliente where id=#{id}")
    Cliente findClienteById(Long id);
}
