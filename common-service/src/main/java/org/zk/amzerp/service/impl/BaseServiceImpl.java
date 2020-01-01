package org.zk.amzerp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.zk.amzerp.dao.BaseMapper;
import org.zk.amzerp.model.DataModel;
import org.zk.amzerp.service.BaseService;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class BaseServiceImpl<T extends DataModel> implements BaseService<T> {

    @Autowired
    BaseMapper<T> baseMapper;

    @Override
    public boolean add(T t) {
        t.setStatus("A");
        t.setCreateTime(new Date());
       return baseMapper.insert(t) == 0?false:true;
    }

    @Override
    public boolean update(T t) {
        Example example = new Example(t.getClass());
        example.createCriteria().andEqualTo("status","A").andEqualTo("id",t.getId());
        t.setUpdateTime(new Date());
        return baseMapper.updateByExample(t,example) == 0?false:true;
    }

    @Override
    public boolean delete(BigInteger id) {
        T t = findOne(id);
        if(t == null){
            return false;
        }
        t.setStatus("D");
        return baseMapper.updateByPrimaryKeySelective(t) == 0?false:true;
    }

    @Override
    public T findOne(BigInteger id) {
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Example example = new Example(entityClass);
        example.createCriteria().andEqualTo("status","A").andEqualTo("id",id);
        return baseMapper.selectOneByExample(example);
    }

    @Override
    public List<T> selectAll() {
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Example example = new Example(entityClass);
        example.createCriteria().andEqualTo("status","A");
        return baseMapper.selectByExample(example);
    }

    @Override
    public PageInfo<T> selectAllPage(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).setOrderBy("id desc").doSelectPageInfo(() -> selectAll());
    }
}
