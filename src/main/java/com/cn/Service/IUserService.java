package com.cn.Service;

import com.cn.DTO.UserDto;

/**
 * Created by 李婷婷 on 2017/12/23.
 */
public interface IUserService {
     void save(UserDto userDto);
     void update(UserDto userDto);
     void delete(int id);
     UserDto findByNickName(String nickName);
     UserDto findByNamePass(String nickName,String password);
     UserDto findByTrueNamePass(String nickName,String password,String trueName);
}
