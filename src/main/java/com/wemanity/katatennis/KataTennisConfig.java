package com.wemanity.katatennis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wemanity.katatennis.model.Player;

/**
 * This config class creates two instances of player class
 *
 */

@Configuration
public class KataTennisConfig {
	
	
	@Bean("Player1")
	public Player playerOneConfig() {
		return new Player();
	}
	
	@Bean("Player2")
	public Player playerSecondConfig() {
		return new Player();
	}
}
