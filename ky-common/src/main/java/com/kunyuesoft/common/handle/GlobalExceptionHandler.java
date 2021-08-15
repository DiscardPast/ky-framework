package com.kunyuesoft.common.handle;

import com.kunyuesoft.common.base.ResultVO;
import com.kunyuesoft.common.enums.ResultEnum;
import com.kunyuesoft.common.exception.BtsException;
import com.kunyuesoft.common.utils.ResultVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.UnexpectedTypeException;
import java.util.List;

/**
 * @program: content
 * @description:
 * @author: zhihua
 * @create: 2019-08-07 15:21
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public ResultVO defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        if (e instanceof NoHandlerFoundException) {
            return ResultVOUtil.fail(ResultEnum.NO_HANDLER_FOUND_ERROR);
        } else if (e instanceof BindException) {
            List<FieldError> fieldErrorList = ((BindException) e).getFieldErrors();
            if (!CollectionUtils.isEmpty(fieldErrorList)) {
                FieldError fieldError = fieldErrorList.get(0);
                return ResultVOUtil.fail(ResultEnum.PARAM_ERROR, buildFieldErrorMsg(fieldError));
            }
        } else if (e instanceof BtsException) {
            logger.error("业务异常 , 信息 : " + ((BtsException) e).getMessage(), e);
            return ResultVOUtil.fail(((BtsException) e).getCode(), ((BtsException) e).getMessage());
        } else if (e instanceof UnexpectedTypeException) {
            logger.error("字段类型异常, 使用了不正确的@Validated注解 , 信息 : " + e.getMessage(), e);
            return ResultVOUtil.fail(ResultEnum.IS_ERROR, "");
        } else {
            logger.error("未知错误 , 信息 : " + e.getMessage(), e);
            return ResultVOUtil.fail(ResultEnum.PARAM_ERROR);
        }
        return ResultVOUtil.success();
    }

    private String buildFieldErrorMsg(FieldError fieldError) {
        String field = fieldError.getField();
        String defaultMessage = fieldError.getDefaultMessage();
        int index = defaultMessage.indexOf("Failed to convert property");
        return "[" + field + "]" + (index > -1 ? "参数类型错误" : defaultMessage);
    }
}
