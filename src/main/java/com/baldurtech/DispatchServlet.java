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
    
    public String getActionClassNameByUri(String uri)
    {
        String[] uriParts = uri.split("/");
        Integer indexOfActionClassName = 1;
        String actionClassName = uriParts[indexOfActionClassName];
        actionClassName = actionClassName.substring(0,1).toUpperCase() + actionClassName.substring(1);
        return "com.baldurtech." + actionClassName + "Action";
        
    }
}