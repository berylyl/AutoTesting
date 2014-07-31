package service;

import bean.User;
import dao.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}
    
}