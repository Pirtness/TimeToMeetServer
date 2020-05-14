package springBootRestService.repos;

import org.springframework.data.repository.CrudRepository;
import springBootRestService.entities.Event;

import java.util.List;

public interface EventRepo extends CrudRepository<Event, Long> {

    List<Event> findByUsername(String username);
    //List<Event> findById(Long id);
}
