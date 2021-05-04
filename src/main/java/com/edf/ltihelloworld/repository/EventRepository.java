package com.edf.ltihelloworld.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edf.ltihelloworld.entity.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
}
