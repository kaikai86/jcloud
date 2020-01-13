package org.jcloud.service.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.jcloud.model.system.po.SystemDictPO;
import org.jcloud.service.system.dao.provider.SystemDictProvider;

import java.math.BigInteger;
import java.util.List;

public interface SystemDictMapper extends BaseMapper<SystemDictPO> {

    public List<SystemDictPO> querySystemDictByName(String name);

    @Select("SELECT name FROM system_dict where status<>'D'")
    List<String> listIdByIdOrParentId();

    /**
     * 查询产品 上传中的产品
     * @param orders
     * @return
     */
    @SelectProvider(type= SystemDictProvider.class, method="getByOrders")
    List<SystemDictPO> getByOrders(Integer orders);

}
