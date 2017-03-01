package pe.com.veloz.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pe.com.veloz.domain.Role;

/**
 *
 * @author itecs
 */
@Mapper
public interface RoleMapper {

    @Select("SELECT * FROM role "
            + "where usuario = #{id}")
    List<Role> findRoleByUser(@Param("id") Long idUser);

    @Insert("insert into role(name,estado,usuario) "
            + "values (#{role.name}, "
            + "#{role.estado}, "
            + "#{role.usuario})")
    void saveRole(@Param("role") Role role);

    @Delete("delete from role "
            + "where name = #{role.name} "
            + "and usuario = #{role.usuario}")
    void removeRole(@Param("role") Role role);

}
