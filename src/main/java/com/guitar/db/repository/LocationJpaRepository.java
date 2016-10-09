package com.guitar.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.guitar.db.model.Location;

@RepositoryRestResource(exported=false)
public interface LocationJpaRepository extends JpaRepository<Location, Long> {
	List<Location> findByStateStartingWith(String stateName);
	Location findFirstByStateIgnoreCaseStartingWith(String stateName);
	List<Location> findTop5ByStateIgnoreCaseStartingWith(String stateName);
	List<Location> findDistinctByStateIgnoreCaseStartingWith(String stateName);
	
	List<Location> findByStateIgnoreCaseStartingWith(String stateName);

	List<Location> findByStateNotLike(String stateName);
	List<Location> findByStateNotLikeOrderByStateAsc(String stateName);

	List<Location> findByStateIsOrCountryEquals(String stateName, String Country);
	List<Location> findByStateNot(String stateName);
}
