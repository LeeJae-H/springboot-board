package com.jaeh.jh.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");

        if (loginInfo == null) {
            response.sendRedirect("/users/login");
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
