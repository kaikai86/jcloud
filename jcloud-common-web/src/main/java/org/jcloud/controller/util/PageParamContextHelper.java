package org.jcloud.controller.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.MDC;

/**
 * 上下文帮助类
 * 
 * @author zk
 *
 */
public class PageParamContextHelper {


    public static <PO> Page<PO> getPage(Class<PO> clazz) {
        if (!PageParam.hasPage()) {
            return null;
        }
        Integer pageNumer = PageParam.getPageNumer();
        Integer pageSize = PageParam.getPageSize();
        return new Page<>(pageSize, pageNumer);
    }


    /**
     * 获取上下文中的分页参数
     * 
     * @author haozi
     *
     */
    public static class PageParam {

        /**
         * 查询当前是否开启分页查询
         *
         * @return
         */
        public static Boolean hasPage() {
            return Boolean.valueOf(MDC.get("hasPage"));
        }

        /**
         * 获取当前查询的页码
         * 
         * @return
         */
        public static Integer getPageNumer() {
            return Integer.valueOf(MDC.get("pageNumber"));
        }

        /**
         * 获取当前设置的页面大小
         * 
         * @return
         */
        public static Integer getPageSize() {
            return Integer.valueOf(MDC.get("pageSize"));
        }

    }

    public static void main(String[] args) {

    }

}
