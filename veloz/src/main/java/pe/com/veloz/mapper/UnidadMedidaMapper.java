package pe.com.veloz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pe.com.veloz.domain.UnidadMedida;

import java.util.List;

@Mapper
public interface UnidadMedidaMapper {

    @Select("select id,nombre,cantidad,estado,descripcion from unidad_medida")
    List<UnidadMedida> findAllUnidadesMedida();
}
