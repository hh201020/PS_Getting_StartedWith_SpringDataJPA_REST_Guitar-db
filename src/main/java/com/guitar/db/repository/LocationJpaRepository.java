package com.guitar.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guitar.db.model.Location;

public interface LocationJpaRepository extends JpaRepository<Location, Long> {
	List<Location> findByStateStartingWith(String stateName);
	List<Location> findByStateIgnoreCaseStartingWith(String stateName);

	List<Location> findByStateNotLike(String stateName);
	List<Location> findByStateNotLikeOrderByStateAsc(String stateName);

	List<Location> findByStateIsOrCountryEquals(String stateName, String Country);
	List<Location> findByStateNot(String stateName);
}
