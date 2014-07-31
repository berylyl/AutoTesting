package service;

import bean.User;

public interface UserService {
    public int countAll();

	public void save(User user);
}