package com.petplus.component;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MyUtil {
	
	@Autowired
	public MyUtil(MessageSource messageSource) {
		MyUtil.messageSource = messageSource;
	}
	
    public static String hostAndPort;

    @Value("${hostAndPort}")
    public void setHostAndPort(String hostAndPort) {
    	MyUtil.hostAndPort = hostAndPort;
    }
    
	
	private static MessageSource messageSource;

	public static String getMessage(String messageKey, Object... args) {
		return messageSource.getMessage(messageKey, args, Locale.getDefault());
	}



}
