package com.lovesh.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zdm
 * @date 2023/09/08
 */
@Data
public class Result<T> implements Serializable {

    private Integer code;

    private boolean success;

    private T result;


    public Result() {
    }

    public Result(Integer code, boolean success, T result) {
        this.code = code;
        this.success = success;
        this.result = result;
    }

    public Result(T result){
        this.code = 200;
        this.success = true;
        this.result = result;
    }

}
