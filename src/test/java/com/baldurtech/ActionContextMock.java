package com.baldurtech;

import java.util.Map;
import java.util.HashMap;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.StringWriter;

public class ActionContextMock implements ActionContext
{
    public String redirectActionParam;
    Map<String, String> params = new HashMap<String, String>();
    
    public void setParameter(String name, String value)
    {
        params.put(name,value);
    }
    
    public String getParameter(String name)
    {
        return params.get(name);
    }
       
    public void redirectAction(String actionUri)
    {
        redirectActionParam = actionUri;
    }    
    
    public void setAttribute(String key, Object value)
    {
        
    }
    
    public PrintWriter getOut() throws IOException
    {
        return new PrintWriter(new StringWriter());
    }
}