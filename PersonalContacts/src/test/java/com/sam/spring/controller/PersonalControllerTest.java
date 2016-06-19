package com.sam.spring.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sam.spring.PersonalContactsApplication;
import com.sam.spring.enums.Country;
import com.sam.spring.enums.Gender;
import com.sam.spring.model.Address;
import com.sam.spring.model.Personal;
import com.sam.spring.service.PersonalService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PersonalContactsApplication.class)
@WebAppConfiguration
public class PersonalControllerTest {

	@Autowired
	private PersonalService personalService;

	@Test
	public void testCreatePersonal() {

		Address address1 = new Address();
		address1.setAddressLine1("Plot No 119");
		address1.setAddressLine2("JPN Nagar, Miypur");
		address1.setCity("Hyderabad");
		address1.setState("Telangana");
		address1.setCountry(Country.INDIA);
		address1.setPincode(500049L);

		Address address2 = new Address();
		address2.setAddressLine1("Plot No 118");
		address2.setAddressLine2("JPN Nagar, Miypur");
		address2.setCity("Hyderabad");
		address2.setState("Telangana");
		address2.setCountry(Country.INDIA);
		address2.setPincode(500049L);

		Personal personal = new Personal();
		personal.setFirstName("Sam");
		personal.setLastName("Goud");
		personal.setMiddleName("Sammy");
		personal.setPhoneNumber(9092835879L);
		personal.setLandLineNumber(0404065572L);
		personal.setEmailId("sam119@gmail.com");
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(0);
		cal.set(2012, 05, 01, 03, 9, 9);
		personal.setDateOfBirth(cal.getTime());
		personal.setGender(Gender.MALE);
		personal.setImage(null);
		
		address1.setPersonal(personal);
		address2.setPersonal(personal);
		
		Collection<Address> addresses = new ArrayList<>();
		addresses.add(address1);
		addresses.add(address2);

		personal.setAddresses(addresses);

		personalService.createPersonal(personal);

	}

}
