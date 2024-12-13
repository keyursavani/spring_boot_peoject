package com.sport.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sport.dto.ApiResponseDTO;
import com.sport.dto.PlayerDTO;
import com.sport.pojos.SportType;
import com.sport.service.PlayerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

//@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/player")
@AllArgsConstructor
//@NoArgsConstructor
public class PlayerController {
//	@Autowired
	private PlayerService playerService;

//	public PlayerController() {
//		System.out.println("In Player Controller");
//	}

	@PostMapping
	public ResponseEntity<?> addNewPlayer(@RequestBody @Valid PlayerDTO playerDTO) {
		System.out.println("In addNewPlayer of " + getClass() + playerDTO);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ApiResponseDTO(HttpStatus.CREATED.value(), playerService.addNewPlayer(playerDTO)));
	}

	@GetMapping
	public ResponseEntity<?> getAllPlayer() {
		return ResponseEntity.ok(new ApiResponseDTO(HttpStatus.OK.value(), "success", playerService.getAllPlayer()));
	}

	@PutMapping("/{playerId}")
	public ResponseEntity<?> updatePlayer(@RequestBody @Valid PlayerDTO playerDTO, @PathVariable Long playerId) {
		System.out.println("In updatePlayer "+playerDTO+" "+playerId);
		return ResponseEntity.status(HttpStatus.OK).body(
				new ApiResponseDTO(HttpStatus.OK.value(), playerService.updatePlayerDetails(playerDTO, playerId)));
	}

	@GetMapping("/findBy/{sportType}")
	public ResponseEntity<?> getPlayerBySportType(@RequestBody @Valid @PathVariable SportType sportType) {
		return ResponseEntity
				.ok(new ApiResponseDTO(HttpStatus.OK.value(), "uccess", playerService.getPlayerBySportType(sportType)));
	}

	@DeleteMapping("/{playerId}")
	public ResponseEntity<?> deletePlayerById(@RequestBody @Valid @PathVariable Long playerId) {
		return ResponseEntity
				.ok(new ApiResponseDTO(HttpStatus.OK.value(), "success", playerService.deletePlayerById(playerId)));
	}
}
