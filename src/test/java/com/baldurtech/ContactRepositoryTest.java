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
        
        assertArrayEquals(new Object[]{"Tom","1335932576@qq.com","18235408753",1L},db.executeUpdateParam2);
        assertEquals("UPDATE contact SET mobile=?, name=?,email=? WHERE id=?", db.executeUpdateParam);
    }
}