package org.zk.amzerp.model.system.po;

import lombok.Data;
import org.zk.amzerp.model.DataModel;

import javax.persistence.Table;
import java.math.BigInteger;

@Table(name= "system_dict")
@Data
public class SystemDictPO extends DataModel {

    private String name;
}
