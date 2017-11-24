package com.icinfo.cs.common.anno;

import com.icinfo.cs.common.validator.ForbidwordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


/**
 * 描述：敏感词校验
 *
 * @author 朱德峰
 * @date 2016/11/17
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
@Constraint(
        validatedBy = {ForbidwordValidator.class}
)
public @interface Forbidword {

    String message() default "输入的内容存在敏感词";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
