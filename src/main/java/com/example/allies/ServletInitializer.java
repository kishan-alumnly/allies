package com.example.allies;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * This is a system variable which define the environment value.
	 */
	public static final String SPRING_PROFILES_ACTIVE = "spring.profiles.active";

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AlliesApplication.class);
	}

}
