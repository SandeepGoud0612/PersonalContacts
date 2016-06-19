/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * @author Sandeep June 15, 2016
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -4739028717716372325L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.getId() != null ? this.getId().hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;

		BaseEntity other = (BaseEntity) object;
		if (this.getId() != other.getId() && (this.getId() == null || !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

}
