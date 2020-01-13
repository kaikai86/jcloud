package org.jcloud.service.system.impl;

import cn.hutool.json.JSONUtil;
import org.jcloud.client.system.SystemDictService;
import org.jcloud.model.system.po.SystemDictPO;
import org.jcloud.service.system.dao.SystemDictMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SystemDictServiceImplTest {

    @Autowired
    private SystemDictService systemDictService;
    @Autowired
    private SystemDictMapper systemDictMapper;
    @Test
    public void testXmlSql() {
        System.out.println(("----- selectAll method test ------"));
        List<SystemDictPO> dictList = systemDictService.selectAll();
        for (SystemDictPO systemDictPO : dictList) {
            System.err.println(JSONUtil.toJsonStr(systemDictPO));
        }
    }

    @Test
    public void testMapperSql() {
        System.out.println(("----- selectAll method test ------"));
        List<String> strings = systemDictMapper.listIdByIdOrParentId();
        for (String string : strings) {
            System.err.println(string);
        }
    }

    @Test
    public void testProviderSql() {
        System.out.println(("----- selectAll method test ------"));
        List<SystemDictPO> byOrders = systemDictMapper.getByOrders(88);
        for (SystemDictPO byOrder : byOrders) {
            System.err.println(JSONUtil.toJsonStr(byOrder));
        }
    }
}