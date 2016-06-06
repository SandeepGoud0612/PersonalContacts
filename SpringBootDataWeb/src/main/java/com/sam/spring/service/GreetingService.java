package com.sam.spring.service;

import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.sam.spring.model.Greeting;

public interface GreetingService {

	Greeting getGreeting(Long id);

	Collection<Greeting> getAllGreetings();

	Greeting createGreeting(Greeting greeting);

	Greeting updateGreeting(Greeting greeting);

	void deleteGreeting(Long id);

}
