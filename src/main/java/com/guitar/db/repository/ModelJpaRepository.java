package com.guitar.db.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.guitar.db.model.Model;

public interface ModelJpaRepository extends JpaRepository<Model, Long> , ModelJpaRepositoryCustom{
	List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal lowest, BigDecimal highest);
	
	List<Model> findByModelTypeNameIn(List<String> types);  // Smart part of JPA
	
	@Query("select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood")
	Page<Model> queryByPriceRangeAndWoodType(@Param("lowest") BigDecimal lowest,
											 @Param("highest") BigDecimal highest,	
											 @Param("wood") String wood,
											 Pageable page);
	
	List<Model> findAllModelsByType(@Param("name") String name);
}
