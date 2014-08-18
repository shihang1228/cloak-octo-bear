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
        String sql = "UPDATE contact SET mobile=?, name=?,email=? WHERE id=?";
        db.executeUpdate(sql,contact.getName(),contact.getEmail(),contact.getMobile(),contact.getId());
    }
    
}