package com.lenovo.operation.login;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURI());
        //登录不做拦截
        if(request.getRequestURI().equals("/user/login")||request.getRequestURI().equals("/user/createValicode")
                ||request.getRequestURI().equals("/user/tologin")) {
            return true;
        }
        //验证session是否存在
        Object obj = request.getSession().getAttribute("_session_user");
        if(obj == null)
        {
            response.sendRedirect("/user/login");
            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
