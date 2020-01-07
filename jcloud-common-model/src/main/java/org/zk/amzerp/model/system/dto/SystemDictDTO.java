package org.jcloud.model.system.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class SystemDictDTO {

    private String name;

    private String description;

    private Integer orders;
}
