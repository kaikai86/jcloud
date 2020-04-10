package cn.org.jcloud.service.system.dao.provider;

import org.apache.ibatis.jdbc.SQL;

public class SystemDictProvider {

    public String getByOrders(Integer orders){
        SQL sql = new  SQL();
        sql.SELECT("*").FROM("system_dict").WHERE("status <> 'D' and orders = #{orders}");
        return sql.toString();
    }
}
