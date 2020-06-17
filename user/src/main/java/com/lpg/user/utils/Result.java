package com.lpg.user.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lPG
 * @version 1.0
 * @Description
 * @date 2020-06-16 16:16
 */
@Data
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Result success() {
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), null);
    }

    public static Result failed(String message) {
        return new Result<>(ResultCodeEnum.FAILED.getCode(), message, null);
    }

    public static Result failed() {
        return new Result<>(ResultCodeEnum.FAILED.getCode(),ResultCodeEnum.FAILED.getMessage(),null);
    }

    public static Result paramError() {
        return new Result<>(ResultCodeEnum.PARAM_ERROR.getCode(),ResultCodeEnum.PARAM_ERROR.getMessage(),null);
    }

    public static Result paramError(String message) {
        return new Result<>(ResultCodeEnum.PARAM_ERROR.getCode(),message,null);
    }
}
