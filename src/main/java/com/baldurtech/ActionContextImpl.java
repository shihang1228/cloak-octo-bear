package com.baldurtech;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.IOException;

public class ActionContextImpl implements ActionContext
{
    final ServletContext servletContext;
    final HttpServletRequest req;
    final HttpServletResponse resp;
    
    public ActionContextImpl(ServletContext servletContext, HttpServletRequest req, HttpServletResponse resp)
    {
        this.servletContext = servletContext;
        this.req = req;
        this.resp = resp;
    }
    
    public void setAttribute(String key, Object value)
    {
        req.setAttribute(key, value);
    }
    
    public PrintWriter getOut() throws IOException
    {
        return resp.getWriter();
    }
    
}