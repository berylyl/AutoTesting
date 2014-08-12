package jm.dao;

import java.util.List;

import jm.bean.User;

public interface UserDao {
	public User getUserByID(Integer UserID);   
	public User getUserByName(String UserName);   
    
    public User getUserAndClass(String UserID);   
       
    public List<User> getUserAll();   
       
    public void createUser(User entity);   
       
    public void deleteUser(User entity);   
       
    public void updateUser(User entity); 
}
