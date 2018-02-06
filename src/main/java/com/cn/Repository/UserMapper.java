package com.cn.Repository;

import com.cn.DTO.UserDto;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 李婷婷 on 2018/1/27.
 */
@Mapper
public interface UserMapper {

    @Results({
             @Result(property = "trueName",column = "true_name"),
             @Result(property = "nickName",column = "nick_name"),
            @Result(property = "regTime",column = "reg_time")
          })
     @Transactional
     @Insert("insert into t_user(nick_name,password,true_name,reg_time) values(#{nickName},#{password},#{trueName},#{regTime})")
     void save(@Param("nickName") String username,@Param("password") String password,@Param("trueName") String trueName,@Param("regTime") String regTime);

     @Transactional
      @Delete("delete from t_user where id=#{id}")
     void delete (@Param("id") int id);

    @Results({
            @Result(property = "trueName",column = "true_name"),
            @Result(property = "nickName",column = "nick_name"),
            @Result(property = "regTime",column = "reg_time")
    })
     @Select("select * from t_user where nick_name=#{nickName} and password =#{password}" )
     UserDto findByNamePass(@Param("nickName") String nickName, @Param("password") String password);

    @Results({
            @Result(property = "trueName",column = "true_name"),
            @Result(property = "nickName",column = "nick_name"),
            @Result(property = "regTime",column = "reg_time")
    })
    @Select("select * from t_user where nick_name=#{nickName} and password =#{password} and true_name = #{trueName}" )
    UserDto findByTrueNamePass(@Param("nickName") String nickName, @Param("password") String password,@Param("trueName") String trueName);

}
