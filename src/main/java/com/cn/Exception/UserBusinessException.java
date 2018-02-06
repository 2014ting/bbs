package com.cn.Exception;

import com.cn.Enum.UserResultEnum;

/**
 * Created by 李婷婷 on 2018/1/27.
 */
public class UserBusinessException extends RuntimeException {
         public  Integer code ;
         public UserBusinessException(UserResultEnum userResultEnum){
              super(userResultEnum.getMessage());
              this.code = userResultEnum.getCode();
         }
         public UserBusinessException(Integer code , String message){
             super(message);
             this.code = code ;
         }
}
