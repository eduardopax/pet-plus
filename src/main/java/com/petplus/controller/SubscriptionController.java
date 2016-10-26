package com.petplus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petplus.entity.Survey;
import com.petplus.service.SurveyService;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

	private static final Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

	@Autowired
	private SurveyService surveyService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Object> subscribe(@RequestBody Survey survey) {

		try {
			logger.info("Subscription received: {} ", survey);
			this.surveyService.subscribeNewSurvey(survey);
		} catch (Exception e) {
			logger.error("Error on processing subscription: {}", e.getMessage());
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(survey, HttpStatus.OK);
	}

}
