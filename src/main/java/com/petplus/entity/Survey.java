package com.petplus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Survey {
	
	public static final int RANDOM_CODE_LENGTH = 16;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String email;

	@Column(length = RANDOM_CODE_LENGTH)
	private String codeIdentification;

	private Integer interesting;

	private String suggestions;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodeIdentification() {
		return codeIdentification;
	}

	public void setCodeIdentification(String codeIdentification) {
		this.codeIdentification = codeIdentification;
	}

	public Integer getInteresting() {
		return interesting;
	}

	public void setInteristing(Integer interesting) {
		this.interesting = interesting;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", email=" + email + ", codeIdentification=" + codeIdentification + ", intereisting="
				+ interesting + ", suggestions=" + suggestions + "]";
	}

}
