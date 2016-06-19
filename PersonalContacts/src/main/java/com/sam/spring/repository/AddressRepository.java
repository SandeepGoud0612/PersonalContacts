/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.spring.model.Address;

/**
 * @author Sandeep June 15, 2016
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

}
