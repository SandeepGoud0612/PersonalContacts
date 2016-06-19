/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.sam.spring.model.Personal;

/**
 * @author Sandeep June 17, 2016
 */
@Repository
public class PersonalRepositoryCustomImpl implements PersonalRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Personal getPersonalByFirstName(String firstName, String lastName) {
		return getPersonalByName(firstName, null);
	}

	@Override
	public Personal getPersonalByLastName(String firstName, String lastName) {
		return getPersonalByName(null, lastName);
	}

	@Override
	public Personal getPersonalByFullName(String fullName) {
		String[] strings = fullName.split("\\s+");
		if (strings.length != 2)
			throw new IllegalArgumentException("Bad name: " + fullName);
		return getPersonalByName(strings[0], strings[1]);
	}

	private Personal getPersonalByName(String firstName, String lastName) {
		boolean hasFirst = StringUtils.isNotBlank(firstName);
		boolean hasLast = StringUtils.isNotBlank(lastName);

		if (!hasFirst && !hasLast) {
			throw new IllegalArgumentException("Bad name.");
		}

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Personal> criteriaQuery = criteriaBuilder.createQuery(Personal.class);
		Root<Personal> root = criteriaQuery.from(Personal.class);

		if (hasFirst && hasLast) {
			criteriaQuery.where(criteriaBuilder.and(likeExpression(criteriaBuilder, root, "firstName", firstName),
					likeExpression(criteriaBuilder, root, "lastName", lastName)));
		} else if (hasFirst) {
			criteriaQuery.where(likeExpression(criteriaBuilder, root, "firstName", firstName));
		} else {
			criteriaQuery.where(likeExpression(criteriaBuilder, root, "lastName", lastName));
		}

		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}

	private Predicate likeExpression(final CriteriaBuilder criteriaBuilder, final Root<Personal> root,
			final String path, String parameter) {
		return criteriaBuilder.like(root.<String> get(path), "*" + parameter.trim() + "*");
	}

}
