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
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pe.com.veloz.domain.Persona;

/**
 *
 * @author eddy
 */
@Mapper
public interface PersonaMapper {

    @Select("select id, nombres, apellidos, dni, celular, direccion from persona")
    List<Persona> listPersona();

    @Delete("delete from persona where id=#{id}")
    void removePersona(@Param("id") Long id);

    @Update("update producto "
            + "set nombres=#{persona.nombres},"
            + "set apellidos=#{persona.apellidos},"
            + "set dni=#{persona.dni},"
            + "set celuar=#{persona.celular},"
            + "set direccion=#{persona.direccion}"
            + "where id =#{persona.id}")
    void updatePersona(@Param("persona") Persona persona);

    @Select("SELECT * FROM persona where id = #{id}")
    Persona findPersonaById(@Param("id") Long id);

    @Select("SELECT * FROM persona where nombres = #{nombres}")
    Persona findPersonaByNombres(@Param("id") String nombres);

    @Select("SELECT * FROM persona where apellidos = #{apellidos}")
    Persona findPersonaByApellidos(@Param("id") String nombres);

    @Select("SELECT * FROM persona where dni = #{dni}")
    Persona findPersonaByDNI(@Param("id") String nombres);

    @Select("SELECT * FROM persona where celular = #{celular}")
    Persona findPersonaByCelular(@Param("id") String nombres);

    @Select("SELECT * FROM persona where direccion = #{direccion}")
    Persona findPersonaByDireccion(@Param("id") String nombres);

    @Insert("insert into persona (nombres, apellidos, dni, celular, direccion)"
            + "values(#{persona.nombres},"
            + "#{persona.apellidos},"
            + "#{persona.dni},"
            + "#{persona.celular},"
            + "#{persona.direccion},"
            + "#{persona.id})")
    void savePersona(@Param("persona") Persona persona);

}
