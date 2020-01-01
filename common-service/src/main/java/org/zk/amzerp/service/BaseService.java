package org.zk.amzerp.service;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.util.List;

public interface BaseService<T> {

    @RequestMapping("/add")
    boolean add(T t);

    @RequestMapping("/update")
    boolean update(T t);

    @RequestMapping("/delete")
    boolean delete(BigInteger id);

    @RequestMapping("/findOne")
    T findOne(BigInteger id);

    @RequestMapping("/findAll")
    List<T> selectAll();

    @RequestMapping("/selectAllPage")
    PageInfo<T> selectAllPage(int pageNum, int pageSize);

}
