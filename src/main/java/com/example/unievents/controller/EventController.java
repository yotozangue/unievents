package com.example.unievents.controller;

import com.example.unievents.model.Event;
import com.example.unievents.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public String getAllEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("event", new Event());
        return "events/form";
    }

    @PostMapping
    public String createEvent(@ModelAttribute Event event) {
        eventService.createEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("event", eventService.getEventById(id));
        return "events/form";
    }

    @PostMapping("/update/{id}")
    public String updateEvent(@PathVariable Integer id, @ModelAttribute Event event) {
        eventService.updateEvent(id, event);
        return "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
        return "redirect:/events";
    }
}
