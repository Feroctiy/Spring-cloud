package com.lpg.user.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCodeEnum {
    SUCCESS(200,"处理成功"),
    PARAM_ERROR(502,"参数错误"),
    FAILED(500,"处理失败");
    private Integer code;
    private String message;
}
