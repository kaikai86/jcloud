package cn.org.jcloud.model.system.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SystemDictDTO {

    @NotNull(message = "字典名称必填")
    @NotBlank(message = "字典名称不能为空")
    private String name;
    @NotNull(message = "详细描述必填")
    private String description;
    @NotNull(message = "顺序字段不能为空")
    private Integer orders;
}
