package org.zk.amzerp.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zk.amzerp.client.system.SystemDictService;
import org.zk.amzerp.model.system.po.SystemDictPO;

import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemDictController {

    @Autowired
    private SystemDictService systemDictService;

    @GetMapping("/dicts")
    public List<SystemDictPO> findAll() {
        return systemDictService.selectAll();
    }

}
