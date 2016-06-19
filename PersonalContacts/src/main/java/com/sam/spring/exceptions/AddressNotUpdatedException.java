/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.exceptions;

/**
 * @author Sandeep June 17, 2016
 */
public class AddressNotUpdatedException extends RuntimeException {

	private static final long serialVersionUID = -8983598756925268373L;

	public AddressNotUpdatedException() {
	}

	public AddressNotUpdatedException(String message) {
		super(message);
	}

	public AddressNotUpdatedException(Throwable cause) {
		super(cause);
	}

	public AddressNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddressNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
