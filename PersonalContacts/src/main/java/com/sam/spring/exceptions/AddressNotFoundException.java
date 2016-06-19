/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.exceptions;

/**
 * @author Sandeep June 17, 2016
 */
public class AddressNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7785025689866389107L;

	public AddressNotFoundException() {
	}

	public AddressNotFoundException(String message) {
		super(message);
	}

	public AddressNotFoundException(Throwable cause) {
		super(cause);
	}

	public AddressNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddressNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
