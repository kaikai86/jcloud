package cn.org.jcloud.service.base;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.org.jcloud.model.base.DataModel;
import cn.org.jcloud.service.enumeration.ServiceErrorCodeEnum;
import cn.org.jcloud.service.exception.ServiceException;
import org.springframework.validation.annotation.Validated;

import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class BaseServiceImpl<M extends BaseMapper<PO>,DTO,PO extends DataModel> extends ServiceImpl<M, PO> implements BaseService<DTO,PO>,IService<PO>{


    @Override
    public boolean add(@Validated DTO dto){
        PO po = null;
        try {
            Class<PO> entityClass = (Class<PO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
            po = entityClass.getConstructor().newInstance();
            BeanUtil.copyProperties(dto, po);
            return this.save(po);
        } catch (Exception e) {
            log.error("新增异常-->{}",e.getCause());
            throw new ServiceException(ServiceErrorCodeEnum.S10001,po.getClass().getName(),e.getMessage());
        }
    }

    @Override
    public boolean edit(BigInteger id, @Validated DTO dto) {
        PO po = null;
        try {
            Class<PO> entityClass = (Class<PO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
            po = entityClass.getConstructor().newInstance();
            BeanUtil.copyProperties(dto, po);
            po.setId(id);
            return this.updateById(po);
        } catch (Exception e) {
            log.error("修改异常-->{}",e.getCause());
            throw new ServiceException(ServiceErrorCodeEnum.S10002,po.getClass().getName(),e.getMessage());
        }
    }

    @Override
    public boolean delete(BigInteger id) {
        Class<PO> entityClass = (Class<PO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
        try {
             return this.removeById(id);
        } catch (Exception e) {
            log.error("删除异常-->{}",e.getCause());
            throw new ServiceException(ServiceErrorCodeEnum.S10003,entityClass.getName() ,e.getMessage());
        }
    }

    @Override
    public PO findOne(BigInteger id) {
        Class<PO> entityClass = (Class<PO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
        try {
            return this.getById(id);
        } catch (Exception e) {
            log.error("获取异常-->{}",e.getCause());
            throw new ServiceException(ServiceErrorCodeEnum.S10004,entityClass.getName() ,e.getMessage());
        }
    }

    @Override
    public List<PO> selectAll() {
        Class<PO> entityClass = (Class<PO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
        try {
            return this.list();
        } catch (Exception e) {
            log.error("查询异常-->{}",e.getCause());
            throw new ServiceException(ServiceErrorCodeEnum.S10005,entityClass.getName() ,e.getMessage());
        }

    }

    @Override
    public Page<PO> selectAllPage(Page<PO> page) {
        Class<PO> entityClass = (Class<PO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
        try {
            return this.page(page);
        } catch (Exception e) {
            log.error("查询分页异常-->{}",e.getCause());
            throw new ServiceException(ServiceErrorCodeEnum.S10006,entityClass.getName() ,e.getMessage());
        }
    }

    @Override
    public Page<PO> selectAllPageQueryAllEq(Map<String, Object> queryMap, Page<PO> page) {
        Class<PO> entityClass = (Class<PO>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
        try {
            QueryWrapper<PO> queryWrapper = new QueryWrapper<>();
            queryWrapper.allEq(queryMap, false);
            return this.page(page, queryWrapper);
        } catch (Exception e) {
            log.error("查询分页条件异常-->{}",e.getCause());
            throw new ServiceException(ServiceErrorCodeEnum.S10007,entityClass.getName() ,e.getMessage());
        }
    }
}
