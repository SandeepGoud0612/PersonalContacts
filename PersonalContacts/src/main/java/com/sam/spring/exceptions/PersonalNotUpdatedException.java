/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.exceptions;

/**
 * @author Sandeep June 17, 2016
 */
public class PersonalNotUpdatedException  extends RuntimeException{

	private static final long serialVersionUID = -6886702312476413701L;

	public PersonalNotUpdatedException() {
		super();
	}

	public PersonalNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PersonalNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersonalNotUpdatedException(String message) {
		super(message);
	}

	public PersonalNotUpdatedException(Throwable cause) {
		super(cause);
	}

}
