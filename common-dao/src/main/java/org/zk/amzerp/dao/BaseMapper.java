package org.zk.amzerp.dao;

import org.zk.amzerp.model.DataModel;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


public interface BaseMapper<T extends DataModel> extends Mapper<T>, MySqlMapper<T> {

}
