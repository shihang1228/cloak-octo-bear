package com.baldurtech;

import java.util.Map;
import java.util.HashMap;

public class ContactAction extends Action
{
    public ContactAction(ActionContext actionContext)
    {
        super(actionContext);
    }
    
    public void index()
    {
        println("Hi, Contact!!!");
    }
    
    public Map<String, Object> show()
    {
        actionContext.redirectAction("contact/list");
        return new HashMap<String, Object>();
    }
    
    
}