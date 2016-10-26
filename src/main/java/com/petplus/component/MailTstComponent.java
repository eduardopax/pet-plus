package com.petplus.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("tst")
public class MailTstComponent implements MailSender {

	private static final Logger logger = LoggerFactory.getLogger(MailTstComponent.class);

	@Override
	public void send(String to, String subject, String body) {
		logger.info("Sendind e-mail to " + to + " body: + " + body);
	}
}
