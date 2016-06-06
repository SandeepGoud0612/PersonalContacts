package com.sam.spring.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sam.spring.model.Greeting;
import com.sam.spring.repository.GreetingRepository;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Autowired
	private GreetingRepository greetingRepository;

	@Override
	public Greeting getGreeting(Long id) {
		Greeting greeting = greetingRepository.findOne(id);
		return greeting;
	}

	@Override
	public Collection<Greeting> getAllGreetings() {
		Collection<Greeting> greetings = greetingRepository.findAll();
		return greetings;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Greeting createGreeting(Greeting greeting) {
		if (greeting.getId() != null)
			return null;
		Greeting greetingCreated = greetingRepository.save(greeting);
		if (true)
			throw new RuntimeException("Roll back transaction...");
		return greetingCreated;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Greeting updateGreeting(Greeting greeting) {
		Greeting greetingExist = greetingRepository.findOne(greeting.getId());
		if (greetingExist == null)
			return null;
		Greeting greetingUpdated = greetingRepository.save(greeting);
		return greetingUpdated;
	}

	@Override
	public void deleteGreeting(Long id) {
		greetingRepository.delete(id);
	}

}
