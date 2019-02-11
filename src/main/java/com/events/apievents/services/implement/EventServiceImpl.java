package com.events.apievents.services.implement;

import com.events.apievents.dao.EventDao;
import com.events.apievents.entities.Event;
import com.events.apievents.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;

    @Override
    public Event saveEvent(Event event) {
        return eventDao.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventDao.saveAndFlush(event);
    }

    @Override
    public List<Event> events() {
        return eventDao.findAll();
    }

    @Override
    public Event getEvent(Long id) {
        return eventDao.getOne(id);
    }

    @Override
    public void deleteEvent(Long id) {
        eventDao.deleteById(id);
    }


}
