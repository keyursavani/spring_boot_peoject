package com.sport.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.sport.custome_exception.PlayerException;
import com.sport.dao.PlayerDao;
import com.sport.dto.PlayerDTO;
import com.sport.pojos.Player;
import com.sport.pojos.SportType;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

	private PlayerDao playerDao;
	private ModelMapper modelMapper;

	@Override
	public String addNewPlayer(PlayerDTO playerDTO) {
		Player player = modelMapper.map(playerDTO, Player.class);
		Player savePlayer = playerDao.save(player);
		return "Player Added with id " + savePlayer.getId();
	}

	@Override
	public List<PlayerDTO> getAllPlayer() {
		List<Player> players = playerDao.findAll();
		List<PlayerDTO> players2 = new ArrayList<>();
		for (Player p : players) {
			players2.add(modelMapper.map(p, PlayerDTO.class));
		}
		return players2;
	}

	@Override
	public String updatePlayerDetails(PlayerDTO playerDTO, long playerId) {
		if (playerDao.existsById(playerId)) {
			Player player = modelMapper.map(playerDTO, Player.class);
			player.setId(playerId);
			playerDao.save(player);
			return "Player updated";
		}
		throw new PlayerException("Invalid player id");
	}

	@Override
	public List<PlayerDTO> getPlayerBySportType(SportType sportType) {
		List<Player> playerList = playerDao.getPlayerBySportType(sportType);
		List<PlayerDTO> players = new ArrayList<>();
		for (Player p : playerList) {
			players.add(modelMapper.map(p, PlayerDTO.class));
		}
		return players;
	}

	@Override
	public String deletePlayerById(Long playerId) {
		if(playerDao.existsById(playerId)) {
			playerDao.deleteById(playerId);
			return "Player deleted";
		}
		throw new PlayerException("Invalid player id");
	}

}
