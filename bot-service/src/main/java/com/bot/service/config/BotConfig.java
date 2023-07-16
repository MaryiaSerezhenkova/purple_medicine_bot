package com.bot.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import lombok.Data;

@Configuration
@Data

public class BotConfig {
	
    @Value("${bot.name}")
    String botName;
    @Value("${bot.token}")
    String token;
	public String getBotName() {
		return botName;
	}
	public void setBotName(String botName) {
		this.botName = botName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}