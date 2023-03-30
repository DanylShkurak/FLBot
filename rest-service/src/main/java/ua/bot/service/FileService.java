package ua.bot.service;

import org.springframework.core.io.FileSystemResource;
import ua.bot.entity.AppDocument;
import ua.bot.entity.AppPhoto;
import ua.bot.entity.BinaryContent;

public interface FileService {
    AppDocument getDocument(String id);
    AppPhoto getPhoto(String id);
    FileSystemResource getFileSystemResource(BinaryContent binaryContent);
}
