package jm.jenkins.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.xalan.xsltc.compiler.util.Type;

public class JenkinsRequest {

	private String schema = HttpHost.DEFAULT_SCHEME_NAME;
	private String domain;
	private String path = "/";

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getPath() {
		return path;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public JenkinsRequest() {

	}

	public JenkinsRequest(String domain) {
		this.domain = domain;
	}
	

	public JenkinsResponse RequestHandler(HttpRequestBase requestBase, String path) {
		URI uri = null;
		URIBuilder uriBuilder = new URIBuilder();
		try {
			// 创建请求url
			uri = uriBuilder.setHost(domain).setScheme(getSchema()).setPath(path).build();
			System.out.println(uri);
		} catch (URISyntaxException e) {
			new JenkinsClientException();
			e.printStackTrace();
		}
		requestBase.setURI(uri);
		requestBase.setHeader("Cache-Control","no-cache");
		requestBase.setHeader("Server","luyServer");
		requestBase.setHeader("Connection","close");
		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// HttpClient
		CloseableHttpClient client = httpClientBuilder.build();
		CloseableHttpResponse response = null;
		Header[] allHeaders = requestBase.getAllHeaders();
		
		//request 
		for (Header str:allHeaders){
			System.out.println(str);
		}
		System.out.println("--------------");

		try {
			response = client.execute(requestBase);
			Header[] respHeaders = response.getAllHeaders();
			//response
			System.out.println(response.getStatusLine());
			for (Header str:respHeaders){
				System.out.println(str);
			}
			System.out.println("--------------");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JenkinsResponse JResponse = new JenkinsResponseImpl(response);
		return JResponse;
	}

	public JenkinsResponse doGet(String path) {
		HttpGet httpGet = new HttpGet();
		httpGet.setHeader("Content-Type",ContentType.DEFAULT_TEXT.getMimeType());
		return RequestHandler(httpGet, path);
	}

	// org.apache.http.entity.ContentType
	public JenkinsResponse doPostFile(String path, String contentType, String contents) {
		StringEntity entity = new StringEntity(contents, ContentType.create(ContentType.TEXT_HTML.getMimeType(),"UTF-8"));
		entity.setContentType(contentType);
		HttpPost httpPost = new HttpPost();
		httpPost.setHeader("Content-Type",ContentType.TEXT_HTML.getMimeType());
		httpPost.setEntity(entity);
		
		return RequestHandler(httpPost, path);
	}
	

	public JenkinsResponse doPostForm(String path, String formContent) {
		StringEntity entity = new  StringEntity(formContent,ContentType.create(ContentType.APPLICATION_FORM_URLENCODED.getMimeType(),"UTF-8"));
		HttpPost httpPost = new HttpPost();
		httpPost.setEntity(entity);
		httpPost.setHeader("Content-Type",ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
		return RequestHandler(httpPost, path);
	}
	public JenkinsResponse doDelete(String path) {
		HttpDelete httpDelete = new HttpDelete();
		return RequestHandler(httpDelete, path);
	}

	public static void main(String[] args) {
		JenkinsRequest client = new JenkinsRequest("localhost:8081");
		JenkinsResponse resp = client.doGet("");
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getContents());
		// System.out.println(client.DoGet());
	}
}
