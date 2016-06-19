/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.spring.model.Personal;

/**
 * @author Sandeep June 15, 2016
 */
@Repository
public interface PersonalRepository extends JpaRepository<Personal, Long> {

}
