package ua.bot.service;

import org.telegram.telegrambots.meta.api.objects.Message;
import ua.bot.entity.AppDocument;
import ua.bot.entity.AppPhoto;
import ua.bot.service.enums.LinkType;

public interface FileService {
    AppDocument processDoc(Message telegramMessage);
    AppPhoto processPhoto(Message telegramMessage);
    String generateLink(Long docId, LinkType linkType);
}
