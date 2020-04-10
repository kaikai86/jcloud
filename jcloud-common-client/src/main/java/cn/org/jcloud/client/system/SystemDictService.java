package cn.org.jcloud.client.system;

import org.springframework.cloud.openfeign.FeignClient;
import cn.org.jcloud.model.system.dto.SystemDictDTO;
import cn.org.jcloud.model.system.po.SystemDictPO;
import cn.org.jcloud.service.base.BaseService;

@FeignClient(name = "service-system",path="/system")
public interface SystemDictService extends BaseService<SystemDictDTO,SystemDictPO> {

}
