package ua.bot.service.impl;

import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import ua.bot.dao.AppDocumentDao;
import ua.bot.dao.AppPhotoDao;
import ua.bot.entity.AppDocument;
import ua.bot.entity.AppPhoto;
import ua.bot.entity.BinaryContent;
import ua.bot.service.FileService;
import ua.bot.utils.CryptoTool;

import java.io.File;
import java.io.IOException;

@Service
@Log4j
public class FileServiceImpl implements FileService {

    private final AppPhotoDao appPhotoDao;
    private final AppDocumentDao appDocumentDao;
    private final CryptoTool cryptoTool;

    public FileServiceImpl(AppPhotoDao appPhotoDao, AppDocumentDao appDocumentDao, CryptoTool cryptoTool) {
        this.appPhotoDao = appPhotoDao;
        this.appDocumentDao = appDocumentDao;
        this.cryptoTool = cryptoTool;
    }

    @Override
    public AppDocument getDocument(String documentId) {
        Long id = cryptoTool.idOf(documentId);
        if (id==null){
            return null;
        }
        return appDocumentDao.findById(id).orElse(null);
    }

    @Override
    public AppPhoto getPhoto(String documentId) {
        Long id = cryptoTool.idOf(documentId);
        if (id==null){
            return null;
        }
        return appPhotoDao.findById(id).orElseThrow();
    }

    @Override
    public FileSystemResource getFileSystemResource(BinaryContent binaryContent) {
        try {
            File temp = File.createTempFile("tempFile", ".bin");
            temp.deleteOnExit();
            FileUtils.writeByteArrayToFile(temp, binaryContent.getFileAsArrayOfBytes());
            return new FileSystemResource(temp);
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }
}