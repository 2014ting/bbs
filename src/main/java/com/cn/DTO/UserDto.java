package com.cn.DTO;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 李婷婷 on 2018/1/27.
 */
//用于页面展示的对象
@Data
@Entity
@Table(name="t_user")
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "true_name")
    private String trueName;
    private String face;
    private String email;
    private String sex;
    @Column(name = "reg_time")
    private String regTime;
    private String  mobile;
    private String password;
    public UserDto( String nickName, String password) {
        this.nickName = nickName;
        this.password = password;
    }

    public UserDto(int id,String nickName, String trueName, String face, String email, String sex, String regTime, String mobile, String password) {
        this.id = id;
        this.nickName = nickName;
        this.trueName = trueName;
        this.face = face;
        this.email = email;
        this.sex = sex;
        this.regTime = regTime;
        this.mobile = mobile;
        this.password = password;
    }

    public UserDto(){}
}
