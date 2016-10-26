package com.petplus.controller;

import java.util.List;

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
@RequestMapping("/survey")
public class SurveyController {
	
	private static final Logger logger = LoggerFactory.getLogger(SurveyController.class);

	@Autowired
	private SurveyService surveyService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Object> surveyAnswered(@RequestBody Survey survey) {

		try {
			logger.info("Survey received: {}", survey);
			this.surveyService.surveyAnswered(survey);
		} catch (Exception e) {
			logger.error("Error on processing survey: {}", e.getMessage());
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(survey, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Survey>> getAll() {

		List<Survey> list = this.surveyService.getAll();

		return new ResponseEntity<List<Survey>>(list, HttpStatus.OK);
	}
}
