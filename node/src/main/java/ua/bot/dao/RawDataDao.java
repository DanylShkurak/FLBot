package ua.bot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.bot.entity.RawData;

public interface  RawDataDao extends JpaRepository<RawData,Long> {

}
