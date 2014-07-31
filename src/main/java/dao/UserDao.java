package dao;

import java.util.List;

import bean.User;

public interface UserDao {
	public User getUser(String UserID);   
    
    public User getUserAndClass(String UserID);   
       
    public List<User> getUserAll();   
       
    public void insertUser(User entity);   
       
    public void deleteUser(User entity);   
       
    public void updateUser(User entity);   
}
