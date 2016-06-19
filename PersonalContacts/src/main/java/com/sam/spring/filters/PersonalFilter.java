/**
 * This document is a part of the source code and related artifacts for Contacts Application.
 */
package com.sam.spring.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

/**
 * @author Sandeep June 15, 2016
 */
@Component
public class PersonalFilter implements Filter {

	public PersonalFilter() {
	}

	@Override
	public void destroy() {
		System.out.println("In Filter Destroy");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("In Filter doFilter");
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("In Filter init");

	}

}
