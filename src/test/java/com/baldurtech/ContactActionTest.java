package com.baldurtech;

import com.baldurtech.unit.TestCase;
public class ContactActionTest extends TestCase
{   
    ContactManagerMock contactManager;
    ActionContextMock actionContext;
    ContactAction action;
    //工龄工资涨多少，，，
    public void setUp()
    {
        contactManager = new ContactManagerMock();
        actionContext = new ActionContextMock();
        action = new ContactAction(actionContext, contactManager);
    }

    public void test_show_当id为空的时候应该跳转到list()
    {
        setUp();
        actionContext.setParameter("id", null);
        action.show();
        
        assertEquals("contact/list", actionContext.redirectActionParam);
    }
    
    public void test_save_保存成功后要跳到list()
    {
        setUp();
        actionContext.setParameter("id", null);
        contactManager.saveShouldReturn = createPersistentContactWithId(1L);     
        action.save();
        
        assertEquals("contact/list", actionContext.redirectActionParam);
    }
    
    public Contact createPersistentContactWithId(Long id)
    {
        Contact contact = new Contact();
        contact.setId(id);
        contact.setPersistent(true);
        
        return contact;
    }
}