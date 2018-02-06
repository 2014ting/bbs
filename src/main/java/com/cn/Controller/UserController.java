package com.cn.Controller;

import com.cn.Converter.UserForm2UserDto;
import com.cn.DTO.UserDto;
import com.cn.Enum.UserResultEnum;
import com.cn.Exception.UserBusinessException;
import com.cn.Form.LoginForm;
import com.cn.Form.RegisterForm;
import com.cn.Service.Impl.UserServiceImpl;
import com.cn.Utils.ResultVOUtil;
import com.cn.VO.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 李婷婷 on 2017/12/23.
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ResultVO<UserDto> Login(@RequestParam("nickName")String nickName,@RequestParam("password") String password){
        LoginForm loginForm = new LoginForm(nickName,password);
        UserDto userDto = UserForm2UserDto.LoginForm2UserDto(loginForm);
        UserDto currUserDto =   userServiceImpl.findByNamePass(userDto.getNickName(),userDto.getPassword());
        //用户还未注册
        if(currUserDto == null){
            throw new UserBusinessException(UserResultEnum.USER_MOT_REGISTERED);
        }
        return ResultVOUtil.success(currUserDto);
    }

    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ResultVO<UserDto> Register(@RequestBody @Valid RegisterForm registerForm,
                                      BindingResult bindingResult){
       if(bindingResult.hasErrors()){
           log.error("注册信息不符合要求");
           throw new UserBusinessException(UserResultEnum.USER_PARAM_ERROR.getCode(),
                   bindingResult.getFieldError().getDefaultMessage());
       }
        UserDto  userDto = UserForm2UserDto.RegisterForm2UserDto(registerForm);
       UserDto CurrUserDto =  userServiceImpl.findByTrueNamePass(userDto.getNickName(),userDto.getPassword(),userDto.getTrueName());
        if(CurrUserDto != null){
            throw new  UserBusinessException(UserResultEnum.USER_ALREADY_EXISTS);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        userDto.setRegTime(simpleDateFormat.format(new Date()));
         userServiceImpl.save(userDto);
       ResultVO<UserDto> resultVO =   ResultVOUtil.success(userDto);
      return  resultVO;
}



}
