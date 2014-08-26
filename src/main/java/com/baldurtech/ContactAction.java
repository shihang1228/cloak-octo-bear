package com.baldurtech;

import java.util.Map;
import java.util.HashMap;

public class ContactAction extends Action
{
    final private ContactManager contactManager;
    
    public ContactAction(ActionContext actionContext, ContactManager contactManager)
    {
        super(actionContext);
        this.contactManager = contactManager;
    }
    
    public void index()
    {
        println("Hi, Contact!!!");
    }
    
    public void save()
    {
        Contact contact = new Contact();
        contact.setName(actionContext.getParameter("name"));
        contact.setMobile(actionContext.getParameter("mobile"));
        contact.setVpmn(actionContext.getParameter("vpmn"));
        contact.setEmail(actionContext.getParameter("email"));
        contact.setHomeAddress(actionContext.getParameter("homeAddress"));
        contact.setOfficeAddress(actionContext.getParameter("officeAddress"));
        contact.setMemo(actionContext.getParameter("memo"));
        contact.setJob(actionContext.getParameter("job"));
        
        if(actionContext.getParameter("jobLevel") != null)
        {
            contact.setJobLevel(Long.valueOf(actionContext.getParameter("jobLevel")));
        }
        Contact savedContact = contactManager.save(contact);
        if(savedContact.isPersistent())
        {
            actionContext.redirectAction("contact/list");
        }
        else
        {
            
        }
    }
    
    
    public Map<String, Object> show()
    {
        actionContext.redirectAction("contact/list");
        return new HashMap<String, Object>();
    }
    
    
}