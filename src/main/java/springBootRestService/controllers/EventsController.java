package springBootRestService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springBootRestService.entities.Event;
import springBootRestService.repos.EventRepo;

import javax.persistence.Lob;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class EventsController {
    @Autowired
    private EventRepo eventRepo;

    @GetMapping("/{id}")
            public Event getEvent(@PathVariable Long id) {
        Optional<Event> event = eventRepo.findById(id);
        if (event.isPresent()) {
            return event.get();
        }
        return null;
    }

    @GetMapping("/get_all")
    public List<Event> getEvents() {
        Iterable<Event> events = eventRepo.findAll();
        List<Event> list = new ArrayList<>();
        events.forEach(list::add);
        return list;
    }

    @GetMapping("/get_all/{username}")
    public List<Event> getEventsOfUser(@PathVariable String username) {
        Iterable<Event> events = eventRepo.findByUsername(username);
        List<Event> list = new ArrayList<>();
        events.forEach(list::add);
        return list;
    }

    @PostMapping("/create")
    public Event createEvent(@RequestBody Event event) {
        eventRepo.save(event);
        return event;
    }

    @PutMapping("/change/{id}")
    public Event changeEvent(@PathVariable Long id, @RequestBody Event newEvent) {
        Optional<Event> event = eventRepo.findById(id);
        if (event.isPresent()) {
            Event e = event.get();
            e.change(newEvent);
            eventRepo.save(e);
            eventRepo.flush();
            return event.get();
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventRepo.deleteById(id);
    }
}
