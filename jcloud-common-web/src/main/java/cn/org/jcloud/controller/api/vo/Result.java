package cn.org.jcloud.controller.api.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * zk
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 序列化标识
     */
    private static final long serialVersionUID = 1L;

    /**
     * 成功码.
     */
    public static final int SUCCESS_CODE = 0;

    /**
     * 成功信息.
     */
    public static final String SUCCESS_MESSAGE = "操作成功！";

    /**
     * 失败码.
     */
    public static final int FAIL_CODE = -1;

    /**
     * 错误信息.
     */
    public static final String FAIL_MESSAGE = "操作失败！";


    /**
     * 成功标志
     */
//	@ApiModelProperty(value = "成功标志")
    private boolean success;

    /**
     * 返回处理消息
     */
//	@ApiModelProperty(value = "返回处理消息")
    private String message;

    /**
     * 返回代码(成功代码为-1，失败代码为0 其他业务代码为>0)
     */
//	@ApiModelProperty(value = "返回代码")
    private Integer code;

    /**
     * 返回数据对象 data
     */
//	@ApiModelProperty(value = "返回数据对象")
    private T result;

    /**
     * 时间戳
     */
//	@ApiModelProperty(value = "时间戳")
    private long timestamp = System.currentTimeMillis();




    Result() {
        this(true,SUCCESS_CODE , SUCCESS_MESSAGE);
    }

    Result(String message, T result) {
        this(true,SUCCESS_CODE ,message,result);
    }

    Result(T result) {
        this(true,SUCCESS_CODE , SUCCESS_MESSAGE,result);
    }

    /**
     * Instantiates a new wrapper.
     *
     * @param code    the code
     * @param message the message
     */
    Result(boolean success, int code, String message) {
        this(success , code , message, null);
    }

    /**
     * Instantiates a new wrapper.
     *
     * @param code    the code
     * @param message the message
     * @param result  the result
     */
    Result(boolean success, int code, String message, T result) {
        super();
        this.success(success).code(code).message(message).result(result);
    }

    /**
     * Sets the 成功标志 , 返回自身的引用.
     *
     * @param success the new 成功标志
     *
     * @return the wrapper
     */
    private Result<T> success(boolean success) {
        this.setSuccess(success);
        return this;
    }

    /**
     * Sets the 代码 , 返回自身的引用.
     *
     * @param code the new 编号
     *
     * @return the wrapper
     */
    private Result<T> code(int code) {
        this.setCode(code);
        return this;
    }

    /**
     * Sets the 信息 , 返回自身的引用.
     *
     * @param message the new 信息
     *
     * @return the wrapper
     */
    private Result<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * Sets the 结果数据 , 返回自身的引用.
     *
     * @param result the new 结果数据
     *
     * @return the wrapper
     */
    public Result<T> result(T result) {
        this.setResult(result);
        return this;
    }

}

