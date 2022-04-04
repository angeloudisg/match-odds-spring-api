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
import com.bet.springboot.crudrestfullwebservices.model.MatchOdds;
import com.bet.springboot.crudrestfullwebservices.repository.MatchOddsRepository;

/**
 * Rest controller for {@link MatchOdds}
 */

@RestController
@RequestMapping("/api/odds")
public class MatchOddsController {
	@Autowired
	private MatchOddsRepository matchOddsRepository;
	
	// create get all match odds api
	@GetMapping("/")
	public List<MatchOdds> getAllMatchOdds() {
		return matchOddsRepository.findAll();
	}
	
	// get match odd by id
	@GetMapping("/{id}")
	public ResponseEntity<MatchOdds> getMatchOddById(@PathVariable(value = "id") long oddId)
			throws ResourceNotFoundException {
		MatchOdds odd = matchOddsRepository.findById(oddId)
				.orElseThrow(() -> new ResourceNotFoundException("Match odd with id: " + oddId + " not found!"));
		return ResponseEntity.ok().body(odd);
	}
	
	// create a match odd
	@PostMapping("/")
	public MatchOdds createMatchOdd(@Valid @RequestBody MatchOdds odd) {
		return matchOddsRepository.save(odd);
	}
	
	// delete match odd
	@DeleteMapping("/{id}")
	public ResponseEntity<MatchOdds> deleteMatchOdd(@PathVariable(value = "id") long oddId)
			throws ResourceNotFoundException {
		matchOddsRepository.findById(oddId)
				.orElseThrow(() -> new ResourceNotFoundException("Match odd with id: " + oddId + " not found!"));
		matchOddsRepository.deleteById(oddId);
		return ResponseEntity.ok().build();
	}
	
	// update match odd
	@PutMapping("/{id}")
	public ResponseEntity<MatchOdds> updateMatchOdd(@PathVariable(value = "id") long oddId, @RequestBody MatchOdds matchOddsDetails)
			throws ResourceNotFoundException {
		MatchOdds odd = matchOddsRepository.findById(oddId)
				.orElseThrow(() -> new ResourceNotFoundException("Match odd with id: " + oddId + " not found!"));
		if (matchOddsDetails.getMatchId()!= 0)
			odd.setMatchId(matchOddsDetails.getMatchId());
		if (matchOddsDetails.getSpecifier()!= null)
				odd.setSpecifier(matchOddsDetails.getSpecifier());
		if(matchOddsDetails.getOdd()!= 0)
			odd.setOdd(matchOddsDetails.getOdd());
		matchOddsRepository.save(odd);
		return ResponseEntity.ok().body(odd);
	}

}
