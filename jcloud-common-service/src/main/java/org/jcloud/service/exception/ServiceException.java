package org.jcloud.service.exception;

import org.jcloud.common.exception.CommonException;

public class ServiceException extends CommonException {

    public ServiceException(int code, String message) {
        super(String.format("%s|%s", code, message));
    }

}
