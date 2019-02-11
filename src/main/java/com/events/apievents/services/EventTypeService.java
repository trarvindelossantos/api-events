package com.events.apievents.services;


import com.events.apievents.entities.EventType;

import java.util.List;

public interface EventTypeService {

    EventType saveEventType(EventType eventType);

    EventType updateEventType(EventType eventType, Integer id);

    List<EventType> eventTypes();

    EventType getEventType(Integer id);

    void delete(Integer id);

}
