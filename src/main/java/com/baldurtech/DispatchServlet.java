package com.baldurtech;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class DispatchServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException
    {
        
    }
    
    public String defaultPackageName = "com.baldurtech";
    public String methodSuffix = ".jsp";
    public String getActionClassNameByUri(String uri)
    {
        String[] uriParts = splitBySlash(uri);
        Integer indexOfActionClassName = 1;
        String actionClassName = capitalize(uriParts[indexOfActionClassName]);
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
        return uriParts[indexOfActionClassName].replace(methodSuffix,"");
    }
}