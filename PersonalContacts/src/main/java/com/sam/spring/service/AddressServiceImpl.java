/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.spring.model.Address;
import com.sam.spring.repository.AddressRepository;

/**
 * @author Sandeep June 15, 2016
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public AddressServiceImpl() {
		super();
	}

	@Override
	public Collection<Address> getAllAddress() {
		return addressRepository.findAll();
	}

	@Override
	public Address getAddressById(Long id) {
		return addressRepository.findOne(id);
	}

	@Override
	public Address createAddress(Address address) {
		if (address.getId() != null)
			return null;
		return addressRepository.save(address);
	}

	@Override
	public Address updateAddress(Address address) {
		Address addressFromDB = addressRepository.findOne(address.getId());
		if (addressFromDB == null)
			return null;
		return addressRepository.save(address);
	}

	@Override
	public void deleteAddress(Long id) {
		addressRepository.delete(id);
	}

}
