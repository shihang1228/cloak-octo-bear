package com.baldurtech;

import com.baldurtech.unit.TestCase;

public class ContactRepositoryTest extends TestCase
{
    public void test_根据指定id删除Contact()
    {
        DatabaseManagerMock db = new DatabaseManagerMock();
        ContactRepository contactRepository = new ContactRepository(db);
        
        contactRepository.deleteById(1L);       
        assertEquals("DELETE FROM contact WHERE id=1",db.executeUpdateParam);
    }
    
    public void test_更新指定Contact()
    {
        DatabaseManagerMock db = new DatabaseManagerMock();
        ContactRepository contactRepository = new ContactRepository(db);
        Contact contact = new Contact();
        contact.setName("Tom");
        contact.setId(1L);
        contact.setMobile("18235408753");
        contact.setEmail("1335932576@qq.com");
        contactRepository.update(contact);
        
        assertEquals("UPDATE contact SET mobile=18235408753, name=Tom,email=1335932576@qq.com WHERE id=1", db.executeUpdateParam);
    }
}