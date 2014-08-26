package com.baldurtech;

public class ContactManagerMock implements ContactManager
{
    public Contact saveShouldReturn;
    
    public Contact save(Contact contact)
    {
        return saveShouldReturn;
    }
}