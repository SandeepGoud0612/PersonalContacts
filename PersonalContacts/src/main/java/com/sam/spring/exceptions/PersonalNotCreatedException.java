/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.exceptions;

/**
 * @author Sandeep June 17, 2016
 */
public class PersonalNotCreatedException  extends RuntimeException{

	private static final long serialVersionUID = 292254967508316915L;

	public PersonalNotCreatedException() {
		super();
	}

	public PersonalNotCreatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PersonalNotCreatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersonalNotCreatedException(String message) {
		super(message);
	}

	public PersonalNotCreatedException(Throwable cause) {
		super(cause);
	}
	
}
