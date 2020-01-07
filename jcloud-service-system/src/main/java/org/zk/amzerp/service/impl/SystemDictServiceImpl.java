package org.jcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.jcloud.client.system.SystemDictService;
import org.jcloud.model.system.dto.SystemDictDTO;
import org.jcloud.model.system.po.SystemDictPO;
import org.jcloud.service.base.BaseServiceImpl;
import org.jcloud.service.dao.mapper.SystemDictMapper;

@RestController
@RequestMapping("/system")
public class SystemDictServiceImpl extends BaseServiceImpl<SystemDictMapper,SystemDictDTO,SystemDictPO> implements SystemDictService {

    @Autowired
    private SystemDictMapper systemDictMapper;

}
