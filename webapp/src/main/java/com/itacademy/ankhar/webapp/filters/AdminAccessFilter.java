/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.webapp.filters;

import com.itacademy.ankhar.util.UserDBUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/subjects.jsp", "/subjects"},
        filterName = "adminAccessFilter"
)
public class AdminAccessFilter implements Filter {
    private HttpServletRequest httpRequest;
    private UserDBUtil utils = UserDBUtil.getInstance();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        httpRequest = (HttpServletRequest) request;
        if (!httpRequest.getSession().getAttribute("status").equals("admin")) {
            httpRequest.getRequestDispatcher("/main-menu.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
