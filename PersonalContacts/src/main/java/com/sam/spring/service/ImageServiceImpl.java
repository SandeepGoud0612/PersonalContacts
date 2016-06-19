/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sam.spring.model.Image;
import com.sam.spring.repository.ImageRepository;

/**
 * @author Sandeep June 15, 2016
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;

	public ImageServiceImpl() {
		super();
	}

	@Override
	public Collection<Image> getAllImage() {
		return imageRepository.findAll();
	}

	@Override
	public Image getImageById(Long id) {
		return imageRepository.findOne(id);
	}

	@Override
	public Image createImage(Image image) {
		if (image.getId() != null)
			return null;
		return imageRepository.save(image);
	}

	@Override
	public Image updateImage(Image image) {
		Image imageFromDB = imageRepository.findOne(image.getId());
		if (imageFromDB == null)
			return null;
		return imageRepository.save(image);
	}

	@Override
	public void deleteImage(Long id) {
		imageRepository.delete(id);
	}

}
