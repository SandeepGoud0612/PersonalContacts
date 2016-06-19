/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.service;

import java.util.Collection;

import com.sam.spring.model.Address;

/**
 * @author Sandeep June 15, 2016
 */
public interface AddressService {

	Collection<Address> getAllAddress();

	Address getAddressById(Long id);

	Address createAddress(Address address);

	Address updateAddress(Address address);

	void deleteAddress(Long id);

}
