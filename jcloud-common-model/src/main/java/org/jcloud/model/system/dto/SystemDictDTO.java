package org.jcloud.model.system.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Data
public class SystemDictDTO {

    @NotBlank(message = "字典名称不能为空")
    private String name;

    private String description;
    @NotNull(message = "顺序字段必传")
    private Integer orders;
}
