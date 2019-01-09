package pe.com.veloz.mapper;

import org.apache.ibatis.annotations.*;
import pe.com.veloz.domain.UnidadMedida;
import pe.com.veloz.domain.dto.UnidadMedidaPrecioDTO;

import java.util.List;

@Mapper
public interface UnidadMedidaMapper {

    @Select("select id,nombre,cantidad,estado,descripcion from unidad_medida")
    List<UnidadMedida> findAllUnidadesMedida();

    @Select("select id,nombre,cantidad,estado,descripcion from unidad_medida where estado=1")
    List<UnidadMedida> findUnidadMedidaActive();

    @Select("select um.id,um.nombre,um.cantidad,um.descripcion,um.estado,pum.precio " +
            "from unidad_medida um " +
            "left join (" +
            "select * from producto_unidad_medida where producto=#{productoId}" +
            ") pum on um.id = pum.unidad_medida " +
            "where um.estado=1")
    List<UnidadMedidaPrecioDTO> findUnidadMedidaPrecio(@Param("productoId") Long productoId);

    @Insert("insert into unidad_medida(nombre,cantidad,descripcion,estado) " +
            "values (#{medida.nombre}," +
            "#{medida.cantidad}," +
            "#{medida.descripcion}," +
            "#{medida.estado})")
    void saveUnidadMedida(@Param("medida") UnidadMedida unidadMedida);

    @Select("select id,nombre,cantidad,estado,descripcion from unidad_medida where id = #{id}")
    UnidadMedida findById(@Param("id") Long id);

    @Update("update unidad_medida set " +
            "nombre=#{medida.nombre}," +
            "cantidad=#{medida.cantidad}," +
            "descripcion=#{medida.descripcion}," +
            "estado=#{medida.estado} where id = #{medida.id}")
    void updateUnidadMedida(@Param("medida") UnidadMedida unidadMedida);

    @Delete("delete from unidad_medida where id = #{id}")
    void removeUnidadMedida(@Param("id") Long id);
}
