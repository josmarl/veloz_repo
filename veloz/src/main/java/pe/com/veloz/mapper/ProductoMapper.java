/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import pe.com.veloz.domain.Producto;

/**
 * @author eddy
 */
@Mapper
public interface ProductoMapper {

    @Select("select id,nombre,descripcion,estado,marca,code from producto")
    List<Producto> findAll();

    @Delete("delete from producto where id = #{id}")
    void removeProducto(@Param("id") Long id);

    @Update(
            "update producto "
                    + "set nombre=#{producto.nombre}, "
                    + "descripcion=#{producto.descripcion}, "
                    + "estado=#{producto.estado}, "
                    + "marca=#{producto.marca}, "
                    + "code=#{producto.code} "
                    + "where id=#{producto.id}"
    )
    void updateProducto(@Param("producto") Producto producto);

    @Select("SELECT id,nombre,descripcion,"
            + "estado,marca,code FROM producto where id = #{id}")
    Producto findProductoById(@Param("id") Long id);

    @Select("SELECT * FROM producto where nombre = #{nombre}")
    Producto findProductoByNombre(@Param("nombre") String nombre);

    @Select("SELECT * FROM producto where marca = #{marca}")
    Producto findProductoByMarca(@Param("marca") String nombre);

    @Select("SELECT * FROM producto where code = #{code}")
    Producto findProductoByCode(@Param("code") String code);

    @Select("SELECT * FROM producto where nombre = #{nombre} and marca = #{marca}")
    Producto findProductoByNombreMarca(@Param("nombre") String nombre, @Param("marca") String marca);

    @Insert("insert into producto(nombre,descripcion,estado,marca,code) "
            + "values(#{producto.nombre},"
            + "#{producto.descripcion},"
            + "#{producto.estado},"
            + "#{producto.marca},"
            + "#{producto.code})")
    @Options(useGeneratedKeys = true, keyProperty = "producto.id", keyColumn = "id")
    void saveProducto(@Param("producto") Producto producto);

}
