package com.petplus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petplus.entity.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

	Survey findByEmail(String email);

	Survey findByCodeIdentification(String codeIdentification);

}
