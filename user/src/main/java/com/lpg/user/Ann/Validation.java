package com.lpg.user.Ann;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface  Validation{
    /**
     * 是否为必填
     * @return
     */
    boolean REQUIRE() default false;

    ValidationEnum TYPE() default ValidationEnum.NONE;
    /**
     * 自定义校验规则
     * @return
     */
    String REGEX_EXPRESSION() default "";

    /**
     * 异常信息
     * @return
     */
    String MESSAGE() default "";
}
