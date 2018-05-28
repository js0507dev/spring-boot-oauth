package com.jeongseop.config;

import com.jeongseop.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

@Configuration
public class OAuthConfig extends AuthorizationServerConfigurerAdapter {
    private static final String RESOURCE_ID = "restservice";

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        @Autowired
        private TokenStore tokenStore;

        @Bean
        public PasswordEncoder userPasswordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthenticationSuccessHandler successHandler() {
            return new LoginSuccessHandler();
        }

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources
                    .tokenStore(tokenStore)
                    .resourceId(RESOURCE_ID);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/member/**").hasRole("USER")
                    .antMatchers("/**").permitAll();
        }
    }

    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
        @Autowired
        private DataSource dataSource;

        @Bean
        public TokenStore jdbcTokenStore() {
            return new JdbcTokenStore(dataSource);
        }

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private UserDetailService userDetailService;

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .tokenStore(jdbcTokenStore())
                    .authenticationManager(authenticationManager)
                    .userDetailsService(userDetailService);
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients
                    .jdbc(dataSource)
                    .withClient("cli")
                    .autoApprove(true)
                    .authorizedGrantTypes("password", "implicit")
                    .scopes("member.info.public", "member.info.email");
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            oauthServer.allowFormAuthenticationForClients();
        }
    }
}
