package cn.org.jcloud.controller.config;

import lombok.Data;

@Data
public class ExceptionInfo {
    private String timestamp;

    private Integer status;

    private String exception;

    private String message;

    private String path;

    private String error;
}
