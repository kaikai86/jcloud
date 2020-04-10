package cn.org.jcloud.common.assertation;

import cn.hutool.core.util.ObjectUtil;
import cn.org.jcloud.common.enumeration.CommonErrorCodeEnum;
import cn.org.jcloud.common.exception.CommonException;

public class CommonAssert {


    /**
     * 判断是否一致
     * @param obj1 	预期结果
     * @param obj2	判断值
     * @param codeEnum  错误码
     * @param args
     */
    public static void theSame(Object obj1, Object obj2, CommonErrorCodeEnum codeEnum, Object... args) {
        if(!obj1.equals(obj2)) {
            throw new CommonException(codeEnum, args);
        }
    }

    /**
     * 判断是否一致
     * @param obj1 	预期结果只
     * @param obj2	判断值
     */
    public static void theSame(Object obj1, Object obj2, CommonException commonException) {
        if(!obj1.equals(obj2)) {
            throw commonException;
        }
    }

    /**
     * 为null
     */
    public static void notNull(Object object, CommonErrorCodeEnum codeEnum, CommonException commonException, Object... args) {
        if (object != null) {
            throw new CommonException(codeEnum, args);
        }
    }

    /**
     * 为null
     */
    public static void notNull(Object object,  CommonException commonException) {
        if (object != null) {
            throw commonException;
        }
    }

    /**
     * 不为null
     */
    public static void isNull(Object object,  CommonException commonException) {
        if (ObjectUtil.isNull(object) || "undefined".equals(object)) {
            throw commonException;
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
     * 为false
     */
    public static void notTrue(boolean flag, CommonException commonException) {
        if (!flag) {
            throw commonException;
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
     * 为true
     */
    public static void isTrue(boolean flag, CommonException commonException) {
        if (flag) {
            throw commonException;
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
