package ua.bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
@FunctionalInterface
public interface UpdateConsumer {
    void consume(SendMessage sendMessage);
}
