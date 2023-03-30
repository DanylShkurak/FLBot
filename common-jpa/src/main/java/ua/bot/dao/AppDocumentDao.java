package ua.bot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bot.entity.AppDocument;

public interface AppDocumentDao extends JpaRepository<AppDocument,Long> {
}
