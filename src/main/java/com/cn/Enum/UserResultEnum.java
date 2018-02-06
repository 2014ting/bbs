package com.cn.Enum;

import lombok.Data;
import lombok.Getter;

/**
 * Created by 李婷婷 on 2018/1/27.
 */
@Getter
public enum UserResultEnum {
     USER_PARAM_ERROR(0,"参数传递错误"),
     USER_ALREADY_EXISTS(1,"用户已经存在"),
    USER_MOT_REGISTERED(2,"用户还未注册");


    public Integer  code;
    public String message;
     UserResultEnum(Integer code , String message){
        this.code = code ;
        this.message = message;
    }

}
