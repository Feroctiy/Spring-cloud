package com.lpg.user.entity;

import com.lpg.user.Ann.Validation;
import com.lpg.user.Ann.ValidationEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author lPG
 * @version 1.0
 * @Description
 * @date 2020-06-16 16:10
 */
@Data
@Accessors(chain = true)
public class User {
    @Validation(REQUIRE = true)
    private Integer id;
    @Validation(REQUIRE = true,TYPE = ValidationEnum.PHONE)
    private String phone;
    private String email;
}
