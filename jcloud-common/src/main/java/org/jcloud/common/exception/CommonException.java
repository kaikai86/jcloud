package org.jcloud.common.exception;

import org.jcloud.common.enumeration.CommonErrorCodeEnum;

public class CommonException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private int code;

	public CommonException() {

	}


	public CommonException(String message){
		super(message);
	}


	public CommonException(int code, String message){
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public CommonException(int code, String msgFormat, Object... args) {
		super(String.format(msgFormat, args));
		this.code = code;
	}

	public CommonException(CommonErrorCodeEnum codeEnum, Object... args) {
		super(String.format(codeEnum.msg(), args));
		this.code = codeEnum.code();
	}
}
