package pe.com.veloz.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import pe.com.veloz.domain.ProductoUnidadMedida;
import pe.com.veloz.domain.dto.ProductoUnidadMedidaDTO;

import java.util.List;

@Mapper
public interface ProductoUnidadMedidaMapper {

    @Insert("insert into producto_unidad_medida(producto,unidad_medida,precio) " +
            "values(#{prodUnidMed.producto}," +
            "#{prodUnidMed.unidadMedida}," +
            "#{prodUnidMed.precio})")
    void saveProductoUnidadMedida(@Param("prodUnidMed") ProductoUnidadMedida productoUnidadMedida);

    @Delete("delete from producto_unidad_medida where producto = #{productoId}")
    void removeProductoUnidadMedida(@Param("productoId") Long productoId);

    @Select("select producto,unidad_medida,precio as unidadMedida from producto_unidad_medida where producto=#{productoId}")
    List<ProductoUnidadMedida> findByProducto(@Param("productoId") Long productoId);

    @Select("SELECT pum.producto AS productoId,p.nombre AS productoNombre,pum.unidad_medida AS unidadMedidaId,um.nombre AS unidadMedidaNombre,pum.precio " +
            "FROM producto_unidad_medida pum " +
            "INNER JOIN producto p ON pum.producto=p.id " +
            "INNER JOIN unidad_medida um ON pum.unidad_medida=um.id " +
            "WHERE producto=#{productoId}")
    List<ProductoUnidadMedidaDTO> findByProductoId(@Param("productoId") Long productoId);

    @Select("SELECT pum.producto AS productoId,pum.unidad_medida AS unidadMedidaId,pum.precio,um.nombre AS unidadMedidaNombre " +
            "FROM producto_unidad_medida pum INNER JOIN unidad_medida um on pum.unidad_medida=um.id " +
            "WHERE pum.producto=#{productoId} AND pum.unidad_medida=#{unidadMedidaId}")
    List<ProductoUnidadMedidaDTO> findByProductoAndMedida(@Param("productoId") Long productoId, @Param("unidadMedidaId") Long unidadMedidaId);
}