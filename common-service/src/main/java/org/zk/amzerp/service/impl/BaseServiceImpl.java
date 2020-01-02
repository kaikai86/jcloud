package org.zk.amzerp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.zk.amzerp.dao.BaseMapper;
import org.zk.amzerp.model.DataModel;
import org.zk.amzerp.service.BaseService;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class BaseServiceImpl<DTO,PO extends DataModel> implements BaseService<DTO,PO> {

    @Autowired
    BaseMapper<PO> baseMapper;

    @Override
    public boolean add(DTO dto) {
        PO po = null;
        try {
            Class<PO> entityClass = (Class<PO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
            po = entityClass.getConstructor().newInstance();
            BeanUtil.copyProperties(dto, po);
            po.setStatus("A");
            po.setCreateTime(new Date());
        } catch (Exception e) {

        }

       return baseMapper.insert(po) == 0?false:true;
    }

    @Override
    public boolean update(BigInteger id,DTO dto) {
        PO po = null;
        Example example = null;
        try {
            Class<PO> entityClass = (Class<PO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
            po = entityClass.getConstructor().newInstance();
            BeanUtil.copyProperties(dto, po);
            example = new Example(po.getClass());
            example.createCriteria().andEqualTo("status","A").andEqualTo("id",id);
            po.setUpdateTime(new Date());
        } catch (Exception e) {

        }
        return baseMapper.updateByExample(po,example) == 0?false:true;
    }

    @Override
    public boolean delete(BigInteger id) {
        PO t = findOne(id);
        if(t == null){
            return false;
        }
        t.setStatus("D");
        return baseMapper.updateByPrimaryKeySelective(t) == 0?false:true;
    }

    @Override
    public PO findOne(BigInteger id) {
        Class<PO> entityClass = (Class<PO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(entityClass);
        example.createCriteria().andEqualTo("status","A").andEqualTo("id",id);
        return baseMapper.selectOneByExample(example);
    }

    @Override
    public List<PO> selectAll() {
        Class<PO> entityClass = (Class<PO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(entityClass);
        example.createCriteria().andEqualTo("status","A");
        return baseMapper.selectByExample(example);
    }

    @Override
    public PageInfo<PO> selectAllPage(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).setOrderBy("id desc").doSelectPageInfo(() -> selectAll());
    }
}
