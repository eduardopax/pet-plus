package com.petplus.service;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.petplus.component.MailSender;
import com.petplus.component.MyUtil;
import com.petplus.entity.Survey;
import com.petplus.repository.SurveyRepository;

@Service
public class SurveyServiceImpl implements SurveyService {

	@Autowired
	private MailSender mailSender;

	@Autowired
	private SurveyRepository surveyRepository;

	/* (non-Javadoc)
	 * @see com.petplus.service.ISurveyService#subscribeNewSurvey(com.petplus.entity.Survey)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void subscribeNewSurvey(Survey survey) throws Exception {

		Survey surveyData = this.surveyRepository.findByEmail(survey.getEmail());
		if (null != surveyData) {
			throw new Exception("E-mail already registered");
		}

		String codeIdentification = RandomStringUtils.randomAlphanumeric(Survey.RANDOM_CODE_LENGTH);
		survey.setCodeIdentification(codeIdentification);
		this.surveyRepository.save(survey);
		String subject = MyUtil.getMessage("email_subject");
		String link = MyUtil.hostAndPort + "/surveyQuestions?codeIdentification=" + codeIdentification;

		String body = MyUtil.getMessage("email_body", link);
		this.mailSender.send(survey.getEmail(), subject, body);

	}

	/* (non-Javadoc)
	 * @see com.petplus.service.ISurveyService#getAll()
	 */
	@Override
	public List<Survey> getAll() {
		return this.surveyRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.petplus.service.ISurveyService#surveyAnswered(com.petplus.entity.Survey)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void surveyAnswered(Survey survey) throws Exception {

		Survey surveyData = this.surveyRepository.findByCodeIdentification(survey.getCodeIdentification());
		if (null == surveyData) {
			throw new Exception("Invalid code");
		}
		if (null != survey.getSuggestions()) {
			surveyData.setSuggestions(survey.getSuggestions());
		}
		surveyData.setInteristing(survey.getInteresting());
		//set to null to block new attempts
		surveyData.setCodeIdentification("");
		this.surveyRepository.save(surveyData);
	}

}
