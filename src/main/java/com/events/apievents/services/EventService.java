package com.events.apievents.services;

import com.events.apievents.entities.Event;

import java.util.List;

public interface EventService {

    Event saveEvent(Event event);

    Event updateEvent(Event event, Long id);

    List<Event> events();

    Event getEvent(Long  id);


    void deleteEvent(Long id);

    Event updateStatus(Long id);


}
