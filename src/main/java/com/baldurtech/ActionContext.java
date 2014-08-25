package com.baldurtech;

import java.io.PrintWriter;
import java.io.IOException;
public interface ActionContext
{
    public void setAttribute(String key, Object value);
    public PrintWriter getOut() throws IOException;
}