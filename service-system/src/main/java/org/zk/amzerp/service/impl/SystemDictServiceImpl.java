package org.zk.amzerp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zk.amzerp.client.system.SystemDictService;
import org.zk.amzerp.model.system.dto.SystemDictDTO;
import org.zk.amzerp.model.system.po.SystemDictPO;
import org.zk.amzerp.service.dao.mapper.SystemDictMapper;

@RestController
@RequestMapping("/system")
public class SystemDictServiceImpl extends BaseServiceImpl<SystemDictDTO,SystemDictPO> implements SystemDictService {

    @Autowired
    private SystemDictMapper systemDictMapper;

}
