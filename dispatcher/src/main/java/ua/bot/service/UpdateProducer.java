package ua.bot.service;

import org.telegram.telegrambots.meta.api.objects.Update;
@FunctionalInterface
public interface UpdateProducer {
    void produce(String rabbitQueue, Update update);
}
