package cn.org.jcloud.model.system.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import cn.org.jcloud.model.base.DataModel;


@Data
@TableName("system_dict")
public class SystemDictPO extends DataModel {

    private String name;

    private String description;

    private Integer orders;
}
