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
        return  eventService.updateEvent(event, id);
    }

    @PutMapping("/api/events/{id}/status")
    public  Event updateStatus(@PathVariable(name = "id") Long id){
        return  eventService.updateStatus(id);
    }

    @DeleteMapping("/api/events/{id}")
    public  void delete(@PathVariable(name = "id") Long id) {
        eventService.deleteEvent(id);
    }



}
