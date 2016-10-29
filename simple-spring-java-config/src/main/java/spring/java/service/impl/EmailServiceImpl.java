package spring.java.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spring.java.service.EmailService;

public class EmailServiceImpl implements EmailService{

	private static final Logger LOGGER=LoggerFactory.getLogger(EmailServiceImpl.class);
	
	@Override
	public void sendEmail() {
		LOGGER.debug("EmailServiceImpl:sendEmail() is called");
		
	}

}
