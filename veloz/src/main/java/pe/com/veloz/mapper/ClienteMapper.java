/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pe.com.veloz.domain.Cliente;

/**
 *
 * @author josmarl
 */
@Mapper
public interface ClienteMapper {

    @Select("select id,razon_social as razonSocial,ruc,dni,direccion from cliente")
    List<Cliente> findAllClientes();

    @Insert("insert into cliente(razon_social,ruc,dni,direccion) "
            + "values (#{cliente.razonSocial},"
            + "#{cliente.ruc},"
            + "#{cliente.dni},"
            + "#{cliente.direccion})")
    @Options(useGeneratedKeys = true, keyProperty = "cliente.id", keyColumn = "id")
    void saveCliente(@Param("cliente") Cliente cliente);

}
