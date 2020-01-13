package org.jcloud.common.assertation;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import org.jcloud.common.enumeration.CommonErrorCodeEnum;
import org.jcloud.common.exception.CommonException;

public class CommonAssert {


    /**
     * TODO 判断是否一致
     * @param obj1 	预期结果只
     * @param obj2	判断值
     * @param codeEnum  错误码
     * @param args
     */
    public static void theSame(Object obj1, Object obj2, CommonErrorCodeEnum codeEnum, Object... args) {
        if(obj1 == null) {
            throw new CommonException(CommonErrorCodeEnum.GL99990100, args);
        }
        if(!obj1.equals(obj2)) {
            throw new CommonException(codeEnum, args);
        }
    }

    /**
     * 为null
     */
    public static void notNull(Object object, CommonErrorCodeEnum codeEnum, Object... args) {
        if (object != null) {
            throw new CommonException(codeEnum, args);
        }
    }

    /**
     * 不为null
     */
    public static void isNull(Object object, CommonErrorCodeEnum codeEnum, Object... args) {
        if (ObjectUtil.isNull(object) || "undefined".equals(object)) {
            throw new CommonException(codeEnum, args);
        }
    }


    /**
     * 为false
     */
    public static void notTrue(boolean flag, CommonErrorCodeEnum codeEnum, Object... args) {
        if (!flag) {
            throw new CommonException(codeEnum, args);
        }
    }


    /**
     * 为true
     */
    public static void isTrue(boolean flag, CommonErrorCodeEnum codeEnum, Object... args) {
        if (flag) {
            throw new CommonException(codeEnum, args);
        }
    }

    /**
     * TODO 抛异常
     * @param codeEnum
     * @param args
     */
    public static void throwError(CommonErrorCodeEnum codeEnum, Object... args) {
        throw new CommonException(codeEnum, args);
    }

}
