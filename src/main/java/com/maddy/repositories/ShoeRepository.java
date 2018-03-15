package com.maddy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maddy.entities.ShoeEntity;
@Repository
public interface ShoeRepository extends JpaRepository<ShoeEntity, Integer>{

}
