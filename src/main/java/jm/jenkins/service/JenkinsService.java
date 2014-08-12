package jm.jenkins.service;

import jm.bean.User;



public interface JenkinsService {
	
	
	//service
	public void shutdown();
	public void restart();
	public void reload();
	
	//user
    /**
     * Retrieve a user by its name.
     *
     * @param userName The name to look up.
     * @return A {@link User} instance representing the user.
     * @throws NoSuchUserException If no user exists corresponding to the given
     *                             name.
     */
    User retrieveUser(String userName);
	User register(String userName, String password, String fullName, String email);
	public void login();
	
	//job
	public void addJob();
	public void delJob();
	public void updateJob(String...strings);
	
	//exec
	public void build();
	public void getLog();
	
}