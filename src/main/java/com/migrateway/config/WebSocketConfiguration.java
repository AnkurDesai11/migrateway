package com.migrateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer{
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		
		//Prefix at which all messages from server will be broadcasted
		registry.enableSimpleBroker("/migrations");
		
		//prefix to where the clients will send messages to the server
		//will have additional routes according to endpoints/methods in the controller
		registry.setApplicationDestinationPrefixes("/");
		
	}
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		
		//url at which clients will establish connection
		registry.addEndpoint("/migrateway").withSockJS();
		
	}
	
}
