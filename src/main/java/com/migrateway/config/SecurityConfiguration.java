package com.migrateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



//@EnableWebSecurity
@EnableWebFluxSecurity
@Configuration
public class SecurityConfiguration{

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        http
        .authorizeExchange()
        .anyExchange().authenticated()
        .and()
        .oauth2ResourceServer().jwt();
        return http.build();
    }
	/**
	 * due to conflicts with spring web (used by eureka client) dependancy
	 * this will require in applications.properties
	 * 
	 * spring.main.web-application-type=reactive
	 * spring.main.allow-bean-definition-overriding=true
	 * 
	 * not preferred as issues while packaging reactive app as WAR (not sure about this though)
	 */
	/**
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
            .oauth2ResourceServer().jwt();
    }
	*/

}