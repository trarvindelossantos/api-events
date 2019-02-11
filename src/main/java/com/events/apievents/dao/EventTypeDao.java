package com.events.apievents.dao;

import com.events.apievents.entities.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeDao extends JpaRepository<EventType, Integer> {
}
