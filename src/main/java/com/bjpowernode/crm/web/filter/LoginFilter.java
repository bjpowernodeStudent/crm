package com.bjpowernode.crm.web.filter;

import com.bjpowernode.crm.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain Chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;
        User user=(User) request.getSession().getAttribute("user");
        String path=request.getServletPath();
        if ("/login.jsp".equals(path)||"/settings/user/login.do".equals(path)){
            Chain.doFilter(req,resp);
        }else {
            if (user!=null){
                Chain.doFilter(req,resp);
            }else {
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }

    }
}
