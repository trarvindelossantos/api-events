package com.events.apievents.services;


import com.events.apievents.entities.EventType;

import java.util.List;

public interface EventTypeService {

    EventType saveEventType(EventType eventType);

    EventType updateEventType(EventType eventType);

    List<EventType> eventTypes();

    EventType getEventType(Integer id);



}
