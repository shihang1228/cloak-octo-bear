package com.baldurtech;

public class ContactRepository
{
    private DatabaseManager db;
    public ContactRepository(DatabaseManager db)
    {
        this.db = db;
    }
    public void deleteById(Long id)
    {
        db.executeUpdate("DELETE FROM contact WHERE id=" + id);
    }
    
    public void update(Contact contact)
    {
        db.executeUpdate("UPDATE contact SET mobile=18235408753, name=Tom,email=1335932576@qq.com WHERE id=1");
    }
    
}