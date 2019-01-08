package pe.com.veloz.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pe.com.veloz.domain.ProductoUnidadMedida;

@Mapper
public interface ProductoUnidadMedidaMapper {

    @Insert("insert into producto_unidad_medida(producto,unidad_medida) " +
            "values(#{prodUnidMed.producto}," +
            "#{prodUnidMed.unidadMedida})")
    void saveProductoUnidadMedida(@Param("prodUnidMed") ProductoUnidadMedida productoUnidadMedida);

    @Delete("delete from producto_unidad_medida where producto = #{productoId}")
    void removeProductoUnidadMedida(@Param("productoId") Long productoId);
}