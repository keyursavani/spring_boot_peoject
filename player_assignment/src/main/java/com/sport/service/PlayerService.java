package com.sport.service;

import java.util.List;

import com.sport.dto.PlayerDTO;
import com.sport.pojos.SportType;

public interface PlayerService {
	public String addNewPlayer(PlayerDTO playerDTO);

	public List<PlayerDTO> getAllPlayer();

	public String updatePlayerDetails(PlayerDTO playerDTO, long playerId);
	
	public List<PlayerDTO> getPlayerBySportType(SportType sportType);
	
	public String deletePlayerById(Long playerId);

}
