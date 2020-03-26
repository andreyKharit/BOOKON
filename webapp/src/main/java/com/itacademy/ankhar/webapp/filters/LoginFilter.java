/*
 * Copyright (c) 2020
 * Last updated: 2/19/20, 12:44 AM
 * Author: Andrey Kharitonenko
 */
package com.itacademy.ankhar.webapp.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/*"},
        filterName = "authFilter"
)
public class LoginFilter implements Filter {
    private HttpServletRequest httpRequest;
    private static final String[] PROTECTED_URLS = {
            "/main-menu", "/subjects"
    };

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //stub
    }

    //TODO filter debug
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        httpRequest = (HttpServletRequest) servletRequest;
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        String loginURI = httpRequest.getContextPath() + "/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");

        if (hasSessionAndUserId(httpRequest) && (isLoginRequest || isLoginPage)) {
            //login page AND logged in
            httpRequest.getRequestDispatcher("/main-menu.jsp").forward(servletRequest, servletResponse);

        } else if (!hasSessionAndUserId(httpRequest) && isLoginRequired()) {
            //protected page AND not logged in
            String loginPage = "/login.jsp";
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(servletRequest, servletResponse);
        } else {
            //either not protected page or already logged in
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        //stub
    }

    //check if URL is in protected list (PROTECTED_URLS)
    private boolean isLoginRequired() {
        String reqURL = httpRequest.getRequestURL().toString();
        for (String protectedUrl : PROTECTED_URLS) {
            if (reqURL.contains(protectedUrl)) {
                return true;
            }
        }
        return false;
    }

    //check for login
    private boolean hasSessionAndUserId(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        return session != null && session.getAttribute("authorized") != null;
    }
}
