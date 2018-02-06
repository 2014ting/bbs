package com.cn.Form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by 李婷婷 on 2018/1/27.
 * 登录时所传的参数封装为一个对象
 */
@Data
public class LoginForm {
    @NotEmpty(message = "用户昵称不能为空")
    private String nickName;
    @NotEmpty(message = "用户密码不能为空")
    private String password;

    public LoginForm(String nickName, String password) {
        this.nickName = nickName;
        this.password = password;
    }
    public LoginForm(){}
}
