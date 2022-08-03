package com.migrateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import javax.servlet.Filter;
//org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Scope;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.server.authorization.AuthorizationWebFilter;
//import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;


@EnableWebSecurity
//@EnableWebFluxSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	/*
	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        http
        .authorizeExchange()
        .anyExchange().authenticated()
        .and()
        .oauth2ResourceServer().jwt();
        return http.build();
    }
    */
	/**
	 * due to conflicts with spring web (used by eureka client) dependancy
	 * this will require in applications.properties
	 * 
	 * spring.main.web-application-type=reactive
	 * spring.main.allow-bean-definition-overriding=true
	 * 
	 * not preferred as issues while packaging reactive app as WAR (not sure about this though)
	 */
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
				.disable()
			.cors()
				.disable()
			.authorizeRequests()
            	/*.antMatchers(HttpMethod.GET, "/source1/*","/source1/**", "/source1/***")
              		.permitAll()
              	.Matchers(HttpMethod.POST, "/source1/*","/source1/**", "/source1/***")
              		.hasRole("ROLE_dbSuperAdmin")
              	*/
              	.anyRequest()
              		.authenticated()
             .and()
              	.oauth2ResourceServer()
              		.jwt();
            /*
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
            .authorizeRequests(authorizeRequests -> 
            	authorizeRequests
            	
            	.anyRequest().authenticated()
            )
            .oauth2ResourceServer().jwt();
            */
		
    }
	
	//recommended way, no need to use WebSecurityConfigurerAdapter with this
	/*
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(authorize -> authorize
				.anyRequest().authenticated()
			)
			.oauth2ResourceServer().jwt();
		return http.build();
	}
	*/
}