package org.jcloud.controller.base;


import cn.hutool.db.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebBaseController {

    private HttpServletRequest request;

    private HttpServletResponse response;

    private PageParam page = new PageParam();

}
