package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunbaojin
 * @date 2020/4/12 19:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    public Integer code;
    public String message;
    public T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
