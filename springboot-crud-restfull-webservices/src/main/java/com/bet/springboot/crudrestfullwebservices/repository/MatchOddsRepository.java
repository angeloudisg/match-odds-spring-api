/**
 * 
 */
package com.bet.springboot.crudrestfullwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bet.springboot.crudrestfullwebservices.model.MatchOdds;

/**
 * Repository for {@link MatchOdds}
 *
 */
@Repository
public interface MatchOddsRepository  extends JpaRepository<MatchOdds, Long> {

}
