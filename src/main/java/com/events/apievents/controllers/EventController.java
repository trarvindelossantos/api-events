package com.events.apievents.controllers;

import com.events.apievents.entities.Event;
import com.events.apievents.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/api/events")
    public List<Event> index() {
        return eventService.events();
    }

    @PostMapping("/api/events")
    public Event create(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    @GetMapping("/api/events/{id}")
    public Event get(@PathVariable(name = "id") Long id) {
        return eventService.getEvent(id);
    }

    @PutMapping("/api/events/{id}")
    public  Event update(@PathVariable(name = "id") Long id, @RequestBody Event event) {
        Event _event = eventService.getEvent(id);
        _event.setEvent_date((event.getEvent_date() != null) ? event.getEvent_date() : _event.getEvent_date() );
        _event.setEvent_description(event.getEvent_description() != null  ? event.getEvent_description() : _event.getEvent_description());
        _event.setEvent_type(event.getEvent_type() != null ? event.getEvent_type() : _event.getEvent_type() );
        return  eventService.saveEvent(_event);
    }

    @PutMapping("/api/events/{id}/status")
    public  Event updateStatus(@PathVariable(name = "id") Long id, @RequestBody Event event){
        Event eventData = eventService.getEvent(id);
        eventData.setIs_finish(!eventData.getIs_finish());
        return  eventService.saveEvent(eventData);
    }

    public  void delete(@PathVariable(name = "id") Long id) {
        eventService.deleteEvent(id);
    }



}
