package cn.org.jcloud.service.exception;

import cn.org.jcloud.common.enumeration.CommonErrorCodeEnum;
import cn.org.jcloud.common.exception.CommonException;
import cn.org.jcloud.service.enumeration.ServiceErrorCodeEnum;

public class ServiceException extends CommonException {

    public ServiceException(CommonErrorCodeEnum codeEnum, Object... args) {
        super(String.format("%s|%s",codeEnum.code(),String.format(codeEnum.msg(), args)));
    }

    public ServiceException(ServiceErrorCodeEnum codeEnum, Object... args) {
        super(String.format("%s|%s",codeEnum.code(),String.format(codeEnum.msg(), args)));
    }

}
