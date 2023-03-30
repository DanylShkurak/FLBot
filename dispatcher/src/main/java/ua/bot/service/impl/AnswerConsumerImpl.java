package ua.bot.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ua.bot.controller.UpdateMessageController;
import ua.bot.service.UpdateConsumer;

import static ua.bot.RabbitQueue.ANSWER_MESSAGE;
@Service
public class AnswerConsumerImpl implements UpdateConsumer {
    private final UpdateMessageController updateMessageController;

    public AnswerConsumerImpl(UpdateMessageController updateMessageController) {
        this.updateMessageController = updateMessageController;
    }

    @Override
    @RabbitListener(queues = ANSWER_MESSAGE)
    public void consume(SendMessage sendMessage) {
       updateMessageController.setView(sendMessage);
    }
}
