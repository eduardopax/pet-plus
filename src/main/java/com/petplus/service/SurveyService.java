package com.petplus.service;

import java.util.List;

import com.petplus.entity.Survey;

public interface SurveyService {

	/**
	 * Create a new survey using the e-mail and send the feedback to Custumer.
	 * 
	 * @param survey
	 *            survey
	 * @throws Exception 
	 */
	void subscribeNewSurvey(Survey survey) throws Exception;

	List<Survey> getAll();

	void surveyAnswered(Survey survey) throws Exception;

}