package com.petplus;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.petplus.controller.SubscriptionController;
import com.petplus.controller.SurveyController;
import com.petplus.entity.Survey;
import com.petplus.repository.SurveyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PetPlusApplicationTests {

	@Autowired
	SubscriptionController subscriptionController;

	@Autowired
	SurveyController surveyController;

	@Autowired
	SurveyRepository surveyRepository;

	@Test
	public void testSubscription() {
		String email = "teste@teste.com";
		Survey survey = new Survey();
		survey.setEmail(email);
		this.subscriptionController.subscribe(survey);

		Survey surveyDataBase = this.surveyRepository.findByEmail(email);

		Assert.assertEquals(email, surveyDataBase.getEmail());
	}

	@Test
	public void testSurvey() {
		String email = "teste2@teste.com";
		Survey survey = new Survey();
		survey.setEmail(email);
		this.subscriptionController.subscribe(survey);

		Survey surveyDataBase = this.surveyRepository.findByEmail(email);

		Integer interesting = 3;
		survey.setInteristing(interesting);
		String sugestions = "Sugestions";
		survey.setSuggestions(sugestions);

		this.surveyController.surveyAnswered(survey);
		surveyDataBase = this.surveyRepository.findByEmail(email);

		Assert.assertEquals(email, surveyDataBase.getEmail());
		Assert.assertEquals(sugestions, surveyDataBase.getSuggestions());
		Assert.assertEquals(interesting, interesting);
	}

	@Test
	/**
	 * It is a test of all phases of project
	 */
	public void testList() {
		// 1 register
		String email = "teste3@teste.com";
		Survey survey = new Survey();
		survey.setEmail(email);
		this.subscriptionController.subscribe(survey);

		Survey surveyDataBase = this.surveyRepository.findByEmail(email);

		Integer interesting = 3;
		survey.setInteristing(interesting);
		String sugestions = "Sugestions";
		survey.setSuggestions(sugestions);

		this.surveyController.surveyAnswered(survey);
		surveyDataBase = this.surveyRepository.findByEmail(email);

		Assert.assertEquals(email, surveyDataBase.getEmail());
		Assert.assertEquals(sugestions, surveyDataBase.getSuggestions());
		Assert.assertEquals(interesting, surveyDataBase.getInteresting());

		// 2 register
		String email2 = "teste22@teste.com";
		Survey survey2 = new Survey();
		survey2.setEmail(email2);
		this.subscriptionController.subscribe(survey2);

		Survey surveyDataBase2 = this.surveyRepository.findByEmail(email2);

		Integer interesting2 = 5;
		survey2.setInteristing(interesting2);
		String sugestions2 = "Sugestions2";
		survey2.setSuggestions(sugestions2);

		this.surveyController.surveyAnswered(survey2);
		surveyDataBase2 = this.surveyRepository.findByEmail(email2);

		Assert.assertEquals(email2, surveyDataBase2.getEmail());
		Assert.assertEquals(sugestions2, surveyDataBase2.getSuggestions());
		Assert.assertEquals(interesting2, surveyDataBase2.getInteresting());

		List<Survey> list = this.surveyRepository.findAll();
		Assert.assertEquals(2, list.size());
	}

	@Test
	public void testSameSubscription() {
		// 1 register
		String email = "teste3@teste.com";
		Survey survey = new Survey();
		survey.setEmail(email);
		ResponseEntity response = this.subscriptionController.subscribe(survey);
		Assert.assertEquals(200, response.getStatusCodeValue());
		// 2 register
		response = this.subscriptionController.subscribe(survey);
		Assert.assertEquals(500, response.getStatusCodeValue());
	}

	@Test
	public void testInvalidCode() {
		Survey survey = new Survey();
		survey.setCodeIdentification("-1HELLO-1");
		ResponseEntity response = this.surveyController.surveyAnswered(survey);
		Assert.assertEquals(500, response.getStatusCodeValue());
	}

}
