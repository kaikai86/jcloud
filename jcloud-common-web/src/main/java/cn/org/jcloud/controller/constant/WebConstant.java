package cn.org.jcloud.controller.constant;

import cn.org.jcloud.common.constant.CommonConstant;

public interface WebConstant extends CommonConstant {

    //=============================================请求分页参数常量======================================================
    String HAS_PAGE = "hasPage";
    String PAGE_NUMBER = "pageNumber";
    String PAGE_SIZE = "pageSize";
    String TOTAL_PAGE = "totalPage";

    //=============================================HTTP响应状态常量=====================================================

    /** {@code 200 OK} (HTTP/1.0 - RFC 1945) */
    Integer SC_OK_200 = 200;
    /** {@code 400 Bad Request} (HTTP/1.0 - RFC 1945) */
    Integer SC_BAD_REQUEST = 400;
    /** {@code 404 Not Found} (HTTP/1.0 - RFC 1945) */
    Integer SC_NOT_FOUND_404 = 404;
    /** {@code 404 Method not Allowed} (HTTP/1.0 - RFC 1945) */
    Integer SC_METHOD_NOT_ALLOWED_405 = 405;
    /** {@code 500 Server Error} (HTTP/1.0 - RFC 1945) */
    Integer SC_INTERNAL_SERVER_ERROR_500 = 500;
    /**访问权限认证未通过 510*/
    Integer SC_JEECG_NO_AUTHZ=510;

}
