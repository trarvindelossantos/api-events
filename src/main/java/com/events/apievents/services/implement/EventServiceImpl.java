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
    public Event updateEvent(Event event, Long id) {
        Event _event = this.getEvent(id);
        _event.setEvent_date((event.getEvent_date() != null) ? event.getEvent_date() : _event.getEvent_date() );
        _event.setEvent_description(event.getEvent_description() != null  ? event.getEvent_description() : _event.getEvent_description());
        _event.setEvent_type(event.getEvent_type() != null ? event.getEvent_type() : _event.getEvent_type() );
        return eventDao.save(_event);
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

    @Override
    public Event updateStatus(Long id) {
        Event _event = this.getEvent(id);
        _event.setIs_finish(!_event.getIs_finish());
        return eventDao.save(_event);
    }
}
