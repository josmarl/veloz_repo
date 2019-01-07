package pe.com.veloz.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pe.com.veloz.domain.UnidadMedida;

import java.util.List;

@Mapper
public interface UnidadMedidaMapper {

    @Select("select id,nombre,cantidad,estado,descripcion from unidad_medida")
    List<UnidadMedida> findAllUnidadesMedida();

    @Insert("insert into unidad_medida(nombre,cantidad,descripcion,estado) " +
            "values (#{medida.nombre}," +
            "#{medida.cantidad}," +
            "#{medida.descripcion}," +
            "#{medida.estado})")
    void saveUnidadMedida(@Param("medida") UnidadMedida unidadMedida);
}
