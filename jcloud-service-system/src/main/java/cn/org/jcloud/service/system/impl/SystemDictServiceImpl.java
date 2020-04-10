package cn.org.jcloud.service.system.impl;

import cn.org.jcloud.service.base.BaseServiceImpl;
import cn.org.jcloud.service.system.dao.SystemDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.org.jcloud.client.system.SystemDictService;
import cn.org.jcloud.model.system.dto.SystemDictDTO;
import cn.org.jcloud.model.system.po.SystemDictPO;

@RestController
@RequestMapping("/system")
public class SystemDictServiceImpl extends BaseServiceImpl<SystemDictMapper,SystemDictDTO,SystemDictPO> implements SystemDictService {

    @Autowired
    private SystemDictMapper systemDictMapper;
}
