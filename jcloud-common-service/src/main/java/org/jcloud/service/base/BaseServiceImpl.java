package org.jcloud.service.base;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jcloud.common.exception.CommonException;
import org.jcloud.model.base.DataModel;
import org.jcloud.service.exception.ServiceException;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class BaseServiceImpl<M extends BaseMapper<PO>,DTO,PO extends DataModel> extends ServiceImpl<M, PO> implements BaseService<DTO,PO>,IService<PO>{


    @Override
    public boolean add(@Valid DTO dto) throws CommonException{
        PO po = null;
        try {
            Class<PO> entityClass = (Class<PO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
            po = entityClass.getConstructor().newInstance();
            BeanUtil.copyProperties(dto, po);
            return this.save(po);
        } catch (Exception e) {
            log.error("新增异常-->{}",e.getCause());
            throw new ServiceException(10000, String.format("数据库异常【%s】:%s",po.getClass().getName(),e.getMessage()));
        }
//        return false;
    }

    @Override
    public boolean edit(BigInteger id, DTO dto) {
        PO po = null;
        try {
            Class<PO> entityClass = (Class<PO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
            po = entityClass.getConstructor().newInstance();
            BeanUtil.copyProperties(dto, po);
            po.setId(id);
            return this.updateById(po);
        } catch (Exception e) {
            log.error("修改异常-->{}",e.getCause());
            throw new ServiceException(10000, String.format("数据库异常【%s】:%s",po.getClass().getName(),e.getMessage()));
        }
    }

    @Override
    public boolean delete(BigInteger id) {
        return this.removeById(id);
    }

    @Override
    public PO findOne(BigInteger id) {
        return this.getById(id);
    }

    @Override
    public List<PO> selectAll() {
        return this.list();
    }

    @Override
    public Page<PO> selectAllPage(Page<PO> page) {
        return this.page(page);
    }

    @Override
    public Page<PO> selectAllPageQueryAllEq(Map<String, Object> queryMap, Page<PO> page) {
        QueryWrapper<PO> queryWrapper = new QueryWrapper<>();
        queryWrapper.allEq(queryMap, false);
        return this.page(page, queryWrapper);
    }
}
