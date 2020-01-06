package org.zk.amzerp.client.system;

import org.springframework.cloud.openfeign.FeignClient;
import org.zk.amzerp.model.system.dto.SystemDictDTO;
import org.zk.amzerp.model.system.po.SystemDictPO;
import org.zk.amzerp.service.base.BaseService;

@FeignClient(name = "service-system",path="/system")
public interface SystemDictService extends BaseService<SystemDictDTO,SystemDictPO> {



}
