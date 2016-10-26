package com.petplus.component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@Profile("!tst")
public class MailComponent implements MailSender {

	private static final Logger logger = LoggerFactory.getLogger(MailComponent.class);

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void send(String to, String subject, String body) {
		MimeMessage mail = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mail, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body);

			javaMailSender.send(mail);

			logger.info("Sendind e-mail to " + to);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}
