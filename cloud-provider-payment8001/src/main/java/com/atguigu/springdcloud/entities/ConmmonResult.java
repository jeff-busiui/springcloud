package com.atguigu.springdcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunbaojin
 * @date 2020/4/12 9:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConmmonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public  ConmmonResult(Integer code,String message){
        this(code,message,null);
    }

}
