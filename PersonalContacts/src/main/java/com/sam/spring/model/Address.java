/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sam.spring.enums.Country;

/**
 * @author Sandeep June 15, 2016
 */
@Entity
@Table(name = "ADDRESS")
@XmlRootElement
public class Address extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 5212277203707453564L;

	@NotNull(message = "Address line1 is mandatory.")
	@Column(name = "ADDRESS_LINE1", nullable = false)
	private String addressLine1;

	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;

	@NotNull(message = "City is mandatory.")
	@Column(name = "CITY", nullable = false)
	private String city;

	@NotNull(message = "State is mandatory.")
	@Column(name = "STATE", nullable = false)
	private String state;

	@NotNull(message = "Country is mandatory.")
	@Column(name = "Country", nullable = false)
	@Enumerated(EnumType.STRING)
	private Country country;

	@NotNull(message = "Pincode is mandatory.")
	@Column(name = "PINCODE", nullable = false)
	private Long pincode;

	@ManyToOne
	@JoinColumn(name = "PERSONAL_ID")
	@JsonIgnore
	private Personal personal;

	public Address() {
		super();
	}

	public Address(String addressLine1, String addressLine2, String city, String state, Country country, Long pincode,
			Personal personal) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.personal = personal;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

}
