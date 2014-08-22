package jm.jenkins.service;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.management.JMException;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.dom4j.Document;

import jm.bean.User;
import jm.jenkins.client.JenkinsRequest;
import jm.jenkins.client.JenkinsResponse;
import jm.util.XmlUtils;

public class JenkinsServiceImpl implements JenkinsService{
	/*--httpPort=$HTTP_PORT，用来设置jenkins运行时的web端口。
	--httpsPort=$HTTP_PORT，表示使用https协议。
	--httpListenAddress=$HTTP_HOST，用来指定jenkins监听的ip范围，默认为所有的ip都可以访问此jenkins server。
	 */
	
	
	private final String domain = "localhost:8081";
	private final JenkinsRequest request = new JenkinsRequest(domain);
	
	
	public JenkinsServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	// 200 return
    private static void checkResult(int i) throws IOException {
        if(i/100!=2)
            throw new IOException();
    }
	
    

	@Override
	public void shutdownVm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restartVm() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login(String userName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addJob(String jobName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutdownVM() {
		// TODO Auto-generated method stub
		
	}
    

	@Override
	public void delJob() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateJob(String... strings) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void build() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getLog() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public User retrieveUser(String userName) {
		User user = null;
		try {
			URL  url = new URL("http","localhost",8081,String.format("/securityRealm/user/%s/api/xml",userName));
			Document doc = XmlUtils.xmlSource(url);
			String uname = XmlUtils.getSingleElementValue(XmlUtils.getRootElement(doc),"id");
			String email = XmlUtils.getSingleElementValue(XmlUtils.getRootElement(doc),"email");
			user = new User(uname, email);
		} catch (MalformedURLException e) {
			new JMException("not got the user correcetly......"+e.getMessage());
		}
		return user;
	}

	@Override
	public User register(String userName, String password,String fullName,String email) {
		String formContent=String.format("username=%s&password1=%s&password2=%s&fullname=%s&email=%s",userName,password,password,fullName,email);
		System.out.println(formContent);
		JenkinsResponse response = request.doPostForm("/securityRealm/createAccount", formContent);
		System.out.println(response.getStatusLine());
		System.out.println(response.getContents());
		System.out.println(response.getContents().indexOf("Sign up"));
		if (response.getContents().indexOf("Sign up")==-1){
			System.out.println("user right");
		}else{
			
			System.out.println("fail to regist");
		}
		return  new User(userName, email);
	}
	
	public static void main(String[] args) {
		JenkinsServiceImpl serviceImpl = new JenkinsServiceImpl();
		//serviceImpl.register("to2m", "na22me2e13", "name12teest2w", "l2is2d2ea21@jumei.com");
		//User retrieveUser = serviceImpl.retrieveUser("tomdddd");
	}

	@Override
	public void addJob() {
		// TODO Auto-generated method stub
		
	}



}
