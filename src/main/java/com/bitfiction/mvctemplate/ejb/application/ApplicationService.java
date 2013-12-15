package com.bitfiction.mvctemplate.ejb.application;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.bitfiction.mvctemplate.util.OSType;
import com.bitfiction.mvctemplate.util.OSValidator;

@Singleton
@Startup
public class ApplicationService {

	@Inject
	private Logger log;

	private OSType osType = null;

	private String fileSeparator = null;

	@PostConstruct
	public void init() {
		log.info("Init ApplicationService");

		osType = OSValidator.determineOSType();

		fileSeparator = System.getProperty("file.separator");
		
		log.info("OK: Init ApplicationService");
	}

	public OSType getOsType() {
		return osType;
	}

	public String getFileSeparator() {
		return fileSeparator;
	}

}
