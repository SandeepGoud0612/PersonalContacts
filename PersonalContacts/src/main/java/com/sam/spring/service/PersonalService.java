/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.service;

import java.util.Collection;

import com.sam.spring.model.Personal;

/**
 * @author Sandeep June 15, 2016
 */
public interface PersonalService {

	Collection<Personal> getAllPersonal();

	Personal getPersonalById(Long id);

	Personal createPersonal(Personal personal);

	Personal updatePersonal(Personal personal);

	void deletePersonalById(Long id);

	Personal getPersonalByFullName(String fullName);

	Personal getPersonalByFirstName(String firstName);

	Personal getPersonalByLastName(String lastName);

	boolean isPersonalExists(Personal personal);

}
