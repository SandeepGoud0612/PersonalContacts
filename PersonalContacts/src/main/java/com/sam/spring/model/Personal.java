/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sam.spring.enums.Gender;

/**
 * @author Sandeep June 15, 2016
 */
@Entity
@Table(name = "PERSONAL")
@XmlRootElement
public class Personal extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 8118400907940236502L;

	@NotNull(message = "First name is mandatory.")
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@NotNull(message = "Last name is mandatory.")
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Transient
	private String fullName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@NotNull(message = "Phone number is mandatory")
	@Column(name = "PHONE_NUMBER", nullable = false, length = 15)
	private Long phoneNumber;

	@Column(name = "LAND_LINE_NUMBER", length = 15)
	private Long landLineNumber;

	@Email
	@NotNull(message = "EmailId is mandatory")
	@Column(name = "EMAIL_ID", nullable = false)
	private String emailId;

	@Column(name = "DATE_OF_BIRTH")
	@Temporal(TemporalType.DATE)
	@Past
	private Date dateOfBirth;

	@NotNull(message = "Gender is mandatory.")
	@Column(name = "GENDER", nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "IMAGE_ID")
	@JsonIgnore
	private Image image;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "personal")
	private Collection<Address> addresses = new ArrayList<>();

	public Personal() {
		super();
	}

	public Personal(String firstName, String lastName, String middleName, Long phoneNumber, Long landLineNumber,
			String emailId, Date dateOfBirth, Gender gender, Image image, Collection<Address> addresses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = firstName + " " + lastName;
		this.middleName = middleName;
		this.phoneNumber = phoneNumber;
		this.landLineNumber = landLineNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.image = image;
		this.addresses = addresses;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getLandLineNumber() {
		return landLineNumber;
	}

	public void setLandLineNumber(Long landLineNumber) {
		this.landLineNumber = landLineNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Collection<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<Address> addresses) {
		this.addresses = addresses;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
