package org.zk.amzerp.controller.system;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zk.amzerp.client.system.SystemDictService;
import org.zk.amzerp.controller.util.PageParamContextHelper;
import org.zk.amzerp.model.system.dto.SystemDictDTO;
import org.zk.amzerp.model.system.po.SystemDictPO;

import java.math.BigInteger;

@RestController
@RequestMapping("/system")
public class SystemDictController {

    @Autowired
    private SystemDictService systemDictService;

    @GetMapping("/dicts")
    public Object findAll() {
        Page<SystemDictPO> page = PageParamContextHelper.getPage(SystemDictPO.class);
        Object systemDictPOIPage = null;
        if (ObjectUtil.isNotNull(page)) {
            systemDictPOIPage = systemDictService.selectAllPage(page);
        }else{
            systemDictPOIPage = systemDictService.selectAll();
        }
        return systemDictPOIPage;
    }

    @GetMapping("/dicts/{id}")
    public SystemDictPO get(@PathVariable BigInteger id) {
        return systemDictService.findOne(id);
    }

    @PostMapping("/dicts")
    public Object save(@RequestBody SystemDictDTO systemDictDTO) {
        return systemDictService.add(systemDictDTO);
    }

    @PutMapping("/dicts/{id}")
    public Object update(@PathVariable BigInteger id,@RequestBody SystemDictDTO systemDictDTO) {
       return systemDictService.update(id, systemDictDTO);
    }

    @DeleteMapping("/dicts/{id}")
    public Object delete(@PathVariable BigInteger id) {
        return systemDictService.delete(id);
    }

}
