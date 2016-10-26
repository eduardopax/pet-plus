package com.petplus.component;

public interface MailSender {

	public abstract void send(String to, String subject, String body);

}