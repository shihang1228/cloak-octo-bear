package com.baldurtech;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import java.util.Map;

public class JspTemplateEngine implements TemplateEngine
{
    private final HttpServletRequest req;
    private final HttpServletResponse resp;
    private final ServletContext servletContext;

    public JspTemplateEngine(ServletContext servletContext, HttpServletRequest req, HttpServletResponse resp)
    {
        this.servletContext = servletContext;
        this.req = req;
        this.resp = resp;
    }
    public void merge(String page, Object data)
    {
        try
        {
            if(data instanceof Map)
            {
                 @SuppressWarnings("unchecked")
                Map<String, Object> dataModel = (Map<String, Object>)data;
                for(String key : dataModel.keySet())
                {
                    req.setAttribute(key, dataModel.get(key));
                }              
            }
            else
            {
                req.setAttribute("data", data);
            }
            servletContext.getRequestDispatcher(page).forward(req, resp);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}