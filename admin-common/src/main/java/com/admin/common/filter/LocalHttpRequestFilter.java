package com.admin.common.filter;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/*",filterName = "localHttpRequestFilter")
public class LocalHttpRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CurrentRequest.setRequest((HttpServletRequest)servletRequest);
        CurrentRequest.setResponse((HttpServletResponse)servletResponse);
    }

    @Override
    public void destroy() {
        CurrentRequest.clear();
    }
}
