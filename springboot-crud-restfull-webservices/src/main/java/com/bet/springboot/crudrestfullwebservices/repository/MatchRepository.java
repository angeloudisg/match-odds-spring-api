/**
 * 
 */
package com.bet.springboot.crudrestfullwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bet.springboot.crudrestfullwebservices.model.Match;

/**
 * Repository for {@link Match}
 */
@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

}
