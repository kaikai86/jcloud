package org.jcloud.controller.config;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.jcloud.common.exception.CommonException;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import static feign.FeignException.errorStatus;

@Configuration
@Slf4j
public class ExceptionErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        String body = null;
        try {
            body = Util.toString(response.body().asReader());
            log.info("feign client response:{}", body);
            ExceptionInfo exceptionInfo = JSONUtil.toBean(body, ExceptionInfo.class);
            if (response.status() == 500 ) {
                String[] codeAndMsg = StrUtil.splitToArray(exceptionInfo.getMessage(), '|', 2);
                if (codeAndMsg.length > 0 && NumberUtil.isNumber(codeAndMsg[0])) {
                    return new CommonException(NumberUtil.parseInt(codeAndMsg[0]), codeAndMsg[1]);
                }
            }
            if (response.status() == 400) {

            }



            return new CommonException(exceptionInfo.getStatus(), exceptionInfo.getMessage());
        } catch (IOException e) {
            log.error("feign.IOException", e);
        }
        return errorStatus(methodKey, response);
    }

    public static void main(String[] args) {
        String str = null;
        String[] split = StrUtil.splitToArray(str, '|', 2);
        for (String s : split) {
            System.out.println(s);
        }
    }
}
