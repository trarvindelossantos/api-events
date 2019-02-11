package com.events.apievents.controllers;


import com.events.apievents.entities.EventType;
import com.events.apievents.services.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventTypeController {

    @Autowired
    private EventTypeService eventTypeService;

    @GetMapping("/api/event-types")
    public List<EventType> index(){
        return eventTypeService.eventTypes();
    }

    @PostMapping("/api/event-types")
    public EventType create(@RequestBody EventType eventType) {
        return  eventTypeService.saveEventType(eventType);
    }

    @GetMapping("/api/event-types/{id}")
    public  EventType get(@PathVariable(name = "id") Integer id){
        return eventTypeService.getEventType(id);
    }

    @PutMapping("/api/event-types/{id}")
    public EventType update(@PathVariable(name = "id") Integer id, @RequestBody EventType eventType){
        EventType eventTypeData = eventTypeService.getEventType(id);
        eventTypeData.setDescription(eventType.getDescription());
        return eventTypeService.saveEventType(eventTypeData);
    }

}
