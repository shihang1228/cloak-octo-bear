package com.baldurtech;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action
{
    final ServletContext servletContext;
    final HttpServletRequest req;
    final HttpServletResponse resp;
    
    public Action()
    {
        this(null, null, null);
    }
    
    public Action(ServletContext servletContext, HttpServletRequest req,HttpServletResponse resp)
    {
        this.servletContext = servletContext;
        this.req = req;
        this.resp = resp;
    }
    
    public String getViewPage(String uri)
    {
        return "/WEB-INF/jsp" + uri;
    }
}