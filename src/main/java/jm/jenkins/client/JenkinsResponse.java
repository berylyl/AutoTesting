package jm.jenkins.client;

public interface JenkinsResponse {

	int getStatusCode();

	boolean isOk();

	boolean isNotFound();

	String getStatusLine();

	boolean hasHeader(String name);

	Header getHeader(String name);

	String getContents();

	void consume();

	interface Header {

		String getName();

		String getValue();

	}

}
