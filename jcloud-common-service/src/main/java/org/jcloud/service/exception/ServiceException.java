package org.jcloud.service.exception;

import org.jcloud.common.enumeration.CommonErrorCodeEnum;
import org.jcloud.common.exception.CommonException;
import org.jcloud.service.enumeration.ServiceErrorCodeEnum;

public class ServiceException extends CommonException {

    public ServiceException(CommonErrorCodeEnum codeEnum, Object... args) {
        super(String.format("%s|%s",codeEnum.code(),String.format(codeEnum.msg(), args)));
    }

    public ServiceException(ServiceErrorCodeEnum codeEnum, Object... args) {
        super(String.format("%s|%s",codeEnum.code(),String.format(codeEnum.msg(), args)));
    }

}
