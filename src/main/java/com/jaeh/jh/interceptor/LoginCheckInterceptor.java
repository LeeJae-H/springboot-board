package com.jaeh.jh.interceptor;

import com.jaeh.jh.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1. 세션에서 회원 정보 조회
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginResult");

        // 2. 회원 정보 체크
        if (user == null) {
            response.sendRedirect("/users/login");
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
