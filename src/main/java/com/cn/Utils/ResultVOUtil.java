package com.cn.Utils;

import com.cn.VO.ResultVO;

/**
 * Created by 李婷婷 on 2018/1/27.
 */
public class ResultVOUtil {
    public static ResultVO success( Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setData(object);
        return resultVO;
    }
    public static ResultVO success(){
      return   ResultVOUtil.success(null);
    }
    public static ResultVO error (Integer code,String message){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(message);
        return resultVO;
    }
}
