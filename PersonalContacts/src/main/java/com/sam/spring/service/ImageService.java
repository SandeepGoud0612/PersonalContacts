/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.service;

import java.util.Collection;

import com.sam.spring.model.Image;

/**
 * @author Sandeep June 15, 2016
 */
public interface ImageService {

	Collection<Image> getAllImage();

	Image getImageById(Long id);

	Image createImage(Image image);

	Image updateImage(Image image);

	void deleteImage(Long id);

}
