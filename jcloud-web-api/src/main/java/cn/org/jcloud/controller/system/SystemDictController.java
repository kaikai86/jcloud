package cn.org.jcloud.controller.system;

import cn.org.jcloud.common.enumeration.CommonErrorCodeEnum;
import cn.org.jcloud.controller.api.vo.Result;
import cn.org.jcloud.controller.api.vo.WrapMapper;
import cn.org.jcloud.controller.assertation.WebAssert;
import cn.org.jcloud.controller.util.PageParamContextHelper;
import cn.org.jcloud.model.system.query.SystemDictQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import cn.org.jcloud.client.system.SystemDictService;
import cn.org.jcloud.model.system.dto.SystemDictDTO;
import cn.org.jcloud.model.system.po.SystemDictPO;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/system")
public class SystemDictController {

    @Autowired
    private SystemDictService systemDictService;

    @GetMapping("/dicts")
    public Result<List<SystemDictPO>> findAll(SystemDictQuery systemDictQuery) {
        List<SystemDictPO> systemDictPOS = PageParamContextHelper.endPage(systemDictService.selectAllPage(PageParamContextHelper.startPage(SystemDictPO.class)));
        return WrapMapper.ok(systemDictPOS);
    }

    @GetMapping("/dicts/{id}")
    public Result<SystemDictPO> get(@PathVariable BigInteger id) {
        SystemDictPO one = systemDictService.findOne(id);
        WebAssert.isNull(one, CommonErrorCodeEnum.GL9999404);
        return WrapMapper.ok(one);
    }

    @PostMapping("/dicts")
    public Result save(@Validated @RequestBody SystemDictDTO systemDictDTO) {
        return WrapMapper.okOrFail(systemDictService.add(systemDictDTO));
    }

    @PutMapping("/dicts/{id}")
    public Result update(@PathVariable BigInteger id, @Validated @RequestBody SystemDictDTO systemDictDTO) {
       return WrapMapper.okOrFail(systemDictService.edit(id, systemDictDTO));
    }

    @DeleteMapping("/dicts/{id}")
    public Result delete(@PathVariable BigInteger id) {
        return WrapMapper.okOrFail(systemDictService.delete(id));
    }

}
