/**
 * 
 */
package com.bet.springboot.crudrestfullwebservices.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.bet.springboot.crudrestfullwebservices.SpringbootCrudRestfullWebservicesApplication;
import com.bet.springboot.crudrestfullwebservices.model.Match;
import com.bet.springboot.crudrestfullwebservices.model.Sport;

/**
 * MVC tests for {@link MatchController}
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootCrudRestfullWebservicesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MatchControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void testGetAllMatches() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/matches/",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}
	
	@Test
	public void testGetMatchById() {
		Match match = restTemplate.getForObject(getRootUrl() + "/matches/1", Match.class);
		System.out.println(match.getDescription());
		assertNotNull(match);
	}

	@Test
	public void testCreateMatch() {
		Match match = new Match();
		match.setDescription("AEK-PAO");
		match.setMatchDate(new Date());
		match.setMatchTime(Calendar.getInstance());
		match.setSport(Sport.FOOTBALL);
		match.setTeamA("AEK");
		match.setTeamB("PAO");

		ResponseEntity<Match> postResponse = restTemplate.postForEntity(getRootUrl() + "/matches/", match, Match.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateMatch() {
		int id = 1;
		Match employee = restTemplate.getForObject(getRootUrl() + "/matches/" + id, Match.class);
		employee.setTeamA("OSFP");
		employee.setTeamB("PAOK");

		restTemplate.put(getRootUrl() + "/matches/" + id, employee);

		Match updatedMatch = restTemplate.getForObject(getRootUrl() + "/matches/" + id, Match.class);
		assertNotNull(updatedMatch);
	}

	@Test
	public void testDeleteMatch() {
		int id = 2;
		Match match = restTemplate.getForObject(getRootUrl() + "/matches/" + id, Match.class);
		assertNotNull(match);

		restTemplate.delete(getRootUrl() + "/matches/" + id);

		try {
			match = restTemplate.getForObject(getRootUrl() + "/matches/" + id, Match.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
