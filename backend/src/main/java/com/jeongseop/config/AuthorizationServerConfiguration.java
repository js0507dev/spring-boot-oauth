package com.jeongseop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/h2-console/**");
	}
}
