package com.sport.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sport.pojos.Player;
import com.sport.pojos.SportType;

public interface PlayerDao  extends JpaRepository<Player, Long>{
  @Query("select p from Player p where p.sportType = :type")
  List<Player> getPlayerBySportType(SportType type);
}
