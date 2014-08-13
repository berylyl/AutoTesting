package jm.util;

public class JMException extends RuntimeException {


	public JMException(final String message) {
		this(message, null);
	}

	public JMException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
