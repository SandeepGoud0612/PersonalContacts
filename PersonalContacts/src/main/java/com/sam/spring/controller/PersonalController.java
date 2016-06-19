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

import com.sam.spring.exceptions.PersonalNotCreatedException;
import com.sam.spring.exceptions.PersonalNotDeletedException;
import com.sam.spring.exceptions.PersonalNotFoundException;
import com.sam.spring.exceptions.PersonalNotUpdatedException;
import com.sam.spring.model.Personal;
import com.sam.spring.service.PersonalService;

/**
 * @author Sandeep June 15, 2016
 */
@RestController
@RequestMapping("/personals")
public class PersonalController {

	@Autowired
	private PersonalService personalService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Personal>> getAllPersonal() {
		Collection<Personal> personals = personalService.getAllPersonal();
		if (personals.isEmpty()) {
			throw new PersonalNotFoundException();
		}
		return new ResponseEntity<Collection<Personal>>(personals, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Personal> getPersonalById(@PathVariable("id") Long id) {
		Personal personal = personalService.getPersonalById(id);
		if (personal == null) {
			throw new PersonalNotFoundException(id);
		}
		return new ResponseEntity<Personal>(personal, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Personal> createPersonal(@RequestBody Personal personal) {
		/*if (personalService.isPersonalExists(personal)) {
			throw new PersonalNotCreatedException();
		}*/
		Personal personalNew = personalService.createPersonal(personal);
		if (personalNew.getId() == null) {
			throw new PersonalNotCreatedException();
		}
		return new ResponseEntity<Personal>(personalNew, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Personal> updatePersonal(@PathVariable("id") Long id, @RequestBody Personal personal) {
		if (personalService.getPersonalById(id) == null) {
			throw new PersonalNotUpdatedException();
		}
		personal.setId(id);
		Personal personalNew = personalService.updatePersonal(personal);
		return new ResponseEntity<Personal>(personalNew, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Personal> deletePersonal(@PathVariable("id") Long id) {
		Personal personalDB = personalService.getPersonalById(id);
		if (personalDB == null) {
			throw new PersonalNotDeletedException();
		}
		personalService.deletePersonalById(id);
		return new ResponseEntity<Personal>(HttpStatus.NO_CONTENT);
	}

}
