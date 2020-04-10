package cn.org.jcloud.controller.exception;

import cn.org.jcloud.common.exception.CommonException;

public class WebException extends CommonException {

	public WebException(int code, String message) {
		super(code, message);

	}


}
