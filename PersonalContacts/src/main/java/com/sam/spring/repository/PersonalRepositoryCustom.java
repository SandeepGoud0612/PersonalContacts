/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.repository;

import com.sam.spring.model.Personal;

/**
 * @author Sandeep June 17, 2016
 */
public interface PersonalRepositoryCustom {

	Personal getPersonalByFirstName(String firstName, String lastName);

	Personal getPersonalByLastName(String firstName, String lastName);

	Personal getPersonalByFullName(String fullName);

}
