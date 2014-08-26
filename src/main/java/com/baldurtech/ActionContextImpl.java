package com.baldurtech;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.IOException;

public class ActionContextImpl implements ActionContext
{
    final HttpServletRequest req;
    final HttpServletResponse resp;
    
    public ActionContextImpl(HttpServletRequest req, HttpServletResponse resp)
    {
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
    
    public String getParameter(String name)
    {
        return req.getParameter(name);
    }
    
    public void redirectAction(String actionUri)
    {
        try
        {
            resp.sendRedirect(actionUri + ".do");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
}