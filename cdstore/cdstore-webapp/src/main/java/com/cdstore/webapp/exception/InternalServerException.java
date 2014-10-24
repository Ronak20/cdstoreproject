package com.cdstore.webapp.exception;

/**
 * server error exception
 * 
 * @author Ronak
 *
 */
public class InternalServerException extends Exception {
	private static final long serialVersionUID = -5438340135199065233L;

	public InternalServerException(String message) {
		super(message);
	}

	public InternalServerException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
