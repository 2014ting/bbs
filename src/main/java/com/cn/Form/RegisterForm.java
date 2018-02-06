package com.cn.Form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by 李婷婷 on 2018/1/27.
 */
@Data
public class RegisterForm {
    @NotEmpty(message = "用户昵称不能为空")
    private String nickName;
    @NotEmpty(message = "用户密码不能为空")
    private String password;
    @NotEmpty(message = "用户真实姓名不能为空")
    private  String trueName;
}
