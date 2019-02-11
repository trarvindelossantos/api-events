package com.events.apievents.services.implement;

import com.events.apievents.dao.EventTypeDao;
import com.events.apievents.entities.EventType;
import com.events.apievents.services.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeServiceImpl implements EventTypeService {

    @Autowired
    private EventTypeDao eventTypeDao;

    @Override
    public EventType saveEventType(EventType eventType) {
        return eventTypeDao.save(eventType);
    }

    @Override
    public EventType updateEventType(EventType eventType, Integer id) {
        EventType eType = this.getEventType(id);
        eType.setDescription( (eventType.getDescription() != null ||eventType.getDescription() != "") ? eventType.getDescription() : eType.getDescription());
        return eventTypeDao.save(eType);
    }

    @Override
    public List<EventType> eventTypes() {
        return eventTypeDao.findAll();
    }

    @Override
    public EventType getEventType(Integer id) {
        return eventTypeDao.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        eventTypeDao.deleteById(id);
    }
}
