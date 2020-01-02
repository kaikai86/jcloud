package org.zk.amzerp.controller.system;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zk.amzerp.client.system.SystemDictService;
import org.zk.amzerp.model.system.dto.SystemDictDTO;
import org.zk.amzerp.model.system.po.SystemDictPO;

import java.math.BigInteger;
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

    @PostMapping("/dicts")
    public Object save(@RequestBody SystemDictDTO systemDictDTO) {
        boolean add = systemDictService.add(systemDictDTO);
        System.out.println(add);
        return add;
    }

    @PutMapping("/dicts/{id}")
    public Object save(@PathVariable BigInteger id,@RequestBody SystemDictDTO systemDictDTO) {
        boolean add = systemDictService.update(id, systemDictDTO);
        System.out.println(add);
        return add;
    }

}
