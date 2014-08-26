package com.baldurtech;

import com.baldurtech.unit.TestCase;
public class ContactActionTest extends TestCase
{   
    public void test_show_当id为空的时候应该跳转到list()
    {
        ActionContextMock actionContext = new ActionContextMock();
        actionContext.setParameter("id", null);
        ContactAction action = new ContactAction(actionContext);
        action.show();
        
        assertEquals("contact/list", actionContext.redirectActionParam);
    }
}