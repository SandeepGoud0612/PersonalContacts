/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.exceptions;

/**
 * @author Sandeep June 17, 2016
 */
public class PersonalNotDeletedException extends RuntimeException {

	private static final long serialVersionUID = -424566989643618749L;

	public PersonalNotDeletedException() {
		super();
	}

	public PersonalNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PersonalNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersonalNotDeletedException(String message) {
		super(message);
	}

	public PersonalNotDeletedException(Throwable cause) {
		super(cause);
	}

}
