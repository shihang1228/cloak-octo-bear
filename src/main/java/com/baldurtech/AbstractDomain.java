package com.baldurtech;

public abstract class AbstractDomain
{
    private boolean persistent = false;
    
    public Boolean isPersistent()
    {
        return persistent;
    }
    
    public void setPersistent(Boolean persistent)
    {
        this.persistent = persistent;
    }
}