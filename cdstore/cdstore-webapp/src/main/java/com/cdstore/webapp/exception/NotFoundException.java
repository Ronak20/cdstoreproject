package com.cdstore.webapp.exception;

/**
 * not found exception
 * 
 * @author Ronak
 *
 */
public class NotFoundException extends Exception {
	private static final long serialVersionUID = -5438340135199065233L;

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
