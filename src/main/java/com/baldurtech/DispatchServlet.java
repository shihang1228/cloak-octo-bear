package com.baldurtech;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

import java.util.Map;

public class DispatchServlet extends HttpServlet
{
    public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException
    {
        try
        {
            String uri = getUri(req);
            ActionContext actionContext = new ActionContextImpl(req, resp);
            Class actionClass = getActionByUri(uri);
            @SuppressWarnings("unchecked")
            Constructor actionConstructor = actionClass.getDeclaredConstructor(ActionContext.class);
            Action actionInstance = (Action)actionConstructor.newInstance(actionContext);
            @SuppressWarnings("unchecked")
            Method method = actionClass.getDeclaredMethod(getMethodNameByUri(uri));
            Object returnValue = method.invoke(actionInstance);
            
            if(returnValue != null)
            {
                TemplateEngine template = new JspTemplateEngine(getServletContext(), req, resp);
                template.merge(getViewPage(uri), returnValue);
            }
            
        }
        catch(NoSuchMethodException ex)
        {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public String defaultPackageName = "com.baldurtech";
    public String defaultSuffix = ".do";
    
    public String getUri(HttpServletRequest req)
    {
        return req.getRequestURI().replace(req.getContextPath(), "");
    }
    
    public Class getActionByUri(String uri) throws Exception
    {
        return Class.forName(getActionClassNameByUri(uri));
    }
    
    public String getActionClassNameByUri(String uri)
    {
        String[] uriParts = splitBySlash(uri);
        Integer indexOfActionClassName = 1;
        String actionClassName = removeDefaultSuffix(capitalize(uriParts[indexOfActionClassName]));
        return defaultPackageName + "." + actionClassName + "Action";        
    }
    
    public String[] splitBySlash(String uri)
    {
        return uri.split("/");
    }
    
    public String capitalize(String str)
    {
        return str.substring(0,1).toUpperCase() + str.substring(1);
    }
    
    public String getMethodNameByUri(String uri)
    {
        String[] uriParts = splitBySlash(uri);
        Integer indexOfActionClassName = 2;
        if(uriParts.length <= indexOfActionClassName)
        {
            return "index";
        }
        return removeDefaultSuffix(uriParts[indexOfActionClassName]);
    }
    
    public String removeDefaultSuffix(String str)
    {
        return str.replace(defaultSuffix,"");
    }
    
    public String getViewPage(String uri)
    {
        return "/WEB-INF/jsp" + removeDefaultSuffix(uri) + ".jsp";
    }
}