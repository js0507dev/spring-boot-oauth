package com.jeongseop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@EnableResourceServer
@EnableAuthorizationServer
@SpringBootApplication
public class MyApplication extends ResourceServerConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
        http.headers()
                .frameOptions().disable();
	    http.authorizeRequests()
                .anyRequest().permitAll()
                .antMatchers("/members/**").authenticated();
	}

	@Bean
    public TokenStore jdbcTokenStore(DataSource dataSource) {
	    return new JdbcTokenStore(dataSource);
    }
}
