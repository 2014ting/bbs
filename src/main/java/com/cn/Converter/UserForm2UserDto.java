package com.cn.Converter;

import com.cn.DTO.UserDto;
import com.cn.Form.LoginForm;
import com.cn.Form.RegisterForm;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 李婷婷 on 2018/1/27.
 */
public class UserForm2UserDto {
    public  static UserDto LoginForm2UserDto(LoginForm loginForm){
         UserDto userDto = new UserDto();
        BeanUtils.copyProperties(loginForm,userDto);
        return  userDto;
    }
    public  static List<UserDto> LoginFormList2UserDtoList(List<LoginForm> loginFormList){
         return loginFormList.stream().map(e->LoginForm2UserDto(e)).
                 collect(Collectors.toList());
    }
    public  static UserDto RegisterForm2UserDto(RegisterForm registerForm){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(registerForm,userDto);
        return  userDto;
    }
    public static  List<UserDto> RegisterFormList2UserDtoList(List<RegisterForm>  registerFormList){
        return registerFormList.stream().map(e->RegisterForm2UserDto(e)).
                collect(Collectors.toList());
    }

}
