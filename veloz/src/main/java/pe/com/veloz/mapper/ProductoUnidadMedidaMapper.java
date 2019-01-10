package pe.com.veloz.mapper;

import org.apache.ibatis.annotations.*;
import pe.com.veloz.domain.ProductoUnidadMedida;

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
}