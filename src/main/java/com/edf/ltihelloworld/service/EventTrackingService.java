package com.edf.ltihelloworld.service;

import java.time.Instant;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edf.ltihelloworld.entity.Event;
import com.edf.ltihelloworld.repository.EventRepository;

@Service
@Slf4j
public class EventTrackingService {

    @Autowired
    private EventRepository eventRepository;

    public Iterable<Event> getAllEvents() {
        log.debug("Getting all the events from the table.");
        return eventRepository.findAll();
    }

    public void postEvent(String eventType, String eventUser, String eventCourse, String eventDetails) {
        log.debug("Event {} posted for the user {} with details {}.", eventType, eventUser, eventDetails);
        Event event = new Event();
        event.setEventType(eventType);
        event.setEventUser(eventUser);
        event.setEventCourse(eventCourse);
        event.setEventDetails(eventDetails);
        event.setEventDate(Instant.now());
        eventRepository.save(event);
    }

    public void postEvent(String eventType, String eventUser) {
        this.postEvent(eventType, eventUser, StringUtils.EMPTY, StringUtils.EMPTY);
    }

    public void postEvent(String eventType, String eventUser, String eventCourse) {
        this.postEvent(eventType, eventUser, eventCourse, StringUtils.EMPTY);
    }

    public long getEventCount() {
        log.debug("Getting the event count from the table.");
        return eventRepository.count();
    }

}
