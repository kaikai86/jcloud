package org.jcloud.controller.system;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jcloud.controller.api.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.jcloud.client.system.SystemDictService;
import org.jcloud.controller.util.PageParamContextHelper;
import org.jcloud.model.system.dto.SystemDictDTO;
import org.jcloud.model.system.po.SystemDictPO;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemDictController {

    @Autowired
    private SystemDictService systemDictService;

    @GetMapping("/dicts")
    public Result<List<SystemDictPO>> findAll() {
        List<SystemDictPO> systemDictPOS = PageParamContextHelper.endPage( systemDictService.selectAllPage(PageParamContextHelper.startPage(SystemDictPO.class)));
        Result<List<SystemDictPO>> pageResult = new Result<>();
        pageResult.setResult(systemDictPOS);
        return pageResult;
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
