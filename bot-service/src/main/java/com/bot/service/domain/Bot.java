package com.bot.service.domain;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.bot.service.bot.Bot;
import com.bot.service.config.BotConfig;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor

public class Bot extends TelegramLongPollingBot {

	private final BotConfig botConfig = new BotConfig();
	private static final Logger log = Logger.getLogger(Bot.class);

    final int RECONNECT_PAUSE =10000;

    
	
	public String getBotUsername() {
		return botConfig.getBotName();
	}
	public String getBotToken() {
		return botConfig.getToken();
	}
	public void onUpdateReceived(Update update) {
		        log.debug("Receive new Update. updateID: " + update.getUpdateId());

		        Long chatId = update.getMessage().getChatId();
		        String inputText = update.getMessage().getText();

		        if (inputText.startsWith("/start")) {
		            SendMessage message = new SendMessage();
		            message.setChatId(chatId);
		            message.setText("Hello. This is start message");
		            try {
		                execute(message);
		            } catch (TelegramApiException e) {
		                e.printStackTrace();
		            }
		        }
	}
	public void botConnect() {
//        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
//        try {
//            telegramBotsApi.registerBot(this);
//            log.info("TelegramAPI started. Look for messages");
//        } catch (TelegramApiRequestException e) {
//            log.error("Cant Connect. Pause " + RECONNECT_PAUSE / 1000 + "sec and try again. Error: " + e.getMessage());
//            try {
//                Thread.sleep(RECONNECT_PAUSE);
//            } catch (InterruptedException e1) {
//                e1.printStackTrace();
//                return;
//            }
//            botConnect();
//        }
    }

}