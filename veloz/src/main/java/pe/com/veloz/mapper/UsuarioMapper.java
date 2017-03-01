/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pe.com.veloz.domain.Role;
import pe.com.veloz.domain.Usuario;

/**
 *
 * @author server-itecs
 */
@Mapper
public interface UsuarioMapper {

    @Select("SELECT id,username,estado,area FROM usuario "
            + "order by id desc")
    List<Usuario> findUsuarios();

    @Select("SELECT * FROM role "
            + "where usuario=#{id}")
    List<Role> findRolesById(Long id);

    @Insert("INSERT INTO usuario(username,password,estado) "
            + "values(#{usuario.username},#{usuario.password},#{usuario.estado})")
    @Options(useGeneratedKeys = true, keyProperty = "usuario.id", keyColumn = "id")
    void saveUsuario(@Param("usuario") Usuario usuario);

    @Delete("DELETE FROM usuario "
            + "where id = #{id}")
    void removeUsuario(@Param("id") Long id);

    @Update("UPDATE usuario "
            + "set username=#{usuario.username}, "
            + "password=#{usuario.password}, "
            + "estado=#{usuario.estado} "
            + "where id=#{usuario.id}")
    void updateUsuario(@Param("usuario") Usuario usuario);

    @Select("SELECT * FROM usuario "
            + "where id = #{id}")
    Usuario findUsuarioById(@Param("id") Long id);

    @Select("SELECT * FROM usuario "
            + "where username = #{usuario}")
    Usuario findUsuarioByUsername(@Param("usuario") String usuario);

    @Select("SELECT * FROM usuario "
            + "where username = #{usuario} and password = #{password}")
    @Results(value = {
        @Result(property = "authorities", column = "id", many = @Many(select = "findRolesById"))
    })
    Usuario validateUsuario(@Param("usuario") String usuario, @Param("password") String password);

}
