package jenkins;
import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;


public class JenkinsServiceImpl implements JenkinsService{
	/*--httpPort=$HTTP_PORT，用来设置jenkins运行时的web端口。
	--httpsPort=$HTTP_PORT，表示使用https协议。
	--httpListenAddress=$HTTP_HOST，用来指定jenkins监听的ip范围，默认为所有的ip都可以访问此jenkins server。
	 */
	
	private String url = "http://localhost:8081/";
	// 200 return
    private static void checkResult(int i) throws IOException {
        if(i/100!=2)
            throw new IOException();
    }
		

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register() {
        try {
			HttpClient client = new HttpClient();

			String hostName = "http://localhost:8081/";
			GetMethod loginLink = new GetMethod(hostName+"login");
			// GetMethod loginLink = new GetMethod(hostName+"loginEntry");
			client.executeMethod(loginLink);
			checkResult(loginLink.getStatusCode());

			String location = hostName+"";
			while(true) {
			    PostMethod loginMethod = new PostMethod(location);
			    //System.out.println(loginMethod);
			    loginMethod.addParameter("j_username", "username"); // TODO: replace with real user name and password
			    loginMethod.addParameter("j_password", "password");
			    loginMethod.addParameter("action", "login");
			    client.executeMethod(loginMethod);
			    if(loginMethod.getStatusCode()/100==3) {
			        // Commons HTTP client refuses to handle redirects for POST
			        // so we have to do it manually.
			        location = loginMethod.getResponseHeader("Location").getValue();
			        continue;
			    }
			    checkResult(loginMethod.getStatusCode());
			    break;
			}

			HttpMethod method = new GetMethod(hostName+"log");
			client.executeMethod(method);
			checkResult(method.getStatusCode());

			System.out.println(method.getResponseBodyAsString());
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addJob() {
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

}
