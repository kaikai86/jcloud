package org.jcloud.service.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.jcloud.model.DataModel;

import java.math.BigInteger;
import java.util.List;

public interface BaseService<DTO,PO extends DataModel> {

    @RequestMapping(value="/add",method = RequestMethod.POST)
    boolean add(@RequestBody  DTO dto);

    @RequestMapping(value="/update",method = RequestMethod.PUT)
    boolean update(@RequestParam("id") BigInteger id,@RequestBody DTO dto);

    @RequestMapping(value="/delete",method = RequestMethod.DELETE)
    boolean delete(@RequestParam("id") BigInteger id);

    @RequestMapping(value="/findOne",method = RequestMethod.GET)
    PO findOne(@RequestParam("id") BigInteger id);

    @RequestMapping(value="/selectAll",method = RequestMethod.GET)
    List<PO> selectAll();

    @RequestMapping(value="/selectAllPage",method = RequestMethod.POST)
    Page<PO> selectAllPage(@RequestBody Page<PO> page);

}
