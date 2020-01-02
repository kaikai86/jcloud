package org.zk.amzerp.client.system;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zk.amzerp.model.system.dto.SystemDictDTO;
import org.zk.amzerp.model.system.po.SystemDictPO;
import org.zk.amzerp.service.BaseService;

@FeignClient(name = "service-system",path="/system")
public interface SystemDictService extends BaseService<SystemDictDTO,SystemDictPO> {



}
