/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.exceptions;

/**
 * @author Sandeep June 17, 2016
 */
public class AddressNotDeletedException extends RuntimeException {

	private static final long serialVersionUID = -1994575122438623893L;

	public AddressNotDeletedException() {
	}

	public AddressNotDeletedException(String message) {
		super(message);
	}

	public AddressNotDeletedException(Throwable cause) {
		super(cause);
	}

	public AddressNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddressNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
