package org.zk.amzerp.model.system.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.zk.amzerp.model.DataModel;


@Data
@TableName("system_dict")
public class SystemDictPO extends DataModel {

    private String name;

    private String description;

    private Integer orders;
}
