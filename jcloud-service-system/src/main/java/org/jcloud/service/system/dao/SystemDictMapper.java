package org.jcloud.service.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.jcloud.model.system.po.SystemDictPO;
import org.jcloud.service.system.dao.provider.SystemDictProvider;

import java.math.BigInteger;
import java.util.List;

public interface SystemDictMapper extends BaseMapper<SystemDictPO> {

    public Page<SystemDictPO> querySystemDictByName(IPage<SystemDictPO> page, String name);

    @Select("SELECT name FROM system_dict where status<>'D'")
    List<String> listIdByIdOrParentId();

    /**
     * 查询
     * @param orders
     * @return
     */
    @SelectProvider(type= SystemDictProvider.class, method="getByOrders")
    List<SystemDictPO> getByOrders(Integer orders);

}
