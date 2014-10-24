package com.cdstore.webapp.exception;

/**
 * invalid parameter exception
 * 
 * @author Ronak
 *
 */
public class InvalidParameterException extends Exception {
	private static final long serialVersionUID = -5438340135199065233L;

	public InvalidParameterException(String message) {
		super(message);
	}

	public InvalidParameterException(String message, Throwable throwable) {
		super(message, throwable);
	}
}