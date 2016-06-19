/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sam.spring.exceptions.AddressNotCreatedException;
import com.sam.spring.exceptions.AddressNotDeletedException;
import com.sam.spring.exceptions.AddressNotFoundException;
import com.sam.spring.exceptions.AddressNotUpdatedException;
import com.sam.spring.model.Address;
import com.sam.spring.service.AddressService;

/**
 * @author Sandeep June 15, 2016
 */
@RestController
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Address>> getAllAddress() {
		Collection<Address> addresses = addressService.getAllAddress();
		if (addresses.isEmpty()) {
			throw new AddressNotFoundException();
		}
		return new ResponseEntity<Collection<Address>>(addresses, HttpStatus.FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> getAddressbyId(@PathVariable("id") Long id) {
		Address address = addressService.getAddressById(id);
		if (address == null) {
			throw new AddressNotFoundException();
		}
		return new ResponseEntity<Address>(address, HttpStatus.FOUND);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> createAddress(@RequestBody Address address) {
		Address addressNew = addressService.createAddress(address);
		if (addressNew.getId() == null) {
			throw new AddressNotCreatedException();
		}
		return new ResponseEntity<Address>(addressNew, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> updateAddress(Long id, Address address) {
		if (addressService.getAddressById(id) == null) {
			throw new AddressNotUpdatedException();
		}
		address.setId(id);
		Address addressNew = addressService.updateAddress(address);
		if (addressNew == null) {
			throw new AddressNotUpdatedException();
		}
		return new ResponseEntity<Address>(addressNew, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Address> deleteAddress(@PathVariable("id") Long id) {
		Address addressDB = addressService.getAddressById(id);
		if (addressDB == null) {
			throw new AddressNotDeletedException();
		}
		addressService.deleteAddress(id);
		return new ResponseEntity<Address>(HttpStatus.NO_CONTENT);
	}

}
