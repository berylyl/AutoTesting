package jenkins;

public interface JenkinsService {
	
	
	//service
	public void shutdown();
	public void restart();
	public void reload();
	
	//user
	public void register();
	public void login();
	
	//job
	public void addJob();
	public void delJob();
	public void updateJob(String...strings);
	
	//exec
	public void build();
	public void getLog();
	
}