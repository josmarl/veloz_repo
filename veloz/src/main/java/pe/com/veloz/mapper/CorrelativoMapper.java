/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.veloz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pe.com.veloz.domain.Correlativo;

/**
 *
 * @author josmarl
 */
@Mapper
public interface CorrelativoMapper {

    @Select("select * from correlativo where estado = '1'")
    Correlativo findActive();

    @Update("update correlativo set correlativo=#{correlativo.correlativo} where id=#{correlativo.id}")
    void updateCorrelativo(@Param("correlativo") Correlativo correlativo);

}
