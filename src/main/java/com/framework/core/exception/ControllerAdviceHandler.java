package com.framework.core.exception;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.framework.core.vo.ResultVo;



/**控制器增强.
 * 作用：@ControllerAdvice注解内部使用@ExceptionHandler、@InitBinder、@ModelAttribute注解的方法应用到所有的 @RequestMapping注解的方法
 * 1、统一处理系统抛出的BizExcepton的异常
 * @author lixiaolong
 * @version datetime：2015年6月8日  上午9:34:23
 */
@ControllerAdvice
@ResponseBody
public class ControllerAdviceHandler {
	
	
	private static final Logger  LOG=LoggerFactory.getLogger(ControllerAdviceHandler.class);
	
	@ExceptionHandler(BizException.class)
	public ResultVo processBizException(BizException ex) {
		LOG.warn("统一处理返回BizException异常 : "+ex.getDescr());
        return new ResultVo(new Object(),ex.getCode(),ex.getDescr());
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
