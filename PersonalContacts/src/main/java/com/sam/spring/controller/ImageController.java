/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.spring.service.ImageService;

/**
 * @author Sandeep June 15, 2016
 */
@RestController
@RequestMapping("/images")
public class ImageController {

	@Autowired
	private ImageService imageService;

}
