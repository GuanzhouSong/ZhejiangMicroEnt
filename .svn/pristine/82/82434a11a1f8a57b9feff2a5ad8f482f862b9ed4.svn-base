package com.icinfo.cs.common.validator;

import com.icinfo.cs.common.anno.Forbidword;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.model.SysForbidword;
import com.icinfo.cs.yr.service.ISysForbidwordService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * 描述：敏感词校验
 *
 * @author 朱德峰
 * @date 2016/11/17
 */
public class ForbidwordValidator implements ConstraintValidator<Forbidword,String> {

    @Autowired
    ISysForbidwordService sysForbidwordService;


    /**
     * Initializes the validator in preparation for
     * {@link #isValid(Object, ConstraintValidatorContext)} calls.
     * The constraint annotation for a given constraint declaration
     * is passed.
     * <p/>
     * This method is guaranteed to be called before any use of this instance for
     * validation.
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(Forbidword constraintAnnotation) {
    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p/>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<SysForbidword> sysForbidwordList = sysForbidwordService.doGetListForCache();
        //过滤掉所有特殊字符
        if(value==null) return true;
        value = StringUtil.StringFilter(value);
        boolean isContainForbidwordFlg=false;
        for (SysForbidword sysForbidword : sysForbidwordList) {
            if (value.indexOf(sysForbidword.getBanLetter()) != -1) {
                isContainForbidwordFlg=true;
                break;
            }
        }
        return !isContainForbidwordFlg;
    }
}
