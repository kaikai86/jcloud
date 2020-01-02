package org.zk.amzerp.service;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zk.amzerp.model.DataModel;

import javax.xml.crypto.Data;
import java.lang.reflect.InvocationTargetException;
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

    @RequestMapping(value="/findAll",method = RequestMethod.GET)
    List<PO> selectAll();

    @RequestMapping("/selectAllPage")
    PageInfo<PO> selectAllPage(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize);

}
