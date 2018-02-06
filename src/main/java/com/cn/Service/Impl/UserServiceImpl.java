package com.cn.Service.Impl;

import com.cn.DTO.UserDto;
import com.cn.Repository.UserMapper;
import com.cn.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 李婷婷 on 2017/12/23.
 */
@Service
public class UserServiceImpl  implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(UserDto userDto) {
         userMapper.save(userDto.getNickName(),userDto.getPassword(),userDto.getTrueName(),userDto.getRegTime());
    }

    @Override
    public void update(UserDto userDto) {

    }

    @Override
    public void delete(int id) {
          userMapper.delete(id);

    }

    @Override
    public UserDto findByNickName(String nickName) {
        return null;
    }

    @Override
    public UserDto findByNamePass(String nickName, String password) {
        UserDto currUser =  userMapper.findByNamePass(nickName,password);
        if(currUser!=null){
            return currUser;
        }
        return null;
    }
    @Override
    public UserDto findByTrueNamePass(String nickName, String password, String trueName) {
       UserDto userDto =  userMapper.findByTrueNamePass(nickName, password, trueName);
       if(userDto !=null){
           return userDto;
       }
        return null;
    }
}
