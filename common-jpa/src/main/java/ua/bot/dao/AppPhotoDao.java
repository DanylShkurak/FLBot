package ua.bot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bot.entity.AppPhoto;

public interface AppPhotoDao extends JpaRepository<AppPhoto,Long> {
}
