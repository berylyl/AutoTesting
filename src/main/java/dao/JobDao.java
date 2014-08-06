package dao;

import java.util.List;

import bean.Job;

public interface JobDao {
	public Job getJob(String JobID);   
    
    public Job getJobAndClass(String JobID);   
       
    public List<Job> getJobAll();   
       
    public void insertJob(Job entity);   
       
    public void deleteJob(Job entity);   
       
    public void updateJob(Job entity);   
}
