package com.lpg.user.Ann;

import com.lpg.user.utils.ObjectUtil;
import com.lpg.user.utils.Result;
import com.lpg.user.utils.ResultCodeEnum;
import com.lpg.user.utils.StringUtil;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * @author lPG
 * @version 1.0
 * @Description
 * @date 2020-06-16 16:11
 */
public class Validate {

    private static final String MESSAGE_NONE = "%s不能为空";
    private static final String MESSAGE_ERROR = "%s参数错误";

    /**
     * 开始校验
     *
     * @param object
     */
    public static Result validations(Object object) {
        /**
         * 获取object类型
         */
        String message = "";
        try {
            Class<? extends Object> clazz = object.getClass();

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                /**
                 * 私有属性可以访问
                 */
                field.setAccessible(true);
                validate(field, object);
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        return Result.paramError(message);
    }

    /**
     * 校验
     *
     * @param field
     * @param object
     */
    public static void validate(Field field, Object object) throws Exception {
        Validation validation = field.getAnnotation(Validation.class);
        String value = field.get(object).toString();
        if (ObjectUtil.isEmpty(validation)) return;
        if (validation.REQUIRE()) {
            if (StringUtil.isEmpty(value)){
                throw new Exception(String.format(MESSAGE_NONE, field.getName()));
            }
        }
        switch (validation.TYPE()){
            case PHONE:
                if (RegexUtil.isPhone(value)){
                    throw new Exception(String.format(MESSAGE_ERROR, field.getName()));
                }
                break;
            default:
                break;
        }

    }
}
