package org.jcloud.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.jcloud.controller.api.vo.Result;
import org.jcloud.controller.constant.WebConstant;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.support.WebContentGenerator;

/**
 * 统一异常处理类
 */
@RestControllerAdvice
@Slf4j
public class WebExceptionHandler {

    /**
     * 处理自定义异常
     * @param e
     * return
     */
    @ExceptionHandler(WebException.class)
    public Result<?> handlerWebException(WebException e){
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }

    /**
     * 处理405异常
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Result<?> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e){
        log.error(e.getMessage(), e);
        return Result.error(WebConstant.SC_METHOD_NOT_ALLOWED_405,e.getMethod() + "请求方式不被该接口支持");
    }

    /**
     * 处理404异常
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result<?> handlerNoFoundException(NoHandlerFoundException e) {
        log.error(e.getMessage());
        return Result.error(WebConstant.SC_NOT_FOUND_404, "资源路径"+e.getRequestURL()+"【"+e.getHttpMethod()+"】不存在，请检查路径是否正确");
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
            errorMsg = "空指针异常";
        }else{
            errorMsg = e.getClass() + "异常";
        }
        log.error(e.getMessage(), e);
        return Result.error(errorMsg);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result<?> handleDuplicateKeyException(DuplicateKeyException e){
        log.error(e.getMessage(), e);
        return Result.error("数据库中已存在该记录");
    }



//    @ExceptionHandler({UnauthorizedException.class, AuthorizationException.class})
//    public Result<?> handleAuthorizationException(AuthorizationException e){
//        log.error(e.getMessage(), e);
//        return Result.noauth("没有权限，请联系管理员授权");
//    }
//


    /**
     * spring默认上传大小100MB 超出大小捕获异常MaxUploadSizeExceededException
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Result<?> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        log.error(e.getMessage(), e);
        return Result.error("文件大小超出10MB限制, 请压缩或降低文件质量! ");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public Result<?> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        log.error(e.getMessage(), e);
        return Result.error("字段太长,超出数据库字段的长度");
    }

//    @ExceptionHandler(PoolException.class)
//    public Result<?> handlePoolException(PoolException e) {
//        log.error(e.getMessage(), e);
//        return Result.error("Redis 连接异常!");
//    }


}
