/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.spring.model.Personal;
import com.sam.spring.repository.PersonalRepository;
import com.sam.spring.repository.PersonalRepositoryCustom;

/**
 * @author Sandeep June 15, 2016
 */
@Service
@Transactional
public class PersonalServiceImpl implements PersonalService {

	@Autowired
	private PersonalRepository personalRepository;

	@Autowired
	private PersonalRepositoryCustom personalRepositoryCustom;

	public PersonalServiceImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sam.spring.service.PersonalService#getAllPersonal()
	 */
	@Override
	public Collection<Personal> getAllPersonal() {
		return personalRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sam.spring.service.PersonalService#getPersonalById(java.lang.Long)
	 */
	@Override
	public Personal getPersonalById(Long id) {
		return personalRepository.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sam.spring.service.PersonalService#createPersonal(com.sam.spring.
	 * model.Personal)
	 */
	@Override
	public Personal createPersonal(Personal personal) {
		if (personal.getId() != null)
			return null;
		Personal personalNew =  personalRepository.save(personal);
		return personalNew;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sam.spring.service.PersonalService#updatePersonal(com.sam.spring.
	 * model.Personal)
	 */
	@Override
	public Personal updatePersonal(Personal personal) {
		Personal personalFromDB = personalRepository.findOne(personal.getId());
		if (personalFromDB == null)
			return null;
		return personalRepository.save(personal);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sam.spring.service.PersonalService#deletePersonal(java.lang.Long)
	 */
	@Override
	public void deletePersonalById(Long id) {
		personalRepository.delete(id);
	}

	@Override
	public Personal getPersonalByFullName(String fullName) {
		return personalRepositoryCustom.getPersonalByFullName(fullName);
	}

	@Override
	public boolean isPersonalExists(Personal personal) {
		return personalRepositoryCustom.getPersonalByFullName(personal.getFullName()) != null;
	}

	@Override
	public Personal getPersonalByFirstName(String firstName) {
		return personalRepositoryCustom.getPersonalByFirstName(firstName, null);
	}

	@Override
	public Personal getPersonalByLastName(String lastName) {
		return personalRepositoryCustom.getPersonalByLastName(null, lastName);
	}

}
