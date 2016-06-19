/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sandeep June 15, 2016
 */
@Entity
@Table(name = "IMAGE")
@XmlRootElement
public class Image extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 2700273334338775944L;

	@Column(name = "COMMENTS")
	private String comments;

	@Lob
	@Column(name = "IMAGE")
	private Byte[] image;

	public Image() {
		super();
	}

	public Image(String comments, Byte[] image) {
		super();
		this.comments = comments;
		this.image = image;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}

}
