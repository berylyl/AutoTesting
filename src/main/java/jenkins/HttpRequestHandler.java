package jenkins;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpRequestHandler{

	
	public static String hostName="";
	public static HttpClient client ;
	

	private String uri = "localhost";
	private String param[] = null;
	private ArrayList<String> header = null; 

	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}

	
	public String[] getParam() {
		return param;
	}
	public void setParam(String[] param) {
		this.param = param;
	}
	public ArrayList<String> getHeader() {
		return header;
	}
	public void setHeader(ArrayList<String> header) {
		this.header = header;
	}

	
	
	public HttpRequestHandler() {
		client = new HttpClient();
		// TODO Auto-generated constructor stub
	}
	public HttpRequestHandler(String uri,ArrayList<String> header,String...param) {
		this.uri = uri;
		this.param = param;
		this.header = header;
		client = new HttpClient();
		
	}
	
    private static void checkResult(int i) throws IOException {
        if(i/100!=2)
            throw new IOException();
    }
	
	public static void doGet(String url){
		HttpMethod method = new GetMethod(hostName+"log");
		
		try {
			client.executeMethod(method);
			checkResult(method.getStatusCode());
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void doPost(String url){
		
	}
	
	public static void main(String[] args) {
	}

}
