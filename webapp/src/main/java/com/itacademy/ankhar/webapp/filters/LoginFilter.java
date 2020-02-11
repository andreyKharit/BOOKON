package com.itacademy.ankhar.webapp.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/*"},
        filterName = "authFilter", initParams = {
        @WebInitParam(
                name = "activeSwitch",
                value = "true",
                description = "authentication switch"
        )
}
)
public class LoginFilter implements Filter {
    private boolean activeSwitch;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String switchStatus = filterConfig.getInitParameter("activeSwitch");
        this.activeSwitch = switchStatus.equalsIgnoreCase("true");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (activeSwitch) {
            if (bypassFilter(req) || hasSessionAndUserId(req)) {
                filterChain.doFilter(req, resp);
            } else {
                resp.sendError(401, "Authorization error.");
            }
        } else {
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
        //stub
    }

    private boolean bypassFilter(HttpServletRequest req) {
        String requestPath = req.getContextPath();
        String requestURI = req.getRequestURI();
        return requestURI.equals(requestPath + "/login.jsp") ||
                requestURI.equals(requestPath + "/login") ||
                requestURI.equals(requestPath + "/error401.jsp");
    }

    private boolean hasSessionAndUserId(HttpServletRequest req) {
        HttpSession session = req.getSession();
        return session != null && session.getAttribute("userId") != null;
    }
}
