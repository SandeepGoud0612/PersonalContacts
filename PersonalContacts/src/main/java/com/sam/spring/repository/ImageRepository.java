/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.spring.model.Image;

/**
 * @author Sandeep June 15, 2016
 */
public interface ImageRepository extends JpaRepository<Image, Long> {

}
