package com.baldurtech;

import javax.servlet.ServletContext;
import java.io.PrintWriter;
import java.io.IOException;

public abstract class Action
{
    final ActionContext actionContext;
    
    public Action(ActionContext actionContext)
    {
        this.actionContext = actionContext;
    }
    
    public void setAttribute(String key, Object value)
    {
        actionContext.setAttribute(key, value);
    }
    
    public void println(String str)
    {
        try
        {
            actionContext.getOut().println(str);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}