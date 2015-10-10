package com.framework.core.exception;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * 控制器增强
 * 作用：@ControllerAdvice注解内部使用@ExceptionHandler、@InitBinder、@ModelAttribute注解的方法应用到所有的 @RequestMapping注解的方法
 * 1、统一处理系统抛出的BizExcepton的异常
 * @author lixiaolong
 * @version datetime：2015年6月8日  上午9:34:23
 */
@ControllerAdvice
public class ControllerAdviceHandler {
	
	
	private static final Logger  LOG=LoggerFactory.getLogger(ControllerAdviceHandler.class);
	
	@ExceptionHandler(BizException.class)
	@ResponseBody
	public BizError processBizError(BizException ex) {
		LOG.error("调用controllerAdvice的processsBizError();统一处理BizException异常 : descr="+ex.getDescr());
        return new BizError(ex.getMessage(),ex.getDescr(),new Object());
    }
	
//	@ExceptionHandler(BindException.class)
//	@ResponseBody
//	public FieldErrorCompose processValidationError(BindException ex) {
//        BindingResult result = ex.getBindingResult();
//        List<FieldError> fieldErrors = result.getFieldErrors();
//        return processFieldErrors(fieldErrors);
//    }
//	
//	private FieldErrorCompose processFieldErrors(List<FieldError> fieldErrors) {
//		FieldErrorCompose dto = new FieldErrorCompose();
//        for (FieldError fieldError: fieldErrors) {
//            dto.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
//        }
//        return dto;
//    }

}
