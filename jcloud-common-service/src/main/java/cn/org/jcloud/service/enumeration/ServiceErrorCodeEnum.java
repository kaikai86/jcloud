package cn.org.jcloud.service.enumeration;


public enum ServiceErrorCodeEnum {

    S10001(10001, "新增数据异常【类%s】:%s"),
    S10002(10002, "更新数据异常【类%s】:%s"),
    S10003(10003, "删除数据异常【类%s】:%s"),
    S10004(10004, "获取数据异常【类%s】:%s"),
    S10005(10005, "查询数据异常【类%s】:%s"),
    S10006(10006, "查询分页数据异常【类%s】:%s"),
    S10007(10007, "查询分页条件数据异常【类%s】:%s");

    private int code;
    private String msg;

    ServiceErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Msg string.
     *
     * @return the string
     */
    public String msg() {
        return msg;
    }

    /**
     * Code int.
     *
     * @return the int
     */
    public int code() {
        return code;
    }

    /**
     * Gets enum.
     *
     * @param code the code
     *
     * @return the enum
     */
    public static ServiceErrorCodeEnum getEnum(int code) {
        for (ServiceErrorCodeEnum ele : ServiceErrorCodeEnum.values()) {
            if (ele.code() == code) {
                return ele;
            }
        }
        return null;
    }
}
