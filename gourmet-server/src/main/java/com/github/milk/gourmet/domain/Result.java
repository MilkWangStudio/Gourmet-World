package com.github.milk.gourmet.domain;

import lombok.Data;

import java.util.List;

@Data
public class Result<T> {
    private T data;
    private Integer code;
    private String msg;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setData(data);
        result.setMsg("success");
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg(msg);
        return result;
    }
}
