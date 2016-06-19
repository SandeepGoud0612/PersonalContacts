/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.exceptions;

/**
 * @author Sandeep June 17, 2016
 */
public class PersonalNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2770313301393236432L;

	public PersonalNotFoundException() {
		super();
	}

	public PersonalNotFoundException(Long id) {
		super(id + " not available");
	}

	public PersonalNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PersonalNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersonalNotFoundException(String message) {
		super(message);
	}

	public PersonalNotFoundException(Throwable cause) {
		super(cause);
	}

}
