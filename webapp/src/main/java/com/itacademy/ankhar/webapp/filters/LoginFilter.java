/*
 * 2020
 * Last updated: 4/2/20, 1:03 AM
 * Author: Andrey Kharitonenko
 */
package com.itacademy.ankhar.webapp.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@WebFilter(
        urlPatterns = {"/*"},
        filterName = "authFilter",
        initParams = {
                @WebInitParam(name = "active", value = "true", description = "authentication activation")
        }
)
public class LoginFilter implements Filter {
    private HttpServletRequest httpRequest;

    private static final Set<String> ALLOWED_URLS = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList("/index", "/index.jsp", "/login.jsp", "/login", "/registration", "/error401.jsp", "/"))
    );

    private static final String ACTIVE_FILTER = "active";
    private static final String PARAMETER_TO_CHECK = "authorized";
    private boolean filterActive;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String active = filterConfig.getInitParameter(ACTIVE_FILTER);
        this.filterActive = active != null && active.toLowerCase().equals("true");
    }

    //TODO filter debug
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (!filterActive || bypass(request) || hasSessionAndUserId(request)) {
            filterChain.doFilter(request, response);
        } else {
            response.sendError(401);
        }
    }

    @Override
    public void destroy() {
        //stub
    }

    //check if URL is in unprotected list
    private boolean bypass(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String path = request.getRequestURI().replaceFirst(contextPath, "");
        return ALLOWED_URLS.stream().anyMatch(path::equals);
    }

    //check for login
    private boolean hasSessionAndUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        return session != null && session.getAttribute(PARAMETER_TO_CHECK) != null;
    }
}
