package cn.org.jcloud.common.enumeration;


public enum CommonErrorCodeEnum {
    // 9999100
    GL99990100(9999100, "参数异常"),
    // 99990401
    GL99990401(99990401, "无访问权限"),
    // 9999403
    GL99990403(9999403, "无权访问"),
    // 9999404
    GL9999404(9999404, "找不到指定资源"),
    // 99990001
    GL99990001(99990001, "注解使用错误"),
    // 99990002
    GL99990002(99990002, "微服务不在线,或者网络超时");

    /**
     * cloud
     */
//    B1000(1000, "您的登录已失效，请重新登录"),
//    B1001(1001, "该账号不存在，请重新输入"),
//    B1002(1002, "章数据有误，请重新盖章"),
//    B1003(1003, "传入参数异常"),
//    B1004(1004, "USBKey绑定失败，不能重复绑定!"),
//    B1005(1005, "导入文件格式出错，请导入Excel表格!"),
//    B1006(1006, "Excel表格列数与表头的长度不一致"),
//    B1007(1007, "导入表格不符合模板格式，请重新下载模板，填入数据"),
//    B1008(1008, "保函接口回调异常，%s"),
//    B1009(1009, "标段已废除"),
//    B1010(1010, "评标结果尚不存在"),
//    B1011(1011, "您没有访问权限") ;

    private int code;
    private String msg;

    CommonErrorCodeEnum(int code, String msg) {
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
    public static CommonErrorCodeEnum getEnum(int code) {
        for (CommonErrorCodeEnum ele : CommonErrorCodeEnum.values()) {
            if (ele.code() == code) {
                return ele;
            }
        }
        return null;
    }

}
