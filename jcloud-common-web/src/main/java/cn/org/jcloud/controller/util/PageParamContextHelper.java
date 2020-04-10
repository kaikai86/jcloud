package cn.org.jcloud.controller.util;

import cn.org.jcloud.controller.constant.WebConstant;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.MDC;

import java.util.List;

/**
 * 上下文帮助类
 * 
 * @author zk
 *
 */
public class PageParamContextHelper {


    public static <PO> Page<PO> startPage(Class<PO> clazz) {
        if (!PageParam.hasPage()) {
            return new Page<PO>();
        }
        return new Page<>(PageParam.getPageSize(),PageParam.getPageNumer());
    }

    public static <PO> List<PO> endPage(Page<PO> page) {
        MDC.put(WebConstant.TOTAL_PAGE, String.valueOf(page.getTotal()));
        return page.getRecords();
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
            return Boolean.valueOf(MDC.get(WebConstant.HAS_PAGE));
        }

        /**
         * 获取当前查询的页码
         *
         * @return
         */
        public static Integer getPageNumer() {
            return Integer.valueOf(MDC.get(WebConstant.PAGE_NUMBER));
        }

        /**
         * 获取当前设置的页面大小
         *
         * @return
         */
        public static Integer getPageSize() {
            return Integer.valueOf(MDC.get(WebConstant.PAGE_SIZE));
        }

        /**
         * 获取当前设置的页面大小
         *
         * @return
         */
        public static Long getTotalPage() {
            return Long.valueOf(MDC.get(WebConstant.TOTAL_PAGE));
        }

    }

}
