package cn.org.jcloud.controller.api.vo;


import cn.org.jcloud.controller.constant.WebConstant;

/**
 *  封装打包返回类
 */
public class WrapMapper {

    /**
     * Instantiates a new wrap mapper.
     */
    private WrapMapper() {
    }

    /**
     * Wrap.
     *
     * @param         <E> the element type
     * @param code    the code
     * @param message the message
     * @param o       the o
     *
     * @return the wrapper
     */
    public static <E> Result<E> wrap(int code, String message, E o) {
        boolean success = true;
        if (code != 0) {
            success = false;
        }
        return new Result<E>(success,code, message, o);
    }

    /**
     * Wrap.
     *
     * @param         <E> the element type
     * @param code    the code
     * @param message the message
     *
     * @return the wrapper
     */
    public static <E> Result<E> wrap(int code, String message) {
        return wrap(code, message, null);
    }

    /**
     * Wrap.
     *
     * @param      <E> the element type
     * @param code the code
     *
     * @return the wrapper
     */
    public static <E> Result<E> wrap(int code) {
        return wrap(code, null);
    }

    /**
     * Un wrapper.
     *
     * @param         <E> the element type
     * @param result the wrapper
     *
     * @return the e
     */
    public static <E> E unWrap(Result<E> result) {
        return result.getResult();
    }

    /**
     * Wrap ERROR. code=500
     *
     * @param <E> the element type
     *
     * @return the wrapper
     */
    public static <E> Result<E> error() {
        return wrap(WebConstant.SC_INTERNAL_SERVER_ERROR_500, "内部异常");
    }

    /**
     * Error wrapper.
     *
     * @param         <E> the type parameter
     * @param message the message
     *
     * @return the wrapper
     */
    public static <E> Result<E> error(String message) {
        return wrap(WebConstant.SC_INTERNAL_SERVER_ERROR_500, message);
    }

    /**
     * Wrap SUCCESS. code=-1
     *
     * @param <E> the element type
     *
     * @return the wrapper
     */
    public static <E> Result<E> ok() {
        return new Result<>();
    }

    public static <E> Result<E> ok(E o) {
        return new Result<>(o);
    }

    public static <E> Result<E> ok(String message, E o) {
        return new Result<>(message, o);
    }

    /**
     * Wrap Fail. code=-1
     *
     * @param <E> the element type
     *
     * @return the wrapper
     */
    public static <E> Result<E> fail() {
        return new Result<>(false, Result.FAIL_CODE, Result.FAIL_MESSAGE);
    }

    public static <E> Result<E> fail(E o) {
        return new Result<>(false, Result.FAIL_CODE, Result.FAIL_MESSAGE,o);
    }

    public static <E> Result<E> fail(String message, E o) {
        return new Result<>(false, Result.FAIL_CODE, message, o);
    }

    /**
     * Wrap okOrFail. code=-1
     *
     * @param <E> the element type
     *
     * @return the wrapper
     */
    public static <E> Result<E> okOrFail(boolean success) {
        if (success) {
            return ok();
        }
        return fail();
    }

    public static <E> Result<E> result(E o) {
        return new Result<E>(false, Result.FAIL_CODE, Result.FAIL_MESSAGE,o);
    }

    public static <E> Result<E> result(String message, E o) {
        return new Result<E>(false, Result.FAIL_CODE, message, o);
    }
}