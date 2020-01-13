package org.jcloud.client.system;

import org.springframework.cloud.openfeign.FeignClient;
import org.jcloud.model.system.dto.SystemDictDTO;
import org.jcloud.model.system.po.SystemDictPO;
import org.jcloud.service.base.BaseService;

import java.util.List;

@FeignClient(name = "service-system",path="/system")
public interface SystemDictService extends BaseService<SystemDictDTO,SystemDictPO> {

     List<SystemDictPO> querySystemDictByName(String name);

}
