package com.bjpowernode.crm.web.filter;


import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain Chain) throws IOException, ServletException {
        //处理POST请求中文参数
        req.setCharacterEncoding("utf-8");

        //处理响应流中文参数
        resp.setContentType("text/html;charset=utf-8");

        //将请求放行
        Chain.doFilter(req,resp);
    }
}
