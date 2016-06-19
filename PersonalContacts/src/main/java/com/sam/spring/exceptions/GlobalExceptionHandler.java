/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Sandeep June 17, 2016
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "No contacts found.")
	@ExceptionHandler(value = PersonalNotFoundException.class)
	public String handlePersonalNotFoundException(PersonalNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Contact not created.")
	@ExceptionHandler(value = PersonalNotCreatedException.class)
	public String handlePersonalCreateException(PersonalNotCreatedException e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Contact not updated.")
	@ExceptionHandler(value = PersonalNotUpdatedException.class)
	public String handlePersonalUpdateException(PersonalNotUpdatedException e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Contact not deleted.")
	@ExceptionHandler(value = PersonalNotDeletedException.class)
	public String handlePersonalDeleteException(PersonalNotDeletedException e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "No address found.")
	@ExceptionHandler(value = AddressNotFoundException.class)
	public String handleAddressNotFoundException(AddressNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Address not created.")
	@ExceptionHandler(value = AddressNotCreatedException.class)
	public String handleAddressCreateException(AddressNotCreatedException e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Address not updated.")
	@ExceptionHandler(value = AddressNotUpdatedException.class)
	public String handleAddressUpdateException(AddressNotUpdatedException e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Address not deleted.")
	@ExceptionHandler(value = AddressNotDeletedException.class)
	public String handleAddressDeleteException(AddressNotDeletedException e) {
		return e.getMessage();
	}

}
