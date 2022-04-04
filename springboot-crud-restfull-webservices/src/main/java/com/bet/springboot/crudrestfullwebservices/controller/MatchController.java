/**
 * 
 */
package com.bet.springboot.crudrestfullwebservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bet.springboot.crudrestfullwebservices.exception.ResourceNotFoundException;
import com.bet.springboot.crudrestfullwebservices.model.Match;
import com.bet.springboot.crudrestfullwebservices.repository.MatchRepository;

/**
 * Rest controller for {@link Match}
 */

@RestController
@RequestMapping("/api/matches")
public class MatchController {
	@Autowired
	private MatchRepository matchRepository;

	// create get all matches api
	@GetMapping("/")
	public List<Match> getAllMatches() {
		return matchRepository.findAll();
	}

	// create a match
	@PostMapping("/")
	public Match createMatch(@Valid @RequestBody Match match) {
		return matchRepository.save(match);
	}

	// get a match by id
	@GetMapping("/{id}")
	public ResponseEntity<Match> getMatchById(@PathVariable(value = "id") long matchId)
			throws ResourceNotFoundException {
		Match match = matchRepository.findById(matchId)
				.orElseThrow(() -> new ResourceNotFoundException("Match with id: " + matchId + " not found!"));
		return ResponseEntity.ok().body(match);
	}

	// update match
	@PutMapping("/{id}")
	public ResponseEntity<Match> updateMatch(@PathVariable(value = "id") long matchId, @RequestBody Match matchDetails)
			throws ResourceNotFoundException {
		Match match = matchRepository.findById(matchId)
				.orElseThrow(() -> new ResourceNotFoundException("Match with id: " + matchId + " not found!"));
		//TODO: find a better way for null check
		if (matchDetails.getDescription()!= null)
			match.setDescription(matchDetails.getDescription());
		if (matchDetails.getMatchDate()!=null)
			match.setMatchDate(matchDetails.getMatchDate());
		if (matchDetails.getMatchTime()!=null)
			match.setMatchTime(matchDetails.getMatchTime());
		if (matchDetails.getTeamA()!=null)
			match.setTeamA(matchDetails.getTeamA());
		if (matchDetails.getTeamB()!=null)
			match.setTeamB(matchDetails.getTeamB());
		if (matchDetails.getSport()!=null)
			match.setSport(matchDetails.getSport());
		matchRepository.save(match);
		return ResponseEntity.ok().body(match);
	}

	// delete match
	@DeleteMapping("/{id}")
	public ResponseEntity<Match> deleteMatch(@PathVariable(value = "id") long matchId)
			throws ResourceNotFoundException {
		matchRepository.findById(matchId)
				.orElseThrow(() -> new ResourceNotFoundException("Match with id: " + matchId + " not found!"));
		matchRepository.deleteById(matchId);
		return ResponseEntity.ok().build();
	}

}
