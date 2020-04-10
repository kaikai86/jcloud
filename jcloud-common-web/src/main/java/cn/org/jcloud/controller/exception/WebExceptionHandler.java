package cn.org.jcloud.controller.exception;

import cn.org.jcloud.controller.api.vo.Result;
import cn.org.jcloud.controller.api.vo.WrapMapper;
import cn.org.jcloud.controller.constant.WebConstant;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import cn.org.jcloud.common.exception.CommonException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;
import java.util.List;

/**
 * 统一异常处理类
 */
@RestControllerAdvice
@Slf4j
public class WebExceptionHandler {

    /**
     * 处理自定义业务异常
     * @param e
     * return
     */
    @ExceptionHandler({CommonException.class,WebException.class})
    public Result handlerWebException(CommonException e){
        log.error("错误码【{}】:{}",e.getCode(),e);
        if (e instanceof WebException) {

        }
        return WrapMapper.wrap(e.getCode(),e.getMessage());
    }

    /**
     * 处理400异常
     * @param e
     * @return
     */
    @ExceptionHandler( MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error(e.getMessage());
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String[] s = new String[fieldErrors.size()];
        int i = 0;
        for (FieldError fieldError : fieldErrors) {
            s[i] = fieldError.getDefaultMessage() ;
            i++;
        }
        return WrapMapper.wrap(WebConstant.SC_BAD_REQUEST, String.format("参数错误:%s", Arrays.toString(s)));
    }

    /**
     * 处理405异常
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Result HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        log.error(e.getMessage());
        return WrapMapper.wrap(WebConstant.SC_METHOD_NOT_ALLOWED_405,e.getMethod() + "请求方式不被该接口支持");
    }

    /**
     * 处理404异常
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result handlerNoFoundException(NoHandlerFoundException e) {
        log.error(e.getMessage());
        return WrapMapper.wrap(WebConstant.SC_NOT_FOUND_404, "资源路径"+e.getRequestURL()+"【"+e.getHttpMethod()+"】不存在，请检查请求是否正确");
    }


    /**
     * 处理500内部异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> handleException(Exception e){
        String errorMsg = "";
        if (e instanceof NullPointerException) {
            errorMsg = "空指针";
        }else if(e instanceof HttpMessageNotReadableException){
            errorMsg = "请求体不能为空";
        }else if (e instanceof FeignException){
            String s = ((FeignException) e).contentUTF8();
            System.out.println(s);
            errorMsg = "Fegin远程服务错误";
        }else {
            errorMsg = String.format("【%s】异常信息:%s",e.getClass(),e.getMessage());
        }
        log.error(e.getMessage(), e);
        return WrapMapper.error(errorMsg);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result<?> handleDuplicateKeyException(DuplicateKeyException e){
        log.error(e.getMessage(), e);
        return WrapMapper.error("数据库中已存在该记录");
    }







    /**
     * spring默认上传大小100MB 超出大小捕获异常MaxUploadSizeExceededException
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Result handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        log.error(e.getMessage(), e);
        return WrapMapper.error("文件大小超出10MB限制, 请压缩或降低文件质量! ");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public Result handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        log.error(e.getMessage(), e);
        return WrapMapper.error("字段太长,超出数据库字段的长度");
    }

//    @ExceptionHandler(PoolException.class)
//    public Result<?> handlePoolException(PoolException e) {
//        log.error(e.getMessage(), e);
//        return Result.error("Redis 连接异常!");
//    }


}
