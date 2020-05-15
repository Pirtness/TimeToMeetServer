package springBootRestService.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import springBootRestService.entities.Event;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, Long> {

    List<Event> findByUsername(String username);
    //List<Event> findById(Long id);
}
