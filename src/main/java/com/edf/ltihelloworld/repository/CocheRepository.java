package com.edf.ltihelloworld.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edf.ltihelloworld.entity.Coche;


@Repository
public interface CocheRepository extends CrudRepository<Coche, Long> {

}
