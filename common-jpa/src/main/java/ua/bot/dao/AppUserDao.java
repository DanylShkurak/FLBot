package ua.bot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bot.entity.AppUser;

public interface AppUserDao extends JpaRepository<AppUser,Long> {
    AppUser findAppUserByTelegramUserId(Long id);
}
