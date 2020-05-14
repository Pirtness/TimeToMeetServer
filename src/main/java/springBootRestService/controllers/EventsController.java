package springBootRestService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springBootRestService.entities.Event;
import springBootRestService.repos.EventRepo;

import javax.persistence.Lob;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/event")
public class EventsController {
    @Autowired
    private EventRepo eventRepo;

    @GetMapping("/get_all")
    public Iterable<Event> getEvents() {
        Iterable<Event> events = eventRepo.findAll();
        return events;
    }

    @GetMapping("/get_all/{username}")
    public Iterable<Event> getEventsOfUser(@PathVariable String username) {
        Iterable<Event> events = eventRepo.findByUsername(username);
        return events;
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
            event.get().change(newEvent);
            return event.get();
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventRepo.deleteById(id);
    }
}
