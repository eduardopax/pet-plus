package com.petplus.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		 http
        .authorizeRequests()
            .antMatchers(
            	 "/",
            	 "/operationOk",
            	 "/operationNOk",
            	 "/survey/**",
            	 "/surveyQuestions",
            	 "/subscription/**",
           		 "/public/**",
           		 "/css/**",
           		 "/fonts/**",
           		 "/img/**",
           		 "/js/**").permitAll()
            .anyRequest().authenticated()
            .and()
            	.csrf()
            		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
			.and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll();
		 //@formatter:on
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(inMemoryUserDetailsManager());
	}

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		final Properties users = new Properties();
		users.put("admin", "admin,ROLE_USER,enabled"); 
		return new InMemoryUserDetailsManager(users);
	}
}
