package com.cn.VO;

import lombok.Data;

/**
 * Created by 李婷婷 on 2018/1/27.
 */
@Data
public class ResultVO <T>{
     public  Integer code;
     public String message;
     public T data;
}
