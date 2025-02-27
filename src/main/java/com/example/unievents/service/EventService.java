package com.example.unievents.service;

import com.example.unievents.model.Event;
import com.example.unievents.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public Event getEventById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
    }

    public Event createEvent(Event event) {
        return repository.save(event);
    }

    public Event updateEvent(Integer id, Event eventDetails) {
        Event event = getEventById(id);
        event.setTitle(eventDetails.getTitle());
        event.setDate(eventDetails.getDate());
        event.setLocation(eventDetails.getLocation());
        event.setWebsite(eventDetails.getWebsite());
        event.setTime(eventDetails.getTime());
        event.setSocialNetworks(eventDetails.getSocialNetworks());
        return repository.save(event);
    }

    public void deleteEvent(Integer id) {
        repository.deleteById(id);
    }
}
