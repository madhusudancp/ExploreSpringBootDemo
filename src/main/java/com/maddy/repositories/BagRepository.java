package com.maddy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maddy.entities.BagEntity;
@Repository
public interface BagRepository extends JpaRepository<BagEntity, Integer>{

	
	
}
