package ua.bot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bot.entity.BinaryContent;

public interface BinaryContentDao extends JpaRepository<BinaryContent,Long> {
}
