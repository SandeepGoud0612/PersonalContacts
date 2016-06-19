/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.exceptions;

/**
 * @author Sandeep June 17, 2016
 */
public class AddressNotCreatedException extends RuntimeException {

	private static final long serialVersionUID = -6819146392995603261L;

	public AddressNotCreatedException() {
	}

	public AddressNotCreatedException(String message) {
		super(message);
	}

	public AddressNotCreatedException(Throwable cause) {
		super(cause);
	}

	public AddressNotCreatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddressNotCreatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
